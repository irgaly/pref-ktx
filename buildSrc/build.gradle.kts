plugins {
    `kotlin-dsl`
}
repositories {
    jcenter()
    google()
    maven("https://plugins.gradle.org/m2/")
}
dependencies {
    implementation("com.android.tools.build:gradle:4.2.0-alpha14")
    implementation("org.jetbrains.kotlin.android.extensions:org.jetbrains.kotlin.android.extensions.gradle.plugin:1.4.0")
    implementation("org.jetbrains.kotlin.kapt:org.jetbrains.kotlin.kapt.gradle.plugin:1.4.0")
}
