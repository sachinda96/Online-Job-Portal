package lk.joinus.jobportal.controller;

import lk.joinus.jobportal.dto.PostJobDTO;
import lk.joinus.jobportal.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/jobs")
public class JobsContoller {

    @Autowired
    private JobsService jobsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addJobs(@RequestBody PostJobDTO postJobDTO){
        return jobsService.addJob(postJobDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllJobs() {
        return jobsService.getAllPostJobs();
    }

    @GetMapping(value = "/getAllJobsByName/{name}")
    public ResponseEntity<?> getAllJobsByName(@PathVariable String name) {
        return jobsService.getAllPostJobsByName(name);
    }

    @GetMapping(value = "/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<PostJobDTO> getPosterPostedJobs(@PathVariable("username") String username){
        return jobsService.getPosterPostedJobs(username);
    }
    @PostMapping(value = "/file")
    public boolean postImage(@RequestParam("file") MultipartFile file) { return jobsService.uploadImage(file);
    }

    @GetMapping(value = "/search/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchJobs(@PathVariable String id){
        return jobsService.searchJob(id);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteJobs(@PathVariable("id") Long id){
        return jobsService.deleteJob(id);
    }

    @PostMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateJob(@RequestBody PostJobDTO postJobDTO){
        return jobsService.updateJob(postJobDTO);
    }

    @GetMapping(value = "/Total",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTotalJobs(){
       return jobsService.getAllJobsCount();
    }

    @GetMapping(value = "/totalByUser/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTotalJobsByUser(@PathVariable String userName){
        return jobsService.getAllJobsByUser(userName);
    }

}
