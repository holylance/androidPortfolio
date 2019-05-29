package com.example.androidportfolio.scrollviewwithkeyboard

import android.graphics.Rect
import android.os.Build
import android.view.ViewTreeObserver
import android.view.Window

class KeyboardUtil(
  private val window: Window,
  private val onShowKeyboard: ((keyboardHeight: Int) -> Unit)? = null,
  private val onHideKeyboard: (() -> Unit)? = null
) {
  companion object {
    private const val MIN_KEYBOARD_HEIGHT_PX = 150
  }
  private val windowVisibleDisplayFrame = Rect()
  private var mnLastVisibleDecorViewHeight: Int = 0

  private val onGlobalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
    window.decorView.getWindowVisibleDisplayFrame(windowVisibleDisplayFrame)
    val nVisibleDecorViewHeight = windowVisibleDisplayFrame.height()

    // Decide whether keyboard is visible from changing decor view height.
    if (mnLastVisibleDecorViewHeight != 0) {
      if (mnLastVisibleDecorViewHeight > nVisibleDecorViewHeight + MIN_KEYBOARD_HEIGHT_PX) {
        // Calculate current keyboard height (this includes also navigation bar height when in fullscreen mode).
        val nCurrentKeyboardHeight = window.decorView.height - windowVisibleDisplayFrame.bottom
        // Notify listener about keyboard being shown.
        onShowKeyboard?.invoke(nCurrentKeyboardHeight)
      } else if (mnLastVisibleDecorViewHeight + MIN_KEYBOARD_HEIGHT_PX < nVisibleDecorViewHeight) {
        // Notify listener about keyboard being hidden.
        onHideKeyboard?.invoke()
      }
    }
    // Save current decor view height for the next call.
    mnLastVisibleDecorViewHeight = nVisibleDecorViewHeight
  }

  init {
    window.decorView.viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener)
  }

  fun detachKeyboardListeners() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      window.decorView.viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener)
    } else {
      window.decorView.viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener)
    }
  }
}
