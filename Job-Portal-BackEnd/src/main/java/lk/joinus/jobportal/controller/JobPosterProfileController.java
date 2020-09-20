package lk.joinus.jobportal.controller;

import lk.joinus.jobportal.dto.JObPosterProfileDTO;
import lk.joinus.jobportal.service.JobPosterProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/profile")
public class JobPosterProfileController {

    @Autowired
    private JobPosterProfileService jobPosterProfileService;

    @PostMapping(value = "/saveprofile",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePosterProfile(@RequestBody JObPosterProfileDTO jObPosterProfileDTO){
        return jobPosterProfileService.savePosterProfile(jObPosterProfileDTO);
    }

    @PostMapping(value = "/file")
    public ResponseEntity<?> postImage(@RequestParam("file") MultipartFile file) {
        return jobPosterProfileService.uploadFile(file);
        }

    @GetMapping(value = "/getJobPoster/{username}")
    public ResponseEntity<?> getJobPoster(@PathVariable String username) {
        return jobPosterProfileService.getJobPosterProfile(username);
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
