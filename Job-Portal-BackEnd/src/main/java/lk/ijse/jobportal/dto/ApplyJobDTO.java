package lk.ijse.jobportal.dto;

import lk.ijse.jobportal.entity.JobSeeker;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

public class ApplyJobDTO {
    private Long aid;
    private String data;
    private JobSeekerProfileDTO jobSeeker;

    public ApplyJobDTO() {
    }

    public ApplyJobDTO(Long aid, String data, JobSeekerProfileDTO jobSeeker) {
        this.aid = aid;
        this.data = data;
        this.jobSeeker = jobSeeker;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public JobSeekerProfileDTO getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeekerProfileDTO jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

}
