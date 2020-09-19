package lk.joinus.jobportal.controller;

import lk.joinus.jobportal.dto.ApplyJobDTO;
import lk.joinus.jobportal.dto.ApplyJobMainDTO;
import lk.joinus.jobportal.service.ApplyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/applyJob")
public class ApplyJobController {

    @Autowired
    private ApplyJobService applyJobService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> applyJob(@RequestBody ApplyJobMainDTO applyJobMainDTO){
        return applyJobService.applyJob(applyJobMainDTO);
    }

    @GetMapping(value = "/Last",produces = MediaType.APPLICATION_JSON_VALUE)
    public ApplyJobDTO getLastData(){
        return applyJobService.getLastData();
    }

    @GetMapping(value = "/getAllAppliedJobsByUser/{username}")
    public ResponseEntity<?> getAllAppliedJobsByUser(@PathVariable  String username){
        return applyJobService.getAllAppliedJobsByUser(username);
    }

    @GetMapping(value = "/getAllAppliedEmployeeByUser/{username}")
    public ResponseEntity<?> getAllAppliedEmployeeByUser(@PathVariable  String username){
        return applyJobService.getAllAppliedEmployeeByUser(username);
    }

    @GetMapping(value = "/countByAllAppliedJobs/{username}")
    public ResponseEntity<?> countByAllAppliedJobs(@PathVariable  String username){
        return applyJobService.countByAllAppliedJobs(username);
    }
}
