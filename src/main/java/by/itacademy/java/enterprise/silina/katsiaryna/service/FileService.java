package by.itacademy.java.enterprise.silina.katsiaryna.service;

import by.itacademy.java.enterprise.silina.katsiaryna.model.ProcessedFiles;
import by.itacademy.java.enterprise.silina.katsiaryna.model.UploadForm;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void createDirectoryIfNotExists(String dirName);

    void createFileWithContent(MultipartFile multipartFile, String dirName, ProcessedFiles processedFiles);

    void createMultipartFilesFromUploadForm(UploadForm uploadForm, String dirName, ProcessedFiles processedFiles);
}
