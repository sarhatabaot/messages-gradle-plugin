package com.github.sarhatabaot.messages

import com.github.sarhatabaot.messages.model.FileType
import org.gradle.api.GradleException
import org.gradle.api.tasks.Input

/**
 *
 * @author sarhatabaot
 */
class Message extends MessagesPlugin<GradleException>{
    private final String name;

    Message(final String name, String basePath, String sourceFolder, String baseDir, FileType fileType, String targetPackage, String privateConstructor, boolean overwriteClasses) {
        super(basePath, sourceFolder, baseDir, fileType, targetPackage, privateConstructor, overwriteClasses)
        this.name = name;
    }

    @Input
    String getBasePath() {
        return basePath
    }


    @Input
    String getSourceFolder() {
        return sourceFolder
    }


    @Input
    String getBaseDir() {
        return baseDir
    }


    @Input
    String getTargetPackage() {
        return targetPackage
    }


    @Input
    String getPrivateConstructor() {
        return privateConstructor
    }


    @Input
    boolean isOverwriteClasses() {
        return overwriteClasses
    }


    @Input
    FileType getFileType() {
        return fileType
    }

    @Override
    void throwException(String message) throws GradleException {
        throw new GradleException(message)
    }

    void setSourceFolder(String sourceFolder) {
        this.sourceFolder = sourceFolder
    }

    void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage
    }

    void setFileType(FileType fileType) {
        this.fileType = fileType
    }

    void setBasePath(String basePath) {
        this.basePath = basePath
    }

    void setBaseDir(String baseDir) {
        this.baseDir = baseDir
    }

    void setPrivateConstructor(String privateConstructor) {
        this.privateConstructor = privateConstructor
    }

    void setOverwriteClasses(boolean overwriteClasses) {
        this.overwriteClasses = overwriteClasses
    }

    @Input
    String getName() {
        return name
    }
}
