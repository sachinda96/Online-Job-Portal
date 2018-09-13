package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.*;
import lk.ijse.jobportal.entity.JobPosterProfile;
import lk.ijse.jobportal.service.JobPosterProfileService;
import lk.ijse.jobportal.service.impl.JobPosterProfileServiceImpl;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/profile")
public class JobPosterProfileController {

    @Autowired
    private JobPosterProfileService jobPosterProfileService;

    @PostMapping(value = "/saveprofile",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean savePosterProfile(@RequestBody JObPosterProfileDTO jObPosterProfileDTO){
        return jobPosterProfileService.savePosterProfile(jObPosterProfileDTO);
    }

    @PostMapping(value = "/file")
    public boolean postImage(@RequestParam("file") MultipartFile file) {
        return jobPosterProfileService.uploadFile(file);
        }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<JObPosterProfileDTO> getAllJobsPosterProfiles() {
        return jobPosterProfileService.viewProfileData();
    }

    @GetMapping(value = "/file",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@RequestParam("file") String path) {
        return jobPosterProfileService.getImage(path);
    }

    @GetMapping(value = "/{companyName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JObPosterProfileDTO serchItems(@PathVariable("companyName") String companyname) {
        System.out.println("companyName");
        System.out.println(companyname);
            return jobPosterProfileService.searchPosterProfile(companyname);
            }
}
