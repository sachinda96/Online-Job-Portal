package lk.ijse.jobportal.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class JObPosterProfileDTO {

    private String id;
    private String comapanyname;
    private String email;
    private String address;
    private String city;
    private String province;
    private String contactnumber;
    private String companyBackground;
    private String imagePath;
    private JobPosterDTO jobPosterDTO;


    public JObPosterProfileDTO() {
    }

    public JObPosterProfileDTO(String comapanyname, String email, String address, String city, String province, String contactnumber, String companyBackground, String imagePath, JobPosterDTO jobPosterDTO) {
        this.comapanyname = comapanyname;
        this.email = email;
        this.address = address;
        this.city = city;
        this.province = province;
        this.contactnumber = contactnumber;
        this.companyBackground = companyBackground;
        this.imagePath = imagePath;
        this.jobPosterDTO = jobPosterDTO;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComapanyname() {
        return comapanyname;
    }

    public void setComapanyname(String comapanyname) {
        this.comapanyname = comapanyname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getCompanyBackground() {
        return companyBackground;
    }

    public void setCompanyBackground(String companyBackground) {
        this.companyBackground = companyBackground;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public JobPosterDTO getJobPosterDTO() {
        return jobPosterDTO;
    }

    public void setJobPosterDTO(JobPosterDTO jobPosterDTO) {
        this.jobPosterDTO = jobPosterDTO;
    }

}
