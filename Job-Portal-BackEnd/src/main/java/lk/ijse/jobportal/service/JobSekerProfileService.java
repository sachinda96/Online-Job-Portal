package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.JobSeekerProfileDTO;
import lk.ijse.jobportal.entity.JobSeeker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface JobSekerProfileService {

    public ResponseEntity<?> saveSeekerDetails(JobSeekerProfileDTO jobSeekerProfileDTO);

    public boolean uploadImage(MultipartFile file);

    public boolean uploadCV(MultipartFile file);

    public ResponseEntity<?> searchSeeker(String userName);
}
