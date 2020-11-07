import com.jfrog.bintray.gradle.BintrayExtension.PackageConfig

plugins {
    id("com.android.library")
    kotlin("android")
    id(Dependencies.Bintray.plugin)
    `maven-publish`
}

android {
    applyCommon(project, "prefktx")
}

dependencies {
    implementation(Dependencies.Kotlin.KotlinX.Serialization.json)
    implementation(project(":pref-ktx-core"))
    api(project(":pref-ktx"))
}

val androidSourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets["main"].java.srcDirs)
}

bintray {
    user = System.getenv("BINTRAY_USER")
    key = System.getenv("BINTRAY_API_KEY")
    setPublications("maven")
    publish = true
    pkg(delegateClosureOf<PackageConfig> {
        userOrg = "irgaly"
        repo = "maven"
        name = "pref-ktx-serialization"
        version.name = Versions.versionName
    })
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["release"])
                artifact(androidSourcesJar)
                groupId = "net.irgaly"
                artifactId = "pref-ktx-serialization"
                version = Versions.versionName
            }
        }
    }
    val bintrayUpload by tasks.existing {
        dependsOn(androidSourcesJar)
        dependsOn(tasks.named("generatePomFileForMavenPublication"))
        dependsOn(tasks.named("generateMetadataFileForMavenPublication"))
    }

}
