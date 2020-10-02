package lk.joinus.jobportal.repository;

import lk.joinus.jobportal.entity.CoursesEntity;
import lk.joinus.jobportal.entity.EducationCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<CoursesEntity,String> {

    List<CoursesEntity> findAllByStatus(String active);

    List<CoursesEntity> findAllByStatusAndUser(String active, String userName);
}
