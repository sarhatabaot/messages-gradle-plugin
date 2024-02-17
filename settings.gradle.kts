rootProject.name = "messages-gradle-plugin"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("messages-core", "com.github.sarhatabaot:messages-core:1.6.0-beta-3")
        }
    }
}
