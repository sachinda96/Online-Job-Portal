package lk.joinus.jobportal.dto;



public class ApplyJobMainDTO {

    private ApplyJobDTO applyJobDTO;
    private ApplyJobDetailsDTO applyJobDetails;
    private JobsDTO jobsDTO;
    private String userName;
    private String jobSeekerId;
    private String jobId;
    private String cvPath;

    public ApplyJobMainDTO() {
    }

    public ApplyJobMainDTO(ApplyJobDTO applyJobDTO, ApplyJobDetailsDTO applyJobDetails, JobsDTO jobsDTO) {
        this.applyJobDTO = applyJobDTO;
        this.applyJobDetails = applyJobDetails;
        this.jobsDTO = jobsDTO;
    }

    public ApplyJobDTO getApplyJobDTO() {
        return applyJobDTO;
    }

    public void setApplyJobDTO(ApplyJobDTO applyJobDTO) {
        this.applyJobDTO = applyJobDTO;
    }

    public ApplyJobDetailsDTO getApplyJobDetails() {
        return applyJobDetails;
    }

    public void setApplyJobDetails(ApplyJobDetailsDTO applyJobDetails) {
        this.applyJobDetails = applyJobDetails;
    }

    public JobsDTO getJobsDTO() {
        return jobsDTO;
    }

    public void setJobsDTO(JobsDTO jobsDTO) {
        this.jobsDTO = jobsDTO;
    }

    public String getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(String jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCvPath() {
        return cvPath;
    }

    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }
}
