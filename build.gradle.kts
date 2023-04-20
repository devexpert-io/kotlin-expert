group = "com.devexperto"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    kotlin("plugin.serialization") apply false
    id("com.android.application") apply false
    id("org.jetbrains.compose") apply false
}