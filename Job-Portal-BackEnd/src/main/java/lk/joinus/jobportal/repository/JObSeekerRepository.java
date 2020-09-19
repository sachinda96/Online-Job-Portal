package lk.joinus.jobportal.repository;

import lk.joinus.jobportal.entity.JobSeeker;
import lk.joinus.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Optional;

public interface JObSeekerRepository extends JpaRepository<JobSeeker,String> {

    @Query(value = "SELECT * FROM JobSeeker ",nativeQuery = true)
    ArrayList<JobSeeker> getALlJobSeeker();

    Optional<JobSeeker> findTopByUser(User user);
}
