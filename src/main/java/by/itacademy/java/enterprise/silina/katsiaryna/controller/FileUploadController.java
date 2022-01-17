package by.itacademy.java.enterprise.silina.katsiaryna.controller;

import by.itacademy.java.enterprise.silina.katsiaryna.model.ProcessedFiles;
import by.itacademy.java.enterprise.silina.katsiaryna.model.UploadForm;
import by.itacademy.java.enterprise.silina.katsiaryna.service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/")
@AllArgsConstructor
public class FileUploadController {
    private final FileService fileService;

    @RequestMapping
    public String homePage() {
        return "index";
    }

    // Show upload form page.
    @GetMapping("/uploadOneFile")
    public String uploadOneFileHandler(@ModelAttribute("uploadForm") UploadForm uploadForm) {
        return "uploadOneFile";
    }

    // Do Upload
    @PostMapping("/uploadOneFile")
    private String doUpload(HttpServletRequest request,
                            @ModelAttribute("uploadForm") UploadForm uploadForm,
                            @ModelAttribute("processedFiles") ProcessedFiles processedFiles) {
        var uploadRootPath = request.getServletContext().getRealPath("upload");
        fileService.createMultipartFilesFromUploadForm(uploadForm, uploadRootPath, processedFiles);
        return "uploadResult";
    }
}
