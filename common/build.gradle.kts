@file:Suppress("UnstableApiUsage", "OPT_IN_USAGE", "PropertyName")

val ktor_version: String by rootProject.project
val voyager_version: String by rootProject.project

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
    id("com.android.library")
}

group = "com.example"
version = "1.0-SNAPSHOT"

kotlin {
    targetHierarchy.default()
    android()
    jvm("desktop") {
        jvmToolchain(11)

    }
    js(IR) {
        browser()
    }

    listOf(
        iosArm64(),
        iosX64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "common"
            linkerOpts("-framework", "CoreGraphics")
            linkerOpts("-framework", "CoreText")
            linkerOpts("-framework", "Metal")
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation("io.ktor:ktor-client-core:$ktor_version")
                implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
                implementation("cafe.adriel.voyager:voyager-navigator:$voyager_version")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val commonComposeKmpMain by creating {
            dependsOn(commonMain)
        }

        val desktopMain by getting {
            dependsOn(commonComposeKmpMain)
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.6.4")
                implementation("io.ktor:ktor-client-okhttp:$ktor_version")
            }
        }
        val desktopTest by getting

        val androidMain by getting {
            dependsOn(commonComposeKmpMain)
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
                implementation("io.ktor:ktor-client-okhttp:$ktor_version")
            }
        }

        val androidTest by getting

        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation("io.ktor:ktor-client-js:$ktor_version")
            }
        }

        val jsTest by getting

        val iosMain by getting {
            dependsOn(commonComposeKmpMain)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktor_version")
            }
        }
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}