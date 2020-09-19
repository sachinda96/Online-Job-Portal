package lk.joinus.jobportal.dto;


public class ApplyJobDetailsDTO {
    private String applyData;
    private JobsDTO jobs;
    private ApplyJobDTO applyJob;

    public ApplyJobDetailsDTO() {
    }

    public ApplyJobDetailsDTO(String applyData, JobsDTO jobs, ApplyJobDTO applyJob) {
        this.applyData = applyData;
        this.jobs = jobs;
        this.applyJob = applyJob;
    }

    public String getApplyData() {
        return applyData;
    }

    public void setApplyData(String applyData) {
        this.applyData = applyData;
    }

    public JobsDTO getJobs() {
        return jobs;
    }

    public void setJobs(JobsDTO jobs) {
        this.jobs = jobs;
    }

    public ApplyJobDTO getApplyJob() {
        return applyJob;
    }

    public void setApplyJob(ApplyJobDTO applyJob) {
        this.applyJob = applyJob;
    }

    @Override
    public String toString() {
        return "ApplyJobDetailsDTO{" +
                "applyData='" + applyData + '\'' +
                ", jobs=" + jobs +
                ", applyJob=" + applyJob +
                '}';
    }
}
