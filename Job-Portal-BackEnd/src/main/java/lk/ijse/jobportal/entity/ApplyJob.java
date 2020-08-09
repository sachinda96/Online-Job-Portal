package lk.ijse.jobportal.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
public class ApplyJob {

    @Id
    private String id;
    private String applyDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private JobSeeker jobSeeker;

    @ManyToOne(cascade = CascadeType.ALL)
    private Jobs jobs;

    private String cvPath;

    private String status;

    public ApplyJob() {
    }



    public String  getId() {
        return id=id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public String getCvPath() {
        return cvPath;
    }

    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
