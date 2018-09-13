package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.ApplyJobDTO;
import lk.ijse.jobportal.dto.ApplyJobMainDTO;
import lk.ijse.jobportal.service.ApplyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/applyJob")
public class ApplyJobController {

    @Autowired
    private ApplyJobService applyJobService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean applyJob(@RequestBody ApplyJobMainDTO applyJobMainDTO){
        return applyJobService.applyJob(applyJobMainDTO);
    }

    @GetMapping(value = "/Last",produces = MediaType.APPLICATION_JSON_VALUE)
    public ApplyJobDTO getLastData(){
        return applyJobService.getLastData();
    }
}
