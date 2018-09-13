package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.ApplyJobDTO;
import lk.ijse.jobportal.dto.ApplyJobMainDTO;

public interface ApplyJobService {
    public boolean applyJob(ApplyJobMainDTO applyJobMainDTO);

    public ApplyJobDTO getLastData();
}
