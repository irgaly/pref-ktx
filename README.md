# pref-ktx

Android Shared Preferences Kotlin Extension

[Blog Post - Kotlin らしく SharedPreferences をシンプルに扱う Extension を実装する](https://qiita.com/irgaly/items/4b149068b2f62289e7a5)

# Usage

## Gradle

Using extension with JSON KotlinX Serialization.

```
dependencies {
    implementation("net.irgaly:pref-ktx-serialization:1.1.2")
}
```

Using extension only with primitive types, if you would not to use JSON Serialization.

```
dependencies {
    implementation("net.irgaly:pref-ktx:1.1.2")
}
```


## Extension

`pref-ktx` features

```
class FooConfiguration (private val preferences: SharedPreferences)  {
    // Get key existence
    val containsFoo: Boolean get() = preferences.contains(::foo.name)

    // Read/Write Int value with "foo" key (boolean, float, int, long, string are also available)
    var foo: Int by preferences.int()

    // Read/Write Int value. Read with default value 42, and "my_foo_key" key
    var foo2: Int by preferences.int(42, "my_foo_key")

    // Read/Write nullable Int value with "bar" key
    var bar: Int? by preferences.nullableInt()

}
```

`pref-ktx-serialization` features

```
class FooConfiguration (private val preferences: SharedPreferences, json: Json)  {
    // Read/Write Person entity with KotlinX Serialization. Default value is "Person()".
    var person: Person by preferences.json(json, lazy { Person() })

    // Read/Write Person entity with KotlinX Serialization. Throws an exception when it is null.
    var person2: Person by preferences.json(json, lazy { throw Throwable() })

    // Read/Write nullable Person entity with KotlinX Serialization
    var person3: Person? by preferences.nullableJson(json)
}
```
