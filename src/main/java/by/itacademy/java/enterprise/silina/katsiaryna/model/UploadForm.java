package by.itacademy.java.enterprise.silina.katsiaryna.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadForm {
    private MultipartFile[] fileData;
}
