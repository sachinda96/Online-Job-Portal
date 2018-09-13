package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.JobPoster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPosterReposistory extends JpaRepository<JobPoster,String> {
}
