package com.example.androidportfolio.base

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.androidportfolio.R
import com.example.androidportfolio.util.getSlideAnimNavOptionsBuilder
import com.example.androidportfolio.util.safeNavigate
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseFragment(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    constructor() : this(0)

    protected open val fragmentOptions = FragmentOptions()
    private val compositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // By default the fragment draws under status bar due to our full screen setting in
        // [BaseActivity]. If that is undesired, this option will add view padding to prevent it.
        if (!fragmentOptions.drawUnderStatusBar) {
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->
                view.setPadding(0, insets.systemWindowInsetTop, 0, 0)
                insets
            }
        }

        setNavigationIcon()
        initToolbar()
        restoreViewState()
        observeViewState()
    }

    private fun initToolbar() {
        getFragmentToolbar()?.apply {
            // If no title has been set, suppress setting app name as title
            if (title.isNullOrEmpty()) title = ""

            // Required for toolbar actions such as PDF preview
            (activity as AppCompatActivity).setSupportActionBar(this)

            // Handle toolbar back button
            setNavigationOnClickListener {
                onToolbarNavigateBack()
            }
        }
    }

    protected open fun setNavigationIcon() {
        // Toolbar back button cross/arrow
        getFragmentToolbar()?.setNavigationIcon(
            when (findNavController().previousBackStackEntry) {
                null -> {
                    R.drawable.ic_toolbar_close
                }
                else -> R.drawable.ic_toolbar_back
            }
        )
    }

    override fun onResume() {
        super.onResume()

        bindProperties(compositeDisposable)
    }

    override fun onPause() {
        compositeDisposable.clear()
        super.onPause()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    /**
     * Safe navigation for Fragments. Fragments should always use this instead of
     * directly calling the NavController extension method.
     */
    protected fun safeNavigate(
        navActionId: Int,
        bundle: Bundle? = null,
        extras: FragmentNavigator.Extras? = null,
        animationBuilder: NavOptions.Builder = getSlideAnimNavOptionsBuilder()
    ) {
        if (isAdded) {
            findNavController()
                .safeNavigate(navActionId, bundle, extras, animationBuilder)
        }
    }

    protected fun safeNavigate(directions: NavDirections) {
        safeNavigate(directions.actionId, directions.arguments)
    }

    protected fun onToolbarNavigateBack() {
        if (!findNavController().popBackStack()) requireActivity().onBackPressed()
    }

    /**
     * Method fragments should use to restore view state from ViewModel.
     */
    open fun restoreViewState() = Unit

    /**
     * Method fragments should use to set view state and observe any future changes.
     */
    open fun observeViewState() = Unit

    /**
     * Method fragments should use to subscribe to data sources.
     */
    open fun bindProperties(disposable: CompositeDisposable) = Unit

    open fun getFragmentToolbar(): Toolbar? = null

    protected fun bind(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    /**
     * Observe result value from navigation destination.
     *
     * See https://developer.android.com/guide/navigation/navigation-programmatic for details
     * regarding result sharing between navigation destinations.
     */
    protected fun <T> observeNavigationResult(
        @IdRes destinationId: Int,
        key: String,
        callback: (T) -> Unit
    ) {
        val navBackStackEntry = findNavController().getBackStackEntry(destinationId)

        // Create our observer and add it to the NavBackStackEntry's lifecycle
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME && navBackStackEntry.savedStateHandle.contains(key)) {
                val result = navBackStackEntry.savedStateHandle.remove<T>(key)
                if (result != null) callback.invoke(result)
            }
        }

        navBackStackEntry.lifecycle.addObserver(observer)

        // As addObserver() does not automatically remove the observer, we
        // call removeObserver() manually when the view lifecycle is destroyed
        viewLifecycleOwner.lifecycle.addObserver(
            LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_DESTROY) {
                    navBackStackEntry.lifecycle.removeObserver(observer)
                }
            }
        )
    }

    protected fun observeNavigationResume(
        @IdRes destinationId: Int,
        callback: () -> Unit
    ) {
        val navBackStackEntry = findNavController().getBackStackEntry(destinationId)

        // Create our observer and add it to the NavBackStackEntry's lifecycle
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) callback.invoke()
        }

        navBackStackEntry.lifecycle.addObserver(observer)

        // As addObserver() does not automatically remove the observer, we
        // call removeObserver() manually when the view lifecycle is destroyed
        viewLifecycleOwner.lifecycle.addObserver(
            LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_DESTROY) {
                    navBackStackEntry.lifecycle.removeObserver(observer)
                }
            }
        )
    }

    /**
     * Class for setting options affecting the Fragment behaviour.
     *
     * @param drawUnderStatusBar Whether the fragment layout should extend under the status bar
     */
    protected data class FragmentOptions(
        val drawUnderStatusBar: Boolean = false
    )
}
