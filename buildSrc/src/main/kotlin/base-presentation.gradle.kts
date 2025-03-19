plugins {
    id("base-library")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":core:ui"))
    baseAndroid()
    compose()
}