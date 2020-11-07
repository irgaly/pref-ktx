package net.irgaly.pref.sample

import android.content.Context
import kotlinx.serialization.json.Json
import net.irgaly.pref.boolean
import net.irgaly.pref.json
import net.irgaly.pref.sample.entity.JsonValue
import net.irgaly.pref.string

class PreferencesStore(context: Context) {
    private val preferences = context.getSharedPreferences("prefktx", Context.MODE_PRIVATE)
    private val json = Json { }

    var checkValue: Boolean by preferences.boolean(false)
    var textValue: String by preferences.string("")
    var jsonValue: JsonValue by preferences.json(json, lazy { JsonValue() })
}
