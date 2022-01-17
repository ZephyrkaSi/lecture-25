package by.itacademy.java.enterprise.silina.katsiaryna.service.impl;

import by.itacademy.java.enterprise.silina.katsiaryna.model.ProcessedFiles;
import by.itacademy.java.enterprise.silina.katsiaryna.model.UploadForm;
import by.itacademy.java.enterprise.silina.katsiaryna.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Override
    public void createDirectoryIfNotExists(String dirName) {
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdirs();
            log.info("Directory {} has been created", dirName);
        } else {
            log.info("Directory {} is already exist", dirName);
        }
    }

    @Override
    public void createFileWithContent(MultipartFile multipartFile, String dirName, ProcessedFiles processedFiles) {
        var fileName = multipartFile.getOriginalFilename();

        if (fileName != null && fileName.length() > 0) {
            File file = new File(dirName + File.separator + fileName);

            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file))) {
                stream.write(multipartFile.getBytes());
                log.info("Write file: {}", file);
                processedFiles.getUploadedFiles().add(file);
            } catch (IOException e) {
                log.error("Error Write file: {}", fileName, e);
                processedFiles.getFailedFiles().add(fileName);
            }
        }
    }

    @Override
    public void createMultipartFilesFromUploadForm(UploadForm uploadForm, String dirName, ProcessedFiles processedFiles) {
        createDirectoryIfNotExists(dirName);

        MultipartFile[] fileDataArray = uploadForm.getFileData();
        for (MultipartFile file : fileDataArray) {
            createFileWithContent(file, dirName, processedFiles);
        }
    }
}
