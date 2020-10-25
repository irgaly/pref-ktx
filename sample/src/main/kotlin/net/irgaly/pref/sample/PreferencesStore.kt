package net.irgaly.pref.sample

import android.content.Context
import src.net.irgaly.pref.boolean
import src.net.irgaly.pref.string

class PreferencesStore(context: Context) {
    private val preferences = context.getSharedPreferences("prefktx", Context.MODE_PRIVATE)

    var checkValue: Boolean by preferences.boolean(false)
    var textValue: String by preferences.string("")
}
