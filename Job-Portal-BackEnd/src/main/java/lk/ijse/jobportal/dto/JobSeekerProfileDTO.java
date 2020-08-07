package lk.ijse.jobportal.dto;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class JobSeekerProfileDTO {
    private String id ="0";
    private String firstName;
    private String lastName;
    private String interstIn;
    private String emailAddress;
    private String address;
    private String province;
    private String city;
    private String birthDay;
    private String phoneNumber;
    private String highestEducation;
    private String stream;
    private String imagePath;
    private String cvPath;

    private UserDTO userDTO;

    public JobSeekerProfileDTO() {
    }

    public JobSeekerProfileDTO(String firstName, String lastName, String interstIn, String emailAddress, String address, String province, String city, String birthDay, String phoneNumber, String highestEducation, String stream, String imagePath, String cvPath, UserDTO userDTO) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.interstIn = interstIn;
        this.emailAddress = emailAddress;
        this.address = address;
        this.province = province;
        this.city = city;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.highestEducation = highestEducation;
        this.stream = stream;
        this.imagePath = imagePath;
        this.cvPath = cvPath;
        this.userDTO = userDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInterstIn() {
        return interstIn;
    }

    public void setInterstIn(String interstIn) {
        this.interstIn = interstIn;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCvPath() {
        return cvPath;
    }

    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "JobSeekerProfileDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", interstIn='" + interstIn + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", highestEducation='" + highestEducation + '\'' +
                ", stream='" + stream + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", cvPath='" + cvPath + '\'' +
                ", userDTO=" + userDTO +
                '}';
    }
}
