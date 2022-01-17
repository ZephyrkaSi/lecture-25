package by.itacademy.java.enterprise.silina.katsiaryna.model;

import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProcessedFiles {
    private List<File> uploadedFiles = new ArrayList<>();
    private List<String> failedFiles = new ArrayList<>();
}
