@file:Suppress("unused")

package src.net.irgaly.pref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

inline fun <T : Any> SharedPreferences.delegate(
    defaultValue: T,
    key: String?,
    crossinline getter: SharedPreferences.(key: String, defaultValue: T) -> T?,
    crossinline setter: SharedPreferences.Editor.(key: String, value: T) -> SharedPreferences.Editor
) = object : ReadWriteProperty<Any, T> {
    override fun getValue(thisRef: Any, property: KProperty<*>) =
        getter(key ?: property.name, defaultValue) ?: defaultValue

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) =
        edit().setter(key ?: property.name, value).apply()
}

inline fun <T : Any> SharedPreferences.nullableDelegate(
    dummy: T,
    key: String?,
    crossinline getter: SharedPreferences.(key: String, defaultValue: T) -> T?,
    crossinline setter: SharedPreferences.Editor.(key: String, value: T) -> SharedPreferences.Editor
) = object : ReadWriteProperty<Any, T?> {
    override fun getValue(thisRef: Any, property: KProperty<*>): T? {
        val target = key ?: property.name
        return if (contains(target)) getter(target, dummy) else null
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) {
        val target = key ?: property.name
        if (value == null) {
            edit().remove(target).apply()
        } else {
            edit().setter(target, value).apply()
        }
    }
}
