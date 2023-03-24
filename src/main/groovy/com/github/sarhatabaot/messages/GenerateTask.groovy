package com.github.sarhatabaot.messages

import com.github.sarhatabaot.messages.model.FileType
import groovy.transform.Internal;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction


/**
 * @author sarhatabaot
 */
class GenerateTask extends DefaultTask implements MessagesPlugin<GradleException>{
    @Input
    public Property<Boolean> overwriteClasses
    @Input
    public Property<String> sourceFolderPath
    @Input
    public Property<String> targetPackage
    @Input
    public Property<String> privateConstructor
    @Input
    public Property<FileType> fileType
    @Input
    public Property<String> basePath

    private final File baseDir;

    GenerateTask() {
        ObjectFactory objectFactory = getProject().getObjects()

        overwriteClasses = objectFactory.property(Boolean.class)
        sourceFolderPath = objectFactory.property(String.class)
        targetPackage = objectFactory.property(String.class)
        privateConstructor = objectFactory.property(String.class)
        fileType = objectFactory.property(FileType.class)
        basePath = objectFactory.property(String.class)
        baseDir = getProject().rootProject.getRootDir()
    }


    String getBasePath() {
        return basePath.getOrElse("src/main/java/")
    }

    @TaskAction
    void performTask() {
        runTask()
    }

    @Override
    String getSourceFolderPath() {
        return sourceFolderPath.get()
    }

    @Override
    @Internal
    @Input
    String getBaseDir() {
        return baseDir.path
    }

    @Override
    String getTargetPackage() {
        return targetPackage.get()
    }

    @Override
    String getPrivateConstructor() {
        return privateConstructor.getOrElse("")
    }

    @Override
    boolean isOverwriteClasses() {
        return overwriteClasses.getOrElse(true)
    }

    @Override
    void throwException(String s) throws GradleException {
        throw new GradleException(s)
    }

    @Override
    FileType getFileType() {
        return fileType.getOrElse(FileType.JSON)
    }
}
