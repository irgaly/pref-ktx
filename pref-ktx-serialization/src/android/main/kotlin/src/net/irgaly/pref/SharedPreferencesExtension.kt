@file:Suppress("unused")

package src.net.irgaly.pref

import android.content.SharedPreferences
import kotlinx.serialization.KSerializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Kotlinx.Serialization Json String Read Write Delegate
 */
inline fun <reified T : Any> SharedPreferences.json(
    json: Json,
    defaultValue: Lazy<T>,
    key: String? = null
) = object : ReadWriteProperty<Any, T> {
    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return getString(
            key ?: property.name,
            null
        )?.let { json.decodeFromString<T>(it) } ?: defaultValue.value
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        edit().putString(key ?: property.name, json.encodeToString(value)).apply()
    }
}

/**
 * Nullable Kotlinx.Serialization Json String Read Write Delegate
 */
inline fun <reified T : Any> SharedPreferences.nullableJson(
    json: Json,
    key: String? = null
): ReadWriteProperty<Any, T?> = object : ReadWriteProperty<Any, T?> {
    override fun getValue(thisRef: Any, property: KProperty<*>): T? {
        return getString(key ?: property.name, null)?.let { json.decodeFromString(it) }
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) {
        edit().putString(key ?: property.name, value?.let { json.encodeToString(value) })
            .apply()
    }
}

/**
 * Kotlinx.Serialization Json String Read Write Delegate
 */
fun <T : Any> SharedPreferences.json(
    json: Json,
    serializer: KSerializer<T>,
    defaultValue: Lazy<T>,
    key: String? = null
) = object : ReadWriteProperty<Any, T> {
    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return getString(key ?: property.name, null)?.let { json.decodeFromString(serializer, it) }
            ?: defaultValue.value
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        edit().putString(key ?: property.name, json.encodeToString(serializer, value)).apply()
    }
}

/**
 * Nullable Kotlinx.Serialization Json String Read Write Delegate
 */
fun <T : Any> SharedPreferences.nullableJson(
    json: Json,
    serializer: KSerializer<T>,
    key: String? = null
) = object : ReadWriteProperty<Any, T?> {
    override fun getValue(thisRef: Any, property: KProperty<*>): T? {
        return getString(key ?: property.name, null)?.let { json.decodeFromString(serializer, it) }
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) {
        edit().putString(key ?: property.name, value?.let { json.encodeToString(serializer, it) })
            .apply()
    }
}
