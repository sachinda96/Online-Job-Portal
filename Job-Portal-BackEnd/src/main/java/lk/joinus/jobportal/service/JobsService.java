package lk.joinus.jobportal.service;

import lk.joinus.jobportal.dto.JobsDTO;
import lk.joinus.jobportal.dto.PostJobDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface JobsService {

    public ResponseEntity<?> addJob(PostJobDTO postJobDTO);

    public ArrayList<JobsDTO> getAllJObs();

    public ResponseEntity<?> getAllPostJobs();

    public ResponseEntity<?> getAllPostJobsByName(String name);

    public ResponseEntity<?> getAllJobsCount();

    public ResponseEntity<?> getAllJobsByUser(String userName);

    public ArrayList<PostJobDTO> getPosterPostedJobs(String username);

    public boolean uploadImage(MultipartFile file);

    public ResponseEntity<?> searchJob(String id);

    public boolean deleteJob(Long id);

    public boolean updateJob(PostJobDTO postJobDTO);

    public long getTotalJobs();
}
