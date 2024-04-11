plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id("maven-publish")
}

publishing {
    publications {
        create<MavenPublication>("release") {
            run {
                groupId = "com.alif"
                artifactId = "core"
                version = "0.0.0.1"
                artifact("$buildDir/outputs/aar/${artifactId}-release.aar")
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            /** Configure path of your package repository on Github
             ** Replace GITHUB_USERID with your/organisation Github userID
             ** and REPOSITORY with the repository name on GitHub
             */
            url = uri("https://maven.pkg.github.com/ilhom9045/Alif-Academy")
            credentials {
                /** Create github.properties in root project folder file with
                 ** gpr.usr=GITHUB_USER_ID & gpr.key=PERSONAL_ACCESS_TOKEN
                 ** Set env variable GPR_USER & GPR_API_KEY if not adding a properties file**/
                //./gradlew build
                //./gradlew publish
                username = "your_user_name"
                password = "your_token_for_publish_library"
            }
        }
    }
}

android {
    namespace = "com.alif.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    defaultConfig {

        kapt {
            arguments { arg("room.schemaLocation", "$projectDir/schemas") }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.material)
    api(libs.retrofit.converter.gson)
    api(libs.glide)
    api(libs.retrofit)
    api("com.squareup.okhttp3:logging-interceptor:4.10.0")
    api("androidx.room:room-runtime:2.5.0") // Библиотека "Room"
    kapt("androidx.room:room-compiler:2.5.0") // Кодогенератор
    api("androidx.room:room-ktx:2.5.0") // Дополнительно для Kotlin Coroutines, Kotlin Flows
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}