package lk.joinus.jobportal.repository;

import lk.joinus.jobportal.entity.CourseEducationCenterEntity;
import lk.joinus.jobportal.entity.CoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseEducationCenterRepository extends JpaRepository<CourseEducationCenterEntity,String> {
    List<CourseEducationCenterEntity> findAllByCoursesEntity(CoursesEntity coursesEntity);
}
