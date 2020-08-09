package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.ApplyJobDTO;
import lk.ijse.jobportal.dto.ApplyJobMainDTO;
import org.springframework.http.ResponseEntity;

public interface ApplyJobService {

    public ResponseEntity<?> applyJob(ApplyJobMainDTO applyJobMainDTO);

    public ResponseEntity<?> getAllAppliedJobsByUser(String username);

    public ResponseEntity<?> getAllAppliedEmployeeByUser(String username);

    public ApplyJobDTO getLastData();
}
