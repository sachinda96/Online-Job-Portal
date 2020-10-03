package lk.joinus.jobportal.repository;

import lk.joinus.jobportal.entity.EducationCenterEntity;
import lk.joinus.jobportal.entity.EducationalPartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationCenterRepository extends JpaRepository<EducationCenterEntity,String >{
    List<EducationCenterEntity> findAllByEducationalPartnerEntityAndStatus(EducationalPartnerEntity educationalPartnerEntity, String active);

    long countByStatus(String active);
}
