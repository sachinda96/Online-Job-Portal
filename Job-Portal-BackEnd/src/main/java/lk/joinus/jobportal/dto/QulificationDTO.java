package lk.joinus.jobportal.dto;

public class QulificationDTO {

    private String id ="0";
    private String minimumqulification;
    private String requiredexperience;
    private String educationalspecialization;
    private String skill;
    private String genderpreference;
    private int maximumage;
    private int minimumage;

    public QulificationDTO() {
    }

    public QulificationDTO(String id, String minimumqulification, String requiredexperience, String educationalspecialization, String skill, String genderpreference, int maximumage) {
        this.id = id;
        this.minimumqulification = minimumqulification;
        this.requiredexperience = requiredexperience;
        this.educationalspecialization = educationalspecialization;
        this.skill = skill;
        this.genderpreference = genderpreference;
        this.maximumage = maximumage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getMinimumage() {
        return minimumage;
    }

    public void setMinimumage(int minimumage) {
        this.minimumage = minimumage;
    }
}
