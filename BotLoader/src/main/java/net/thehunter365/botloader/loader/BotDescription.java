package net.thehunter365.botloader.loader;

import java.io.File;

public class BotDescription {

    private String name;
    private String author;
    private String token;
    private String mainClass;
    private File file;


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getToken() {
        return token;
    }

    public String getMainClass() {
        return mainClass;
    }

    public File getFile() {
        return file;
    }

    void setFile(File file) {
        this.file = file;
    }
}
