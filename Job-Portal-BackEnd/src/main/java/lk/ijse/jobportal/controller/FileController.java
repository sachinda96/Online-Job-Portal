package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.service.impl.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@RequestMapping("file")
@RestController
@CrossOrigin
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping
    public ResponseEntity<Resource> fileToBase64(@RequestParam("file") String path, HttpServletRequest request) throws Exception{

            if (path != null && !path.trim().isEmpty()) {

                // Load file as Resource
                String fileName = path;

                Resource resource = fileStorageService.loadFileAsResource(fileName);

                // Try to determine file's content type
                String contentType = null;
                try {
                    contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
                } catch (IOException ex) {
                    System.out.println("Could not determine file type.");
                }

                // Fallback to the default content type if type could not be determined
                if (contentType == null) {
                    contentType = "application/octet-stream";
                }

                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }

            throw  new Exception("Failed To load File");


    }
}
