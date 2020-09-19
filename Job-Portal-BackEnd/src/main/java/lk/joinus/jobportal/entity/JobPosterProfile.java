package lk.joinus.jobportal.entity;

import javax.persistence.*;

@Entity
public class JobPosterProfile {
    @Id
    private String id;
    private String comapanyname;
    private String email;
    private String address;
    private String city;
    private String province;
    private String contactnumber;
    private String companyBackground;
    private String imagepaht;


    @OneToOne(cascade = CascadeType.ALL)
    private JobPoster jobPoster;

    public JobPosterProfile() {
    }

    public JobPosterProfile(String comapanyname, String email, String address, String city, String province, String contactnumber, String companyBackground, String imagepaht, JobPoster jobPoster) {
        this.comapanyname = comapanyname;
        this.email = email;
        this.address = address;
        this.city = city;
        this.province = province;
        this.contactnumber = contactnumber;
        this.companyBackground = companyBackground;
        this.imagepaht = imagepaht;
        this.jobPoster = jobPoster;
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

    public String getImagepaht() {
        return imagepaht;
    }

    public void setImagepaht(String imagepaht) {
        this.imagepaht = imagepaht;
    }

    public JobPoster getJobPoster() {
        return jobPoster;
    }

    public void setJobPoster(JobPoster jobPoster) {
        this.jobPoster = jobPoster;
    }

    @Override
    public String toString() {
        return "JobPosterProfile{" +
                "comapanyname='" + comapanyname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", contactnumber='" + contactnumber + '\'' +
                ", companyBackground='" + companyBackground + '\'' +
                ", imagepaht='" + imagepaht + '\'' +
                ", jobPoster=" + jobPoster +
                '}';
    }
}
