package lk.joinus.jobportal.repository;

import lk.joinus.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
