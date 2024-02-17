plugins {
    id ("groovy")
    id ("com.gradle.plugin-publish") version "1.2.1"
    `java-gradle-plugin`
    id ("maven-publish")
}

group = "com.github.sarhatabaot.messages"
version = "1.1.1"

gradlePlugin {
    website = "https://github.com/sarhatabaot/messages-gradle-plugin"
    vcsUrl = "https://github.com/sarhatabaot/messages-gradle-plugin.git"
    plugins {
        create("messagesPlugin") {
            id = "com.github.sarhatabaot.messages"
            implementationClass = "com.github.sarhatabaot.messages.MessagesGradlePlugin"
            displayName = "Messages"
            description = "Generate data classes from yaml and json files. Useful for bukkit plugin development."
            tags.set(listOf("spigot", "bukkit", "plugin", "code", "generation"))
        }
    }
}

repositories {
    mavenLocal()
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
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

