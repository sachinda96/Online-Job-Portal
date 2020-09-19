package lk.joinus.jobportal.repository;

import lk.joinus.jobportal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
