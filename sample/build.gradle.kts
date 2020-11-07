plugins {
    id("com.android.application")
    kotlin("android")
    id(Dependencies.Kotlin.KotlinX.Serialization.plugin)
}

android {
    applyCommon(project)
    defaultConfig {
        applicationId = Packages.Sample.name
        versionName = Versions.versionName
    }
}

dependencies {
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.Kotlin.KotlinX.Serialization.json)
    //implementation(project(":pref-ktx-serialization"))
    implementation(Dependencies.PrefKtx.serialization)
}
