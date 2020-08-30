plugins {
    `maven-publish`
}

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.Android.classpath)
        classpath(Dependencies.Kotlin.classpath)
        classpath(Dependencies.Bintray.classpath)
        classpath(Dependencies.Remal.classpath)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
    apply(plugin = Dependencies.Remal.checkUpdatesPlugin)
}

subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
    apply(plugin = "maven-publish")
    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/irgaly/pref-ktx")
                credentials {
                    username = (project.findProperty("gpr.user") as? String) ?: System.getenv("USERNAME")
                    password = (project.findProperty("gpr.key") as? String) ?: System.getenv("TOKEN")
                }
            }
        }
    }
}
