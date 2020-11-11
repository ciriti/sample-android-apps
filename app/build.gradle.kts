import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

android {

    compileSdkVersion (30)

    defaultConfig {
        applicationId = "com.example.support"
        minSdkVersion (16)
        targetSdkVersion (30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner ("android.support.test.runner.AndroidJUnitRunner")
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions{
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    implementation ("com.sourcepoint.cmplibrary:cmplibrary:5.3.9")

    implementation ("org.jetbrains.kotlin:kotlin-stdlib:${AppVersion.kotlin}")
    implementation ("com.android.support:appcompat-v7:${AppVersion.support}")
    implementation ("com.android.support:design:${AppVersion.support}")
    implementation ("com.android.support.constraint:constraint-layout:${AppVersion.constraint_layout_support}")
    implementation ("android.arch.navigation:navigation-fragment-ktx:${AppVersion.arch_navigation}")
    implementation ("android.arch.navigation:navigation-ui-ktx:${AppVersion.arch_navigation}")
    testImplementation ("junit:junit:${AppVersion.junit}")
    androidTestImplementation ("com.android.support.test:runner:${AppVersion.test_runner}")
    androidTestImplementation ("com.android.support.test.espresso:espresso-core:${AppVersion.espresso}")
}

object AppVersion {
    const val kotlin = "1.4.10"
    const val support = "28.0.0"
    const val constraint_layout_support = "1.1.3"
    const val arch_navigation = "1.0.0"
    const val junit = "4.13.1"
    const val test_runner = "1.0.2"
    const val espresso = "3.0.2"
}

// OLD gradle file
/*
plugins {
    id "com.android.application"
    id "kotlin-android"
}

android {

    compileSdkVersion 28

    defaultConfig {
        applicationId "com.example.cpm_test_apps"
        minSdkVersion 16
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
}

dependencies {

    implementation ("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
    implementation ("com.android.support:appcompat-v7:28.0.0")
    implementation ("com.android.support:design:28.0.0")
    implementation ("com.android.support.constraint:constraint-layout:2.0.4")
    implementation ("android.arch.navigation:navigation-fragment-ktx:1.0.0")
    implementation ("android.arch.navigation:navigation-ui-ktx:1.0.0")
    testImplementation ("junit:junit:4.13.1")
    androidTestImplementation ("com.android.support.test:runner:1.0.2")
    androidTestImplementation ("com.android.support.test.espresso:espresso-core:3.0.2")
}
 */