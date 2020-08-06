package lk.ijse.jobportal.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;

public class JobsDTO {

    private String id = "0";
    private String jobtitle;
    private String discription;
    private String category;
    private String industry;
    private String bussinessfuntion;
    private String role;
    private BigDecimal minsalary;
    private BigDecimal maxsalary;
    private int totalvacncies;
    private String dedlinedate;
    private String iamgePath;
    private JobPosterDTO jobPosterDTO;

    public JobsDTO() {
    }

    public JobsDTO(String id, String jobtitle, String discription, String category, String industry, String bussinessfuntion, String role, BigDecimal minsalary, BigDecimal maxsalary, int totalvacncies, String dedlinedate, String iamgePath, JobPosterDTO jobPosterDTO) {
        this.id = id;
        this.jobtitle = jobtitle;
        this.discription = discription;
        this.category = category;
        this.industry = industry;
        this.bussinessfuntion = bussinessfuntion;
        this.role = role;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
        this.totalvacncies = totalvacncies;
        this.dedlinedate = dedlinedate;
        this.iamgePath = iamgePath;
        this.jobPosterDTO = jobPosterDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getBussinessfuntion() {
        return bussinessfuntion;
    }

    public void setBussinessfuntion(String bussinessfuntion) {
        this.bussinessfuntion = bussinessfuntion;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(BigDecimal minsalary) {
        this.minsalary = minsalary;
    }

    public BigDecimal getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(BigDecimal maxsalary) {
        this.maxsalary = maxsalary;
    }

    public int getTotalvacncies() {
        return totalvacncies;
    }

    public void setTotalvacncies(int totalvacncies) {
        this.totalvacncies = totalvacncies;
    }

    public String getDedlinedate() {
        return dedlinedate;
    }

    public void setDedlinedate(String dedlinedate) {
        this.dedlinedate = dedlinedate;
    }

    public String getIamgePath() {
        return iamgePath;
    }

    public void setIamgePath(String iamgePath) {
        this.iamgePath = iamgePath;
    }

    public JobPosterDTO getJobPosterDTO() {
        return jobPosterDTO;
    }

    public void setJobPosterDTO(JobPosterDTO jobPosterDTO) {
        this.jobPosterDTO = jobPosterDTO;
    }
}
