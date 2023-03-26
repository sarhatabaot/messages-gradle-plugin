# Usage

Until we get approved on the gradle plugin portal, use jitpack as detailed below:


build.gradle.kts:
```kotlin
plugins {
    id("com.github.sarhatabaot.messages.messages-gradle-plugin") version "1.0.4"
}
```
settings.gradle.kts: 
```kotlin
pluginManagement {
    resolutionStrategy {
        eachPlugin {
            requested.apply {
                if ("$id".startsWith("com.github.sarhatabaot")) {
                    useModule("com.github.sarhatabaot.messages-gradle-plugin:com.github.sarhatabaot.messages.gradle.plugin:$version")
                }
            }
        }
    }
    repositories {
        gradlePluginPortal()
        maven (
            url = uri("https://jitpack.io")
        )
    }
}
```
