plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrainsKotlinKapt)
}

android {

    namespace = "com.yoesuv.networkkotlin2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.yoesuv.networkkotlin2"
        minSdk = 21
        targetSdk = 35
        versionCode = 8
        versionName = "2.1.5"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["clearPackageData"] = "true"
        setProperty("archivesBaseName", "$applicationId-v$versionCode($versionName)")
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    sourceSets {
        getByName("main") {
            res.srcDirs("src/main/res")
            res.srcDirs("src/main/res-gallery")
            res.srcDirs("src/main/res-list-place")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        dataBinding = true
        buildConfig = true
    }
    flavorDimensions.add("default")
    productFlavors {
        create("forTest") {
            resValue("string", "app_name", "Network Kotlin2 TEST")
            applicationIdSuffix = ".test"
            dimension = "default"
        }
        create("dev") {
            resValue("string", "app_name", "Network Kotlin2 DEV")
            applicationIdSuffix = ".dev"
            dimension = "default"
        }
        create("production") {
            resValue("string", "app_name", "Network Kotlin2")
            dimension = "default"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.androidx.lifecycle)

    implementation("com.android.support.test.espresso:espresso-idling-resource:3.0.2")
    testImplementation(libs.junit)
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation("androidx.test.uiautomator:uiautomator:2.3.0-alpha02")

    implementation(libs.coil)
    implementation(libs.coil.core)
    implementation(libs.coil.network)

    implementation(libs.gson)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.serialization.gson)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.okhttp)
}