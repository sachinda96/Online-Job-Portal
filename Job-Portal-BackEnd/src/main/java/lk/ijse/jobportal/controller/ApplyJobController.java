package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.ApplyJobDTO;
import lk.ijse.jobportal.dto.ApplyJobMainDTO;
import lk.ijse.jobportal.service.ApplyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

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
}
