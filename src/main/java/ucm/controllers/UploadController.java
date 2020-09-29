package ucm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ucm.models.AdImage;
import ucm.repositories.AdImageRepository;
import ucm.services.FileStorageService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.io.IOUtils.toByteArray;

@RestController
@RequestMapping("image")
public class UploadController {


    @Autowired
    FileStorageService storageService;
    @Autowired
    AdImageRepository adImageRepository;


    @PostMapping("/upload")
    public ResponseEntity<AdImage> uploadFile(@RequestParam("imageFile") MultipartFile file) {
        try {
            storageService.save(file);
            AdImage image = new AdImage(file.getOriginalFilename());
            adImageRepository.save(image);
            return new ResponseEntity<>(image, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping(path = {"/{imageName}"})
    public @ResponseBody
    Map<String, String> getImage(@PathVariable String imageName) throws IOException {
        String path = "/home/sirac/IdeaProjects/UsedCarMarket/uploads/";
        File file = Paths.get(path + imageName).toFile();
        String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(file.toPath()));
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("content", encodeImage);
        return jsonMap;
    }
}
