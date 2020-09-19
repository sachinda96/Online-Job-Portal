package lk.joinus.jobportal.service;

import lk.joinus.jobportal.dto.JobSeekerProfileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface JobSekerProfileService {

    public ResponseEntity<?> saveSeekerDetails(JobSeekerProfileDTO jobSeekerProfileDTO);

    public boolean uploadImage(MultipartFile file);

    public boolean uploadCV(MultipartFile file);

    public ResponseEntity<?> searchSeeker(String userName);
}
