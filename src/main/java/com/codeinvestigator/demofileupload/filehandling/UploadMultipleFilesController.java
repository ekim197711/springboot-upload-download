package com.codeinvestigator.demofileupload.filehandling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class UploadMultipleFilesController {


    @PostMapping("/uploadmultiple")
    public String uploadFile(@RequestParam("files") MultipartFile[] files){
        for (int i = 0;i < files.length;i++){
            MultipartFile file = files[i];
           log.info("Filename :" + file.getOriginalFilename());
            log.info("Size:" + file.getSize());
            log.info("Contenttype:" + file.getContentType());
            String destinationfilename = "./uploads/" + file.getOriginalFilename()
                    + UUID.randomUUID();
            try {
                Files.copy(file.getInputStream(),
                        Path.of(destinationfilename),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return "Multiple files has been saved!: " + files.length;

    }
}
