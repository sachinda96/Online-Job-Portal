package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.ApplyJob;
import lk.ijse.jobportal.entity.JobSeeker;
import lk.ijse.jobportal.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface ApplyJobRepository extends JpaRepository<ApplyJob,String> {

    @Query(value = " select * from ApplyJob ORDER BY aid DESC LIMIT 1",nativeQuery = true)
    ApplyJob getJob();

    List<ApplyJob> findAllByJobSeeker(JobSeeker jobSeeker);

    List<ApplyJob> findAllByJobsIn(List<Jobs> jobs);

    long countByJobSeeker(JobSeeker jobSeeker);
}
