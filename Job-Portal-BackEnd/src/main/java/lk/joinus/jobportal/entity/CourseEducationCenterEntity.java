package lk.joinus.jobportal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CourseEducationCenterEntity {

    @Id
    private String id;

    @ManyToOne
    private CoursesEntity coursesEntity;

    @ManyToOne
    private EducationCenterEntity educationCenterEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CoursesEntity getCoursesEntity() {
        return coursesEntity;
    }

    public void setCoursesEntity(CoursesEntity coursesEntity) {
        this.coursesEntity = coursesEntity;
    }

    public EducationCenterEntity getEducationCenterEntity() {
        return educationCenterEntity;
    }

    public void setEducationCenterEntity(EducationCenterEntity educationCenterEntity) {
        this.educationCenterEntity = educationCenterEntity;
    }
}
