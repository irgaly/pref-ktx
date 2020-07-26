import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

/**
 * android build 共通設定を適用する
 */
fun Project.applyCommon(extension: BaseExtension, resourcePrefix: String? = null) {
    extension.applyCommon(this, resourcePrefix)
}

/**
 * android build 共通設定を適用する
 */
fun BaseExtension.applyCommon(project: Project, resourcePrefix: String? = null) {
    resourcePrefix?.let {
        resourcePrefix("${it}_")
    }
    compileSdkVersion(Versions.androidCompileSdkVersion)
    defaultConfig {
        minSdkVersion(Versions.androidMinSdkVersion)
        targetSdkVersion(Versions.androidTargetSdkVersion)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    lintOptions {
        isCheckDependencies = true
        lintConfig = project.file("${project.rootDir}/lint/lint.xml")
        isAbortOnError = false
    }
    if (this is AppExtension) {
        sourceSets.configureEach {
            java.srcDirs("src/$name/kotlin")
        }
    }
    if (this is LibraryExtension) {
        sourceSets.configureEach {
            setRoot("src/android/$name")
            java.srcDirs("src/android/$name/kotlin")
        }
    }
}

