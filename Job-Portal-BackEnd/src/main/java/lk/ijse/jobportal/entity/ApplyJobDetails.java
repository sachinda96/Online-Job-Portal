package lk.ijse.jobportal.entity;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
public class ApplyJobDetails {

    @Id
    private String id;
    private String applyData;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jid",insertable = false,updatable = false)
    private Jobs jobs;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aid",insertable = false,updatable = false)
    private ApplyJob applyJob;
//    @EmbeddedId
//    private ApplyJobDetails_PK applyJobDetails_pk;

    public ApplyJobDetails() {
    }

    public ApplyJobDetails(String applyData, Jobs jobs, ApplyJob applyJob) {
        this.applyData = applyData;
        this.jobs = jobs;
        this.applyJob = applyJob;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

//    public ApplyJobDetails_PK getApplyJobDetails_pk() {
//        return applyJobDetails_pk;
//    }
//
//    public void setApplyJobDetails_pk(ApplyJobDetails_PK applyJobDetails_pk) {
//        this.applyJobDetails_pk = applyJobDetails_pk;
//    }
}
