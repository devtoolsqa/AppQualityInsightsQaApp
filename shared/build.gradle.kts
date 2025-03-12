plugins {
          id("org.jetbrains.kotlin.multiplatform")
          id("com.android.kotlin.multiplatform.library")
}

kotlin {

// Target declarations - add or remove as needed below. These define
// which platforms this KMP module supports.
// See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
          androidLibrary {
                    namespace = "com.google.play.dynamic.filters.opted.shared"
                    compileSdk = 34
                    minSdk = 24

                    withAndroidTestOnJvmBuilder {
                              compilationName = "unitTest"
                              defaultSourceSetName = "androidUnitTest"
                    }

                    withAndroidTestOnDeviceBuilder {
                              compilationName = "instrumentedTest"
                              defaultSourceSetName = "androidInstrumentedTest"
                              sourceSetTreeName = "test"
                    }.configure {
                              instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    }
          }

// For iOS targets, this is also where you should
// configure native binary output. For more information, see:
// https://kotlinlang.org/docs/multiplatform-build-native-binaries.html#build-xcframeworks

// A step-by-step guide on how to include this library in an XCode
// project can be found here:
// https://developer.android.com/kotlin/multiplatform/migrate
          val xcfName = "shared"

          iosX64 {
                    binaries.framework {
                              baseName = xcfName
                    }
          }

          iosArm64 {
                    binaries.framework {
                              baseName = xcfName
                    }
          }

          iosSimulatorArm64 {
                    binaries.framework {
                              baseName = xcfName
                    }
          }

// Source set declarations.
// Declaring a target automatically creates a source set with the same name. By default, the
// Kotlin Gradle Plugin creates additional source sets that depend on each other, since it is
// common to share sources between related targets.
// See: https://kotlinlang.org/docs/multiplatform-hierarchy.html
          sourceSets {
                    commonMain {
                              dependencies {
                                        implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.20")
                                        // Add KMP dependencies here
                              }
                    }

                    commonTest {
                              dependencies {
                                        implementation("org.jetbrains.kotlin:kotlin-test:2.0.0")
                              }
                    }

                    androidMain {
                              dependencies {
                                        // Add Android-specific dependencies here. Note that this source set depends on
                                        // commonMain by default and will correctly pull the Android artifacts of any KMP
                                        // dependencies declared in commonMain.
                              }
                    }

                    getByName("androidInstrumentedTest") {
                              dependencies {
                                        implementation("androidx.test:runner:1.6.2")
                                        implementation("androidx.test:core:1.6.1")
                                        implementation("androidx.test.ext:junit:1.2.1")
                              }
                    }

                    iosMain {
                              dependencies {
                                        // Add iOS-specific dependencies here. This a source set created by Kotlin Gradle
                                        // Plugin (KGP) that each specific iOS target (e.g., iosX64) depends on as
                                        // part of KMP’s default source set hierarchy. Note that this source set depends
                                        // on common by default and will correctly pull the iOS artifacts of any
                                        // KMP dependencies declared in commonMain.
                              }
                    }
          }

}