package lk.ijse.jobportal.dto;

public class QulificationDTO {

    private Long id;
    private String minimumqulification;
    private String requiredexperience;
    private String educationalspecialization;
    private String skill;
    private String genderpreference;
    private int maximumage;

    public QulificationDTO() {
    }

    public QulificationDTO(Long id, String minimumqulification, String requiredexperience, String educationalspecialization, String skill, String genderpreference, int maximumage) {
        this.id = id;
        this.minimumqulification = minimumqulification;
        this.requiredexperience = requiredexperience;
        this.educationalspecialization = educationalspecialization;
        this.skill = skill;
        this.genderpreference = genderpreference;
        this.maximumage = maximumage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMinimumqulification() {
        return minimumqulification;
    }

    public void setMinimumqulification(String minimumqulification) {
        this.minimumqulification = minimumqulification;
    }

    public String getRequiredexperience() {
        return requiredexperience;
    }

    public void setRequiredexperience(String requiredexperience) {
        this.requiredexperience = requiredexperience;
    }

    public String getEducationalspecialization() {
        return educationalspecialization;
    }

    public void setEducationalspecialization(String educationalspecialization) {
        this.educationalspecialization = educationalspecialization;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getGenderpreference() {
        return genderpreference;
    }

    public void setGenderpreference(String genderpreference) {
        this.genderpreference = genderpreference;
    }

    public int getMaximumage() {
        return maximumage;
    }

    public void setMaximumage(int maximumage) {
        this.maximumage = maximumage;
    }
}
