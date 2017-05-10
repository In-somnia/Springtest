package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private File file;
    private String fileName;
    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void init() {
        this.file = new File(fileName);
        boolean writeCheck = file.canWrite();
    }
}
