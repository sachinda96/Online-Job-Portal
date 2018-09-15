package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.ApplyJobDetails;
import lk.ijse.jobportal.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ApplyDetailReposotory extends JpaRepository<ApplyJobDetails,String> {

    @Query(value = "SELECT * FROM ApplyJobDetails ",nativeQuery = true)
    ArrayList<ApplyJobDetails> getALlApplyJobDetails();
}
