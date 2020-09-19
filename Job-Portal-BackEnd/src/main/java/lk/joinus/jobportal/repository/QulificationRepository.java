package lk.joinus.jobportal.repository;


import lk.joinus.jobportal.entity.Jobs;
import lk.joinus.jobportal.entity.Qulifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Optional;

public interface QulificationRepository extends JpaRepository<Qulifications,String> {

    @Query(value = "SELECT * FROM Qulifications",nativeQuery = true)
    ArrayList<Qulifications> getAllPostJob();

    Optional<Qulifications> findOneByJobs(Jobs jobs);
}
