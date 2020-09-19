package lk.joinus.jobportal.repository;

import lk.joinus.jobportal.entity.JobPoster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPosterReposistory extends JpaRepository<JobPoster,String> {
}
