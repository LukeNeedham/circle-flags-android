package com.lukeneedham.circleflagsandroid

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

object FlagProvider {
    private const val DRAWABLE_TYPE = "drawable"
    private const val FLAG_NAME_PREFIX = "flag_"

    fun getFlagResourceFromCountryAlpha2Code(alpha2Code: String, context: Context): Drawable? {
        val resourceId = context.resources.getIdentifier(
            FLAG_NAME_PREFIX + alpha2Code,
            DRAWABLE_TYPE,
            context.packageName
        )
        return ContextCompat.getDrawable(context, resourceId)
    }
}
