package abhu.loves.varshu.utils

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import androidx.core.content.ContextCompat

class ViewUtils {
    companion object {
        fun changeDrawableColor(context: Context, drawable: Drawable, color: Int) {
            if (drawable is ShapeDrawable) {
                drawable.paint.color = ContextCompat.getColor(context, color)
            } else if (drawable is GradientDrawable) {
                drawable.setColor(
                    ContextCompat.getColor(
                        context,
                        color
                    )
                )
            } else if (drawable is ColorDrawable) {
                drawable.color = ContextCompat.getColor(
                    context,
                    color
                )
            }
        }
    }
}