package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.JobSeeker;
import lk.ijse.jobportal.entity.Qulifications;
import lk.ijse.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Optional;

public interface JObSeekerRepository extends JpaRepository<JobSeeker,String> {

    @Query(value = "SELECT * FROM JobSeeker ",nativeQuery = true)
    ArrayList<JobSeeker> getALlJobSeeker();

    Optional<JobSeeker> findTopByUser(User user);
}
