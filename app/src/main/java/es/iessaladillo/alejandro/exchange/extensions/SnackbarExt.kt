@file:JvmName("SnackbarExt")
package es.iessaladillo.alejandro.exchange.extensions

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import es.iessaladillo.alejandro.exchange.R

fun View.snackbar(message: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration)
            .setBackgroundTint(context.getColor(R.color.violet_light))
            .setTextColor(context.getColor(R.color.yellow))
            .show()
}

fun View.snackbar(message: String, length: Int = Snackbar.LENGTH_SHORT, actionText: String = "", action: (View) -> Unit = {}) {
    Snackbar.make(this, message, length)
            .setAction(actionText) { v -> action(v) }
            .show()
}

fun View.snackbar(@StringRes messageResId: Int, length: Int = Snackbar.LENGTH_SHORT, actionText:
String = "", action: (View) -> Unit = {}) {
    Snackbar.make(this, messageResId, length)
            .setAction(actionText) { v -> action(v) }
            .show()
}