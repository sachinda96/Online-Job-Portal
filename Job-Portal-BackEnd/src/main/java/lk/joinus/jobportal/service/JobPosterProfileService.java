package lk.joinus.jobportal.service;

import lk.joinus.jobportal.dto.JObPosterProfileDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface JobPosterProfileService {

    public ResponseEntity<?> savePosterProfile(JObPosterProfileDTO posterProfileDTO);

    public ArrayList<JObPosterProfileDTO> viewProfileData();

    public JObPosterProfileDTO searchPosterProfile(String name);

    public ResponseEntity<?> uploadFile(MultipartFile file);

    public ResponseEntity<InputStreamResource> getImage(String path);

    public ResponseEntity<?> getJobPosterProfile(String userName);
}
