plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    applyCommon(project)
    defaultConfig {
        applicationId = Packages.Sample.name
        versionName = Versions.versionName
        versionCode = Versions.versionCode
    }
}

dependencies {
    implementation(Dependencies.AndroidX.appCompat)
    //implementation(project(":pref-ktx"))
    implementation(Dependencies.PrefKtx.ktx)
}
