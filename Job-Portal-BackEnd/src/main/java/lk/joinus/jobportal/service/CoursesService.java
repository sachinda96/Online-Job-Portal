package lk.joinus.jobportal.service;

import lk.joinus.jobportal.dto.CoursesDTO;
import org.springframework.http.ResponseEntity;

public interface CoursesService {

    public ResponseEntity<?> postCourses(CoursesDTO coursesDTO);

    public ResponseEntity<?> updateCourses(CoursesDTO coursesDTO);

    public ResponseEntity<?> allCoursesByEducationalCenter(String id);

    public ResponseEntity<?> allCourses();
}
