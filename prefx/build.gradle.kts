plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    applyCommon(project, "prefx")
}

dependencies {
    implementation(Dependencies.Kotlin.stdlib)
}
