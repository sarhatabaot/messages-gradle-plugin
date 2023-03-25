plugins {
    id ("groovy")
    id ("com.gradle.plugin-publish") version "1.1.0"
    id ("java-gradle-plugin")
    id ("maven-publish")
}

group = "com.github.sarhatabaot.messages"
version = "1.0.5"

gradlePlugin {
    website.set("https://github.com/sarhatabaot/messages-gradle-plugin")
    vcsUrl.set("https://github.com/sarhatabaot/messages-gradle-plugin.git")
    plugins {
        create("messagesPlugin") {
            id = "com.github.sarhatabaot.messages.messages-gradle-plugin"
            implementationClass = "com.github.sarhatabaot.messages.MessagesGradlePlugin"
            displayName = "Messages"
            description = "Generate data classes from yaml and json files. Useful for bukkit plugin development."
            tags.set(listOf("spigot", "bukkit", "plugin", "code", "generation"))
        }
    }
}

repositories {
    mavenCentral()
    maven (
        url = uri("https://jitpack.io")
    )
}

dependencies {
    implementation(libs.messages.core)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

