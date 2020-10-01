package lk.joinus.jobportal.dto;

import java.util.Date;
import java.util.List;

public class CoursesDTO {

    private String userName;
    private List<EducationCenterDTO> educationCenterDTOList;
    private String id;
    private String name;
    private Date startDate;
    private String type;
    private String level;
    private String minAge;
    private String maxAge;
    private String educationalQualifications;
    private String imagePath;
    private String description;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<EducationCenterDTO> getEducationCenterDTOList() {
        return educationCenterDTOList;
    }

    public void setEducationCenterDTOList(List<EducationCenterDTO> educationCenterDTOList) {
        this.educationCenterDTOList = educationCenterDTOList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMinAge() {
        return minAge;
    }

    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    public String getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    public String getEducationalQualifications() {
        return educationalQualifications;
    }

    public void setEducationalQualifications(String educationalQualifications) {
        this.educationalQualifications = educationalQualifications;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
