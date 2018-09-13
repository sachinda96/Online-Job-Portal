package lk.ijse.jobportal.dto;



public class ApplyJobMainDTO {
    private ApplyJobDTO applyJobDTO;
    private ApplyJobDetailsDTO applyJobDetails;
    private JobsDTO jobsDTO;

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

    @Override
    public String toString() {
        return "ApplyJobMainDTO{" +
                "applyJobDTO=" + applyJobDTO +
                ", applyJobDetails=" + applyJobDetails +
                ", jobsDTO=" + jobsDTO +
                '}';
    }
}
