package com.github.sarhatabaot.messages

import org.gradle.api.DefaultTask
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.tasks.Nested;
import org.gradle.api.tasks.TaskAction


/**
 * @author sarhatabaot
 */
class GenerateTask extends DefaultTask {
    @Nested
    NamedDomainObjectContainer<Message> messages = getProject().container(Message.class)


    @TaskAction
    void performTask() {
        for(Message message: messages) {
            message.runTask()
        }
    }

}
