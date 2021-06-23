package com.example.androidportfolio.uilibrary.ui

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.androidportfolio.R
import com.example.androidportfolio.databinding.ActionLabelBinding
import com.example.androidportfolio.util.dpToPx
import com.example.androidportfolio.util.setMargins

/**
 * Label element that has some action associated. Possible actions:
 *   - Navigation
 *   - Click action (with normal styling)
 *   - Click action (with bold title)
 *   - Switch
 *
 * UI elements that the view can contain:
 *   - Icon
 *   - Text icon with background
 *   - Title, multirow
 *   - Subtitle, multirow
 *   - Switch
 *   - Loading indicator
 */
class ActionLabel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = ActionLabelBinding.inflate(LayoutInflater.from(context), this)

    private var onCheckedChanged: ((Boolean) -> Unit)? = null

    private val mode: ActionMode

    init {
        val padding = resources.getDimensionPixelSize(R.dimen.spacing_m)
        setPadding(padding, padding, padding, padding)

        // Widget custom attributes
        with(context.obtainStyledAttributes(attrs, R.styleable.ActionLabel)) {
            mode = ActionMode.fromValue(getInt(R.styleable.ActionLabel_action_mode, 0))
            setupMode(mode)

            setTitle(getString(R.styleable.ActionLabel_title))
            setSubtitle(getString(R.styleable.ActionLabel_subtitle))
            setIcon(getResourceId(R.styleable.ActionLabel_icon, 0))
            setTextIcon(getString(R.styleable.ActionLabel_text_icon))
            setTextIconSize(
                getDimension(R.styleable.ActionLabel_text_icon_size, resources.dpToPx(16))
            )
            setTextIconColor(getResourceId(R.styleable.ActionLabel_text_icon_color, R.color.black))
            setTextIconBackground(getResourceId(R.styleable.ActionLabel_text_icon_background, 0))

            recycle()
        }
    }

    private fun setupMode(mode: ActionMode) {
        when (mode) {
            ActionMode.NAVIGATION -> {
                binding.arrow.isVisible = true
            }
            ActionMode.ACTION -> {
                binding.arrow.isVisible = false
            }
            ActionMode.ACTION_BOLD -> {
                binding.arrow.isVisible = false
                binding.title.setTextAppearance(R.style.TextAppearance_BankingApp_ButtonMedium)
            }
        }
    }

    fun setTitle(title: String?) {
        binding.title.isVisible = !title.isNullOrEmpty()
        binding.title.text = title

        updateIconPlacement()
    }

    fun setSubtitle(subtitle: String?) {
        binding.subtitle.text = subtitle
        binding.subtitle.isVisible = !subtitle.isNullOrEmpty()

        updateIconPlacement()
    }

    fun setTextColor(color: Int) {
        binding.title.setTextColor(resources.getColor(color, null))
    }

    fun setIcon(@DrawableRes iconId: Int) {
        if (iconId != 0) {
            binding.icon.setImageDrawable(AppCompatResources.getDrawable(context, iconId))
        }

        updateIconVisibility()
    }

    fun setTextIcon(text: String?) {
        if (text != null) {
            binding.textIcon.text = text
        }

        updateIconVisibility()
    }

    fun setTextIconSize(size: Float) {
        binding.textIcon.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
    }

    fun setTextIconColor(color: Int) {
        binding.textIcon.setTextColor(resources.getColor(color, context.theme))
    }

    fun setTextIconBackground(drawableRes: Int) {
        binding.textIcon.setBackgroundResource(drawableRes)
    }

    fun setLoading(loading: Boolean) {
        binding.loading.isInvisible = !loading

        when (mode) {
            ActionMode.NAVIGATION -> binding.arrow.isInvisible = loading
            ActionMode.ACTION -> Unit
            ActionMode.ACTION_BOLD -> Unit
        }
    }

    fun setOnCheckedChangeListener(onCheckedChanged: (Boolean) -> Unit) {
        this.onCheckedChanged = onCheckedChanged
    }

    private fun updateIconVisibility() {
        binding.textIcon.isVisible = !binding.textIcon.text.isNullOrEmpty()

        // Text icon constraints are based on icon, so icon needs to be invisible
        // if text icon is used
        binding.icon.visibility = when {
            binding.icon.drawable != null -> VISIBLE
            !binding.textIcon.text.isNullOrEmpty() -> INVISIBLE
            else -> GONE
        }
    }

    private fun updateIconPlacement() {
        // Icon is centered when there's no subtitle
        if (binding.subtitle.text.isNullOrEmpty()) {
            applyIconCenterConstraints()
        } else {
            applyIconSubtitleConstraints()
        }
    }

    private fun applyIconSubtitleConstraints() {
        ConstraintSet().apply {
            clone(binding.root as ConstraintLayout)
            clear(binding.icon.id, ConstraintSet.BOTTOM)
            applyTo(binding.root as ConstraintLayout)
        }

        val topMargin = resources.getDimensionPixelSize(R.dimen.spacing_xs)
        val endMargin = resources.getDimensionPixelSize(R.dimen.spacing_m)
        binding.icon.setMargins(0, topMargin, endMargin, 0)
    }

    private fun applyIconCenterConstraints() {
        ConstraintSet().apply {
            clone(binding.root as ConstraintLayout)

            clear(binding.icon.id, ConstraintSet.BOTTOM)
            connect(binding.icon.id, ConstraintSet.BOTTOM, binding.root.id, ConstraintSet.BOTTOM)

            applyTo(binding.root as ConstraintLayout)
        }

        val endMargin = resources.getDimensionPixelSize(R.dimen.spacing_m)
        binding.icon.setMargins(0, 0, endMargin, 0)
    }

    /**
     * Different modes supported by the component.
     */
    enum class ActionMode {
        NAVIGATION,
        ACTION,
        ACTION_BOLD;

        companion object {
            fun fromValue(value: Int): ActionMode {
                return when (value) {
                    NAVIGATION.ordinal -> NAVIGATION
                    ACTION.ordinal -> ACTION
                    ACTION_BOLD.ordinal -> ACTION_BOLD
                    else -> throw IllegalStateException("Unknown mode $value")
                }
            }
        }
    }
}
