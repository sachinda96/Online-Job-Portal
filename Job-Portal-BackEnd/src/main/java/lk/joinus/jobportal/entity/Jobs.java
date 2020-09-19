package lk.joinus.jobportal.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Jobs {

    @Id
    private String id;
    private String jobtitle;

    private String discription;
    private String category;
    private String industry;
    private String BussinessFuntion;
    private String role;
    private BigDecimal minsalary;
    private BigDecimal maxsalary;
    private int totalvacncies;
    private String dedlinedate;
    private String imagePath;

    @ManyToOne(cascade = CascadeType.ALL)
    private JobPoster jobPoster;

   
    public Jobs() {
    }

    public Jobs(String jobtitle, String discription, String category, String industry, String bussinessFuntion, String role, BigDecimal minsalary, BigDecimal maxsalary, int totalvacncies, String dedlinedate, String imagePath, JobPoster jobPoster) {
        this.jobtitle = jobtitle;
        this.discription = discription;
        this.category = category;
        this.industry = industry;
        BussinessFuntion = bussinessFuntion;
        this.role = role;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
        this.totalvacncies = totalvacncies;
        this.dedlinedate = dedlinedate;
        this.imagePath = imagePath;
        this.jobPoster = jobPoster;
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

    @Column(columnDefinition = "LONGTEXT")
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

    public String getBussinessFuntion() {
        return BussinessFuntion;
    }

    public void setBussinessFuntion(String bussinessFuntion) {
        BussinessFuntion = bussinessFuntion;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public JobPoster getJobPoster() {
        return jobPoster;
    }

    public void setJobPoster(JobPoster jobPoster) {
        this.jobPoster = jobPoster;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "id=" + id +
                ", jobtitle='" + jobtitle + '\'' +
                ", discription='" + discription + '\'' +
                ", category='" + category + '\'' +
                ", industry='" + industry + '\'' +
                ", BussinessFuntion='" + BussinessFuntion + '\'' +
                ", role='" + role + '\'' +
                ", minsalary=" + minsalary +
                ", maxsalary=" + maxsalary +
                ", totalvacncies=" + totalvacncies +
                ", dedlinedate='" + dedlinedate + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", jobPoster=" + jobPoster +
                '}';
    }
}
