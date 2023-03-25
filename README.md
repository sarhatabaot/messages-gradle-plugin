# Usage

Until we get approved on the gradle plugin portal, you should clone this repo, and install the plugin.


build.gradle.kts:
```kotlin
plugins {
    id("com.github.sarhatabaot.messages.messages-gradle-plugin") version "1.0.4"
}
```
settings.gradle.kts: 
```kotlin
pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven (
            url = uri("https://jitpack.io")
        )
    }
}
```