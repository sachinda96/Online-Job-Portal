package lk.ijse.jobportal.repository;


import lk.ijse.jobportal.entity.Qulifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface QulificationRepository extends JpaRepository<Qulifications,Long> {

    @Query(value = "SELECT * FROM Qulifications",nativeQuery = true)
    ArrayList<Qulifications> getAllPostJob();
}
