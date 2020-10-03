package lk.joinus.jobportal.service;

import lk.joinus.jobportal.dto.EducationCenterDTO;
import lk.joinus.jobportal.dto.EducationalPartnerDTO;
import org.springframework.http.ResponseEntity;

public interface EducationalPartnerService {

    public boolean add(EducationalPartnerDTO educationalPartnerDTO);

    public ResponseEntity<?> addEducationCenter(EducationCenterDTO educationCenterDTO);

    public ResponseEntity<?> allEducationCenterByUser(String userName);

    public ResponseEntity<?> getEducationCenter(String id);

    public ResponseEntity<?> deleteEducationCenter(String id);

    public ResponseEntity<?> countAll();



}
