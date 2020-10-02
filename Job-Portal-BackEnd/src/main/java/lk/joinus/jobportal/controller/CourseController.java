package lk.joinus.jobportal.controller;

import lk.joinus.jobportal.dto.CoursesDTO;
import lk.joinus.jobportal.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CoursesService coursesService;

    @PostMapping
    public ResponseEntity<?> postCourses(@RequestBody CoursesDTO coursesDTO){
        return coursesService.postCourses(coursesDTO);
    }

    @PostMapping(value = "/updateCourses")
    public ResponseEntity<?> updateCourses(@RequestBody CoursesDTO coursesDTO){
        return coursesService.updateCourses(coursesDTO);
    }

    @GetMapping(value = "/allCoursesByEducationalCenter/{id}")
    public ResponseEntity<?> allCoursesByEducationalCenter(@PathVariable String id){
        return coursesService.allCoursesByEducationalCenter(id);
    }

    @GetMapping
    public ResponseEntity<?> allCourses(){
        return coursesService.allCourses();
    }

    @GetMapping(value = "/searchCourses/{id}")
    public ResponseEntity<?> searchCourses(@PathVariable String id){
        return coursesService.searchCourses(id);
    }

    @GetMapping(value = "/getAllByUser/{userName}")
    public ResponseEntity<?> getAllByUser(@PathVariable String userName){
        return coursesService.getAllCourseByUser(userName);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return coursesService.delete(id);
    }

}
