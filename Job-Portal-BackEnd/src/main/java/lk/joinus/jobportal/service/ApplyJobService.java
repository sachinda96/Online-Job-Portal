package lk.joinus.jobportal.service;

import lk.joinus.jobportal.dto.ApplyJobDTO;
import lk.joinus.jobportal.dto.ApplyJobMainDTO;
import org.springframework.http.ResponseEntity;

public interface ApplyJobService {

    public ResponseEntity<?> applyJob(ApplyJobMainDTO applyJobMainDTO);

    public ResponseEntity<?> getAllAppliedJobsByUser(String username);

    public ResponseEntity<?> getAllAppliedEmployeeByUser(String username);

    public ResponseEntity<?> countByAllAppliedJobs(String userName);

    public ApplyJobDTO getLastData();

}
