package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.JobSeekerProfileDTO;
import lk.ijse.jobportal.entity.JobSeeker;
import org.springframework.web.multipart.MultipartFile;

public interface JobSekerProfileService {

    public boolean saveSeekerDetails(JobSeekerProfileDTO jobSeekerProfileDTO);

    public boolean uploadImage(MultipartFile file);

    public boolean uploadCV(MultipartFile file);

    public JobSeekerProfileDTO searchSeeker(String userName);
}
