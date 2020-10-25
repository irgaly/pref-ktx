plugins {
    id("com.android.application")
    kotlin("android")
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
    //implementation(project(":pref-ktx-serialization"))
    implementation(Dependencies.PrefKtx.serialization)
}
