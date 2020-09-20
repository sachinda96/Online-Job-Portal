package lk.joinus.jobportal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EducationCenterEntity {

    @Id
    private String id;
    private String type;
    private String name;
    private String address;
    private String email;
    private String branch;
    private String telNo;
    private String faxNo;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    private EducationalPartnerEntity educationalPartnerEntity;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public EducationalPartnerEntity getEducationalPartnerEntity() {
        return educationalPartnerEntity;
    }

    public void setEducationalPartnerEntity(EducationalPartnerEntity educationalPartnerEntity) {
        this.educationalPartnerEntity = educationalPartnerEntity;
    }
}
