package lk.joinus.jobportal.dto;

public class PostJobDTO {
    private JobsDTO jobsDTO;
    private QulificationDTO qulificationDTO;

    public PostJobDTO() {
    }

    public PostJobDTO(JobsDTO jobsDTO, QulificationDTO qulificationDTO) {
        this.jobsDTO = jobsDTO;
        this.qulificationDTO = qulificationDTO;
    }

    public JobsDTO getJobsDTO() {
        return jobsDTO;
    }

    public void setJobsDTO(JobsDTO jobsDTO) {
        this.jobsDTO = jobsDTO;
    }

    public QulificationDTO getQulificationDTO() {
        return qulificationDTO;
    }

    public void setQulificationDTO(QulificationDTO qulificationDTO) {
        this.qulificationDTO = qulificationDTO;
    }

    @Override
    public String toString() {
        return "PostJobDTO{" +
                "jobsDTO=" + jobsDTO +
                ", qulificationDTO=" + qulificationDTO +
                '}';
    }
}
