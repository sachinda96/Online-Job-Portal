package lk.joinus.jobportal.controller;

import lk.joinus.jobportal.dto.JobPosterDTO;
import lk.joinus.jobportal.service.JobPosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/jobposter")
public class JobPosterController {

    @Autowired
    private JobPosterService jobPosterService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addJobPoster(@RequestBody JobPosterDTO jobPosterDTO){
        return jobPosterService.addJobPoaser(jobPosterDTO);
    }

    @GetMapping(value = "/Logined", produces = MediaType.APPLICATION_JSON_VALUE)
    public JobPosterDTO getLoginedPoster(){
        return jobPosterService.loginPoster();
    }

}
