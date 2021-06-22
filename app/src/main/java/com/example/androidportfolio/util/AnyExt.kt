package com.example.androidportfolio.util

/**
 * Enforces branch exhaustiveness in `when` blocks.
 */
val <T> T.exhaustive: T
    get() = this

/**
 * Runs the block if object is null.
 */
inline fun <T> T?.ifNull(block: () -> Unit): T? {
    if (this == null) block()
    return this
}
