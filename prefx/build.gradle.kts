plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
}

android {
    applyCommon(project, "prefx")
}

dependencies {
    implementation(Dependencies.Kotlin.stdlib)
}

val androidSourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets["main"].java.srcDirs)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["release"])
                artifact(androidSourcesJar)
                groupId = "net.irgaly"
                artifactId = "prefx"
                version = Versions.versionName
            }
        }
    }
}
