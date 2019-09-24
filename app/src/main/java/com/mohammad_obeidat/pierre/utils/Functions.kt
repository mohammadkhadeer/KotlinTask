package com.mohammad_obeidat.pierre.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.graphics.Typeface
import java.util.*

class Functions {

    fun changeFont (context: Context): Typeface? {
        val typeFace = Typeface.createFromAsset(context!!.assets, "frutiger-lt-arabic-55-roman.ttf")
        return typeFace;
    }

    fun changeLanguage(activity: Activity)
    {
        val lang = "ar"
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        activity.baseContext.resources.updateConfiguration(
            config,
            activity.baseContext.resources.displayMetrics
        )
    }
}