plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hiltAndroid)
}

android {

    namespace = "com.yoesuv.networkkotlin2"
    compileSdk {
        version =
            release(36) {
                minorApiLevel = 1
            }
    }

    defaultConfig {
        applicationId = "com.yoesuv.networkkotlin2"
        minSdk = 24
        targetSdk = 36
        versionCode = 10
        versionName = "2.1.7"

        testInstrumentationRunner = "com.yoesuv.networkkotlin2.HiltTestRunner"
        testInstrumentationRunnerArguments["clearPackageData"] = "true"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    sourceSets {
        getByName("main") {
            res.directories.addAll(
                listOf(
                    "src/main/res",
                    "src/main/res-gallery",
                    "src/main/res-list-place",
                ),
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        dataBinding = true
        buildConfig = true
        resValues = true
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
            isDefault = true
        }
        create("production") {
            resValue("string", "app_name", "Network Kotlin2")
            dimension = "default"
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
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
    implementation(libs.androidx.activity)

    implementation(libs.espresso.idling)
    testImplementation(libs.junit)
    testImplementation(libs.robolectric)
    testImplementation(libs.core.testing)
    androidTestImplementation(libs.androidx.rules)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.ui.automator)

    implementation(libs.coil)
    implementation(libs.coil.core)
    implementation(libs.coil.network)

    implementation(libs.gson)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.serialization.gson)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.okhttp)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.testing)
    kspAndroidTest(libs.hilt.compiler)
}
