plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
}

android {
    namespace = "com.example.googlemaptesting"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.googlemaptesting"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.play.services.maps)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.play.services.maps.v1900)


    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.okhttp.v490)
//    implementation (libs.proj4j)
//    implementation (libs.mapbox.android.sdk)
    implementation(libs.android)

//    implementation(libs.mapbox.vector.tile)
//    implementation (libs.android.v1141)
//    implementation (libs.mapbox.android.sdk.v970)
    implementation (libs.osmdroid.osmdroid.android)
//    implementation (libs.protobuf.java)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}