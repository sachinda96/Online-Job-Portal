package lk.joinus.jobportal.repository;

import lk.joinus.jobportal.entity.JobPoster;
import lk.joinus.jobportal.entity.JobPosterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobPosterProfileRepository extends JpaRepository<JobPosterProfile,String> {
    Optional<JobPosterProfile> findOneByJobPoster(JobPoster jobPoster);
}
