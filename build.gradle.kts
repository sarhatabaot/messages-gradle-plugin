plugins {
    id ("groovy")
    id ("com.gradle.plugin-publish") version "1.1.0"
    id ("java-gradle-plugin")
}

group = "com.github.sarhatabaot.messages"
version = "1.0.2"

gradlePlugin {
    website.set("https://github.com/sarhatabaot/messages-core")
    vcsUrl.set("https://github.com/sarhatabaot/messages-core")
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
        url = "https://jitpack.io"
    )
}

dependencies {
    implementation ("com.github.sarhatabaot:messages-core:1.5.3")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

