package lk.ijse.jobportal.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ApplyJobDetails implements Serializable {

    private String applyData;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id",referencedColumnName = "id",insertable = false,updatable = false)
    private Jobs jobs;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aid",referencedColumnName = "aid",insertable = false,updatable = false)
    private ApplyJob applyJob;
    @EmbeddedId
    private ApplyJobDetails_PK applyJobDetails_pk;

    public ApplyJobDetails() {
    }

    public ApplyJobDetails(String applyData, Jobs jobs, ApplyJob applyJob, ApplyJobDetails_PK applyJobDetails_pk) {
        this.applyData = applyData;
        this.jobs = jobs;
        this.applyJob = applyJob;
        this.applyJobDetails_pk = applyJobDetails_pk;
    }

    public String getApplyData() {
        return applyData;
    }

    public void setApplyData(String applyData) {
        this.applyData = applyData;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public ApplyJob getApplyJob() {
        return applyJob;
    }

    public void setApplyJob(ApplyJob applyJob) {
        this.applyJob = applyJob;
    }

    public ApplyJobDetails_PK getApplyJobDetails_pk() {
        return applyJobDetails_pk;
    }

    public void setApplyJobDetails_pk(ApplyJobDetails_PK applyJobDetails_pk) {
        this.applyJobDetails_pk = applyJobDetails_pk;
    }
}
