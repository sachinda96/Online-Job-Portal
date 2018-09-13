package lk.ijse.jobportal.repository;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaMethod;
import lk.ijse.jobportal.entity.JobPosterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPosterProfileRepository extends JpaRepository<JobPosterProfile,String> {
}
