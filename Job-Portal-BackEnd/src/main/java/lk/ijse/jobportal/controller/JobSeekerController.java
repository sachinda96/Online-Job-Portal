package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.JobSeekerProfileDTO;
import lk.ijse.jobportal.service.JobSekerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/JobSeekerProfile")
public class JobSeekerController{

    @Autowired
    private JobSekerProfileService jobSekerProfileService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addJobSeekerProfile(@RequestBody JobSeekerProfileDTO jobSeekerProfileDTO) {
        return jobSekerProfileService.saveSeekerDetails(jobSeekerProfileDTO);
    }

    @PostMapping(value = "/imageFile")
    public boolean uploadImage(@RequestParam("imageFile") MultipartFile file) {
        return jobSekerProfileService.uploadImage(file);
    }

    @PostMapping(value = "/CVFile")
    public boolean uploadCV(@RequestParam("CVFile") MultipartFile file) {
        return jobSekerProfileService.uploadCV(file);
    }

    @GetMapping(value = "/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JobSeekerProfileDTO searchJobSeeker(@PathVariable("username") String username){
        return jobSekerProfileService.searchSeeker(username);
    }
}
