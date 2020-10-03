package lk.joinus.jobportal.controller;

import lk.joinus.jobportal.dto.EducationCenterDTO;
import lk.joinus.jobportal.dto.EducationalPartnerDTO;
import lk.joinus.jobportal.service.EducationalPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/EducationalPartner")
public class EducationalPartnerController {

    @Autowired
    private EducationalPartnerService educationalPartnerService;

    @PostMapping
    public Boolean add(@RequestBody EducationalPartnerDTO educationalPartnerDTO){
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

    @GetMapping(value = "/educationCenter/{id}")
    public ResponseEntity<?> educationCenter(@PathVariable String id){
        return educationalPartnerService.getEducationCenter(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEducationCenter(@PathVariable String id){
        return educationalPartnerService.deleteEducationCenter(id);
    }

    @GetMapping(value = "/countAll")
    public ResponseEntity<?> countAll(){
        return educationalPartnerService.countAll();
    }
}
