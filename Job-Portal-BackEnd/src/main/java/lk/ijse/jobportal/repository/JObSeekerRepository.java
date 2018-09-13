package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.JobSeeker;
import lk.ijse.jobportal.entity.Qulifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface JObSeekerRepository extends JpaRepository<JobSeeker,Long> {

    @Query(value = "SELECT * FROM JobSeeker ",nativeQuery = true)
    ArrayList<JobSeeker> getALlJobSeeker();
}
