package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.ApplyJobDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyDetailReposotory extends JpaRepository<ApplyJobDetails,String> {
}
