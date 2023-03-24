package com.github.sarhatabaot.messages

import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project
import org.gradle.util.GradleVersion;
import org.jetbrains.annotations.NotNull;

/**
 * @author sarhatabaot
 */
class MessagesGradlePlugin implements Plugin<Project> {
    private static final String MESSAGES_TASK_NAME = "generateMessages";
    private static final String MESSAGES_GROUP = "Messages";

    @Override
    void apply(final @NotNull Project project) {
        if (GradleVersion.current() < GradleVersion.version("8.0")) {
            throw new GradleException("This version of Messages supports Gradle 8.0+ only. Please upgrade.")
        }

        registerTask(project);
    }


    protected static void registerTask(@NotNull Project project) {
        project.getTasks().register(MESSAGES_TASK_NAME, GenerateTask.class, generateTask -> {
            generateTask.group = MESSAGES_GROUP;
            generateTask.description = "Generate static classes from json/yaml files.";
        });
    }
}
