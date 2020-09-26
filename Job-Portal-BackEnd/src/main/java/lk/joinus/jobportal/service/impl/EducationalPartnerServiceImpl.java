package lk.joinus.jobportal.service.impl;

import lk.joinus.jobportal.dto.EducationCenterDTO;
import lk.joinus.jobportal.dto.EducationalPartnerDTO;
import lk.joinus.jobportal.entity.EducationCenterEntity;
import lk.joinus.jobportal.entity.EducationalPartnerEntity;
import lk.joinus.jobportal.repository.EducationCenterRepository;
import lk.joinus.jobportal.repository.EducationalPartnerRepository;
import lk.joinus.jobportal.service.EducationalPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EducationalPartnerServiceImpl implements EducationalPartnerService {

    @Autowired
    private EducationalPartnerRepository educationalPartnerRepository;

    @Autowired
    private EducationCenterRepository educationCenterRepository;

    @Override
    public boolean add(EducationalPartnerDTO educationalPartnerDTO) {

        try {

            if(!educationalPartnerRepository.existsById(educationalPartnerDTO.getUsername())){
                EducationalPartnerEntity educationalPartnerEntity = new EducationalPartnerEntity();
                educationalPartnerEntity.setEmail(educationalPartnerDTO.getEmail());
                educationalPartnerEntity.setPassword(educationalPartnerDTO.getPassword());
                educationalPartnerEntity.setUsername(educationalPartnerDTO.getUsername());
                educationalPartnerRepository.save(educationalPartnerEntity);
                return true;
            }

            throw new Exception("UserName Already Taken");

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public ResponseEntity<?> addEducationCenter(EducationCenterDTO educationCenterDTO) {
        try {

            Optional<EducationalPartnerEntity> educationalPartnerEntity = educationalPartnerRepository.findById(educationCenterDTO.getUserName());

            if(!educationalPartnerEntity.isPresent()){
                throw new Exception("Invalid educationalPartner details");
            }

            EducationCenterEntity educationCenterEntity = null;

            if(educationCenterDTO.getId()!= null && educationCenterDTO.getId()!=""){
                educationCenterEntity= educationCenterRepository.findById(educationCenterDTO.getId()).get();
            }else{
                educationCenterEntity = new EducationCenterEntity();
                educationCenterEntity.setId(UUID.randomUUID().toString());
            }


            educationCenterEntity.setAddress(educationCenterDTO.getGetEducationalCenterAddress());
            educationCenterEntity.setEmail(educationCenterDTO.getGetEducationalCenterEmail());
            educationCenterEntity.setFaxNo(educationCenterDTO.getFaxNo());
            educationCenterEntity.setStatus("ACTIVE");
            educationCenterEntity.setName(educationCenterDTO.getEducationalCenterName());
            educationCenterEntity.setTelNo(educationCenterDTO.getTelNo());
            educationCenterEntity.setType(educationCenterDTO.getEducationalCenterType());
            educationCenterEntity.setEducationalPartnerEntity(educationalPartnerEntity.get());
            educationCenterEntity.setBranch(educationCenterDTO.getBranch());
            educationCenterRepository.save(educationCenterEntity);

            return new ResponseEntity<>("Successfully Saved EducationCenter",HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> allEducationCenterByUser(String userName) {
        try {

            Optional<EducationalPartnerEntity> educationalPartnerEntity = educationalPartnerRepository.findById(userName);

            if(!educationalPartnerEntity.isPresent()){
                throw new Exception("Invalid educationalPartner details");
            }

            List<EducationCenterEntity> educationCenterEntities = educationCenterRepository.findAllByEducationalPartnerEntityAndStatus(educationalPartnerEntity.get(),"ACTIVE");

            List<EducationCenterDTO> educationCenterDTOList = new ArrayList<>();

            if(!educationCenterEntities.isEmpty()){

                for (EducationCenterEntity educationCenterEntity : educationCenterEntities) {
                    educationCenterDTOList.add(setEducationCenter(educationCenterEntity));
                }

            }

            return new ResponseEntity<>(educationCenterDTOList,HttpStatus.OK);


        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getEducationCenter(String id) {
        try {

            Optional<EducationCenterEntity> educationCenterEntity =educationCenterRepository.findById(id);

            if(educationCenterEntity.isPresent()){
                return new ResponseEntity<>(setEducationCenter(educationCenterEntity.get()),HttpStatus.OK);
            }
            throw new Exception("Invalid id");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public ResponseEntity<?> deleteEducationCenter(String id) {

        try {

            Optional<EducationCenterEntity> educationCenterEntity =educationCenterRepository.findById(id);

            if(educationCenterEntity.isPresent()){
                educationCenterEntity.get().setStatus("INACTIVE");
                educationCenterRepository.save(educationCenterEntity.get());
                return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
            }

            throw  new Exception("Invalid Id");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private EducationCenterDTO setEducationCenter(EducationCenterEntity educationCenterEntity) {

        EducationCenterDTO educationCenterDTO = new EducationCenterDTO();
        educationCenterDTO.setBranch(educationCenterEntity.getBranch());
        educationCenterDTO.setEducationalCenterName(educationCenterEntity.getName());
        educationCenterDTO.setEducationalCenterType(educationCenterEntity.getType());
        educationCenterDTO.setFaxNo(educationCenterEntity.getFaxNo());
        educationCenterDTO.setGetEducationalCenterAddress(educationCenterEntity.getAddress());
        educationCenterDTO.setGetEducationalCenterEmail(educationCenterEntity.getEmail());
        educationCenterDTO.setId(educationCenterEntity.getId());
        educationCenterDTO.setTelNo(educationCenterEntity.getTelNo());
        return educationCenterDTO;

    }
}
