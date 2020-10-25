import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency

@Suppress("unused", "MayBeConstant", "MemberVisibilityCanBePrivate")
object Dependencies {
    object Android {
        val classpath = "com.android.tools.build:gradle:4.2.0-alpha14"
    }

    object Kotlin {
        val version = "1.4.10"
        val classpath = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        val test = "org.jetbrains.kotlin:kotlin-test:$version"

        object Coroutines {
            val version = "1.3.9"
            val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            val rx = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$version"
            val playServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$version"
            val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }

        object KotlinX {
            val repository = "https://kotlin.bintray.com/kotlinx"

            object Serialization {
                val plugin = "kotlinx-serialization"
                val version = "1.0.0"
                val classpath = "org.jetbrains.kotlin:kotlin-serialization:${Kotlin.version}"
                val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
            }

            object Io {
                val version = "0.1.16"
                val common = "org.jetbrains.kotlinx:kotlinx-io:$version"
                val jvm = "org.jetbrains.kotlinx:kotlinx-io-jvm:$version"
            }
        }
    }

    object AndroidX {
        val appCompat = "androidx.appcompat:appcompat:1.2.0"
        val recyclerView = "androidx.recyclerview:recyclerview:1.0.0"
        val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"
        val pagingKtx = "androidx.paging:paging-runtime-ktx:2.1.2"
        val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"
        val material = "com.google.android.material:material:1.2.0-beta01"
        val coreKtx = "androidx.core:core-ktx:1.1.0"
        val preference = "androidx.preference:preference:1.1.0"
        val preferenceKtx = "androidx.preference:preference-ktx:1.1.0"
        val browser = "androidx.browser:browser:1.2.0"
        val webkit = "androidx.webkit:webkit:1.3.0-alpha02"
        val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.0-alpha06"
        val media = "androidx.media:media:1.1.0"
        val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0"

        object Lifecycle {
            val version = "2.2.0"
            val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            val rx = "androidx.lifecycle:lifecycle-reactivestreams-ktx:$version"
            val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        }

        object Navigation {
            val plugin = "androidx.navigation.safeargs"
            val version = "2.3.0-alpha04"
            val classpath = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
            val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Room {
            val version = "2.2.0-beta01"
            val runtime = "androidx.room:room-runtime:$version"
            val ktx = "androidx.room:room-ktx:$version"
            val rxjava2 = "androidx.room:room-rxjava2:$version"
            val kapt = "androidx.room:room-compiler:$version"
            val kaptDependency =
                DefaultExternalModuleDependency("androidx.room", "room-compiler", version)
        }
    }

    /**
     * JSON Serialization
     */
    object Moshi {
        val version = "1.9.2"
        val moshi = "com.squareup.moshi:moshi:$version"
        val ktx = "com.squareup.moshi:moshi-kotlin:$version"
    }

    object PrefKtx {
        val version = "1.1.0"
        val ktx = "net.irgaly:pref-ktx:$version"
        val serialization = "net.irgaly:pref-ktx-serialization:$version"
    }

    object Bintray {
        val version = "1.8.5"
        val classpath = "com.jfrog.bintray.gradle:gradle-bintray-plugin:$version"
        val plugin = "com.jfrog.bintray"
    }

    object Remal {
        val version = "1.0.211"
        val classpath = "name.remal:gradle-plugins:$version"
        val checkUpdatesPlugin = "name.remal.check-updates"
    }
}
