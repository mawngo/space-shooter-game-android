import java.nio.file.Paths

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.github.mawngo.game.asteroidsgame"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.github.mawngo.game.asteroidsgame"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"
        buildToolsVersion = "35.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        setProperty("archivesBaseName", "asteroids-v${versionName}")
    }

    signingConfigs {
        create("release") {
            storeFile = file(Paths.get(project.rootDir.absolutePath, "keystore.jks"))
            storePassword = System.getenv("SIGNING_STORE_PASSWORD")
            keyAlias = System.getenv("SIGNING_KEY_ALIAS")
            keyPassword = System.getenv("SIGNING_KEY_PASSWORD")
        }
    }

    buildTypes {
        release {
            signingConfig =
                if (file(Paths.get(project.rootDir.absolutePath, "keystore.jks")).exists())
                    signingConfigs.getByName("release") else null

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.webkit)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}