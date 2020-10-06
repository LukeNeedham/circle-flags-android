package com.lukeneedham.circleflagsandroid

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

object FlagProvider {
    private const val DRAWABLE_TYPE = "drawable"
    private const val FLAG_NAME_PREFIX = "flag_"

    /**
     * @return the flag resource id for [alpha2Code],
     * or 0 (the invalid resource id) if no flag is found
     */
    fun getFlagResIdFromCountryAlpha2Code(alpha2Code: String, context: Context): Int {
        return context.resources.getIdentifier(
            FLAG_NAME_PREFIX + alpha2Code,
            DRAWABLE_TYPE,
            context.packageName
        )
    }

    /**
     * @return the flag drawable for [alpha2Code],
     * or null if no flag is found
     */
    fun getFlagFromCountryAlpha2Code(alpha2Code: String, context: Context): Drawable? {
        val resourceId = getFlagResIdFromCountryAlpha2Code(alpha2Code, context)
        if (resourceId == 0) {
            return null
        }
        return ContextCompat.getDrawable(context, resourceId)
    }

    fun getUnknownFlagResId(): Int {
        return R.drawable.flag_xx
    }

    fun getUnknownFlag(context: Context): Drawable {
        return ContextCompat.getDrawable(context, getUnknownFlagResId())
            ?: error("The unknown flag is missing")
    }
}
