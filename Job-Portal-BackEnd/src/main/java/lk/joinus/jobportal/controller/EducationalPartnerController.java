package lk.joinus.jobportal.controller;

import lk.joinus.jobportal.dto.EducationCenterDTO;
import lk.joinus.jobportal.dto.EducationalPartnerDTO;
import lk.joinus.jobportal.service.EducationalPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/EducationalPartner")
public class EducationalPartnerController {

    @Autowired
    private EducationalPartnerService educationalPartnerService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody EducationalPartnerDTO educationalPartnerDTO){
        return educationalPartnerService.add(educationalPartnerDTO);
    }


    @PostMapping(value = "/addEducationCenter")
    public ResponseEntity<?> addEducationCenter(@RequestBody EducationCenterDTO educationCenterDTO){
        return educationalPartnerService.addEducationCenter(educationCenterDTO);
    }

    @GetMapping(value = "/allEducationCenterByUser/{userName}")
    public ResponseEntity<?> allEducationCenterByUser(@PathVariable String userName){
        return educationalPartnerService.allEducationCenterByUser(userName);
    }


}
