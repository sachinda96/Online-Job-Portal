package lk.ijse.jobportal.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
public class ApplyJob {
    @Id
    private Long aid;
    private String data;
    @ManyToOne(fetch = FetchType.LAZY)
    private JobSeeker jobSeeker;

    public ApplyJob() {
    }

    public ApplyJob(Long id, String data, JobSeeker jobSeeker) {
        this.aid = id;
        this.data = data;
        this.jobSeeker = jobSeeker;
    }

    public Long getId() {
        return aid;
    }

    public void setId(Long id) {
        this.aid = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public String toString() {
        return "ApplyJob{" +
                "id=" + aid +
                ", data='" + data + '\'' +
                ", jobSeeker=" + jobSeeker +
                '}';
    }

}
