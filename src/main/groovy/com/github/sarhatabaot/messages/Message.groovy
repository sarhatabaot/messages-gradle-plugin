package com.github.sarhatabaot.messages

import com.github.sarhatabaot.messages.model.FileType
import org.gradle.api.GradleException
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal

/**
 *
 * @author sarhatabaot
 */
class Message implements MessagesPlugin<GradleException>{
    private final String name;

    private String sourceFolder
    private String targetPackage
    private FileType fileType
    private String basePath
    private String baseDir
    private String privateConstructor
    private boolean overwriteClasses

    Message(String name) {
        this.name = name
    }

    Message(String name, String sourceFolder, String targetPackage, FileType fileType, String basePath, String baseDir, String privateConstructor, boolean overwriteClasses) {
        this.name = name;
        this.sourceFolder = sourceFolder
        this.targetPackage = targetPackage
        this.fileType = fileType
        this.basePath = basePath
        this.baseDir = baseDir
        this.privateConstructor = privateConstructor
        this.overwriteClasses = overwriteClasses
    }

    @Override
    @Input
    String getBasePath() {
        return basePath
    }

    @Override
    @Input
    String getSourceFolder() {
        return sourceFolder
    }

    @Override
    @Input
    String getBaseDir() {
        return baseDir
    }

    @Override
    @Input
    String getTargetPackage() {
        return targetPackage
    }

    @Override
    @Input
    String getPrivateConstructor() {
        return privateConstructor
    }

    @Override
    @Input
    boolean isOverwriteClasses() {
        return overwriteClasses
    }

    @Override
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
