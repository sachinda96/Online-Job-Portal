package lk.ijse.jobportal.repository;

import lk.ijse.jobportal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
