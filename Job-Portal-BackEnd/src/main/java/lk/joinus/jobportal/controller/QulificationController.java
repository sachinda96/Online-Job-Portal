package lk.joinus.jobportal.controller;

import lk.joinus.jobportal.service.QulificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/qulification")
public class QulificationController {

    @Autowired
    private QulificationService qulificationService;

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteQulification(@PathVariable("id") Long id){
        return qulificationService.deleteQulification(id);
    }
}
