package lk.joinus.jobportal.service.impl;

import lk.joinus.jobportal.dto.CoursesDTO;
import lk.joinus.jobportal.dto.EducationCenterDTO;
import lk.joinus.jobportal.entity.CourseEducationCenterEntity;
import lk.joinus.jobportal.entity.CoursesEntity;
import lk.joinus.jobportal.entity.EducationCenterEntity;
import lk.joinus.jobportal.repository.CourseEducationCenterRepository;
import lk.joinus.jobportal.repository.CoursesRepository;
import lk.joinus.jobportal.repository.EducationCenterRepository;
import lk.joinus.jobportal.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private EducationCenterRepository educationCenterRepository;

    @Autowired
    private CourseEducationCenterRepository courseEducationCenterRepository;

    @Override
    public ResponseEntity<?> postCourses(CoursesDTO coursesDTO) {

        try {

            if(coursesDTO.getId()!=null && coursesDTO.getId()!=""){

                if(!deleteCourse(coursesDTO.getId())){
                    throw new Exception("Update Failed");
                }

            }


            if(!coursesDTO.getEducationCenterDTOList().isEmpty()){
                CoursesEntity coursesEntity =new CoursesEntity();
                coursesEntity.setEducationalQualifications(coursesDTO.getEducationalQualifications());
                coursesEntity.setId(UUID.randomUUID().toString());
                coursesEntity.setImagePath(coursesDTO.getImagePath());
                coursesEntity.setLevel(coursesDTO.getLevel());
                coursesEntity.setMaxAge(coursesDTO.getMaxAge());
                coursesEntity.setMinAge(coursesDTO.getMinAge());
                coursesEntity.setName(coursesDTO.getName());
                coursesEntity.setStartDate(coursesDTO.getStartDate());
                coursesEntity.setType(coursesDTO.getType());
                coursesEntity.setStatus("ACTIVE");
                coursesEntity.setUser(coursesDTO.getUserName());
                coursesEntity.setDescription(coursesDTO.getDescription());
                coursesRepository.save(coursesEntity);
                for (EducationCenterDTO educationCenterDTO:coursesDTO.getEducationCenterDTOList()) {

                    Optional<EducationCenterEntity> educationCenterEntity = educationCenterRepository.findById(educationCenterDTO.getId());

                    if(educationCenterEntity.isPresent()){
                        CourseEducationCenterEntity courseEducationCenterEntity= new CourseEducationCenterEntity();
                        courseEducationCenterEntity.setCoursesEntity(coursesEntity);
                        courseEducationCenterEntity.setEducationCenterEntity(educationCenterEntity.get());
                        courseEducationCenterEntity.setId(UUID.randomUUID().toString());
                        courseEducationCenterRepository.save(courseEducationCenterEntity);
                    }
                }

                return new ResponseEntity<>("Successfully Save",HttpStatus.OK);

            }

            return new ResponseEntity<>("Failed to save",HttpStatus.NO_CONTENT);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public boolean deleteCourse(String id) throws Exception {
        Optional<CoursesEntity> coursesEntity =coursesRepository.findById(id);

        if(coursesEntity.isPresent()){

            coursesEntity.get().setStatus("INACTIVE");
            coursesRepository.save(coursesEntity.get());

            List<CourseEducationCenterEntity> courseEducationCenterEntities = courseEducationCenterRepository.findAllByCoursesEntity(coursesEntity.get());

            if(courseEducationCenterEntities!=null){
                courseEducationCenterRepository.deleteAll(courseEducationCenterEntities);

                return true;
            }

        }

return false;
    }

    @Override
    public ResponseEntity<?> updateCourses(CoursesDTO coursesDTO) {

        try {

            Optional<CoursesEntity> coursesEntity = coursesRepository.findById(coursesDTO.getId());

            if(!coursesEntity.isPresent()){
                throw  new Exception("Invalid Course Details");
            }

            coursesEntity.get().setEducationalQualifications(coursesDTO.getEducationalQualifications());
            coursesEntity.get().setId(UUID.randomUUID().toString());
            coursesEntity.get().setImagePath(coursesDTO.getImagePath());
            coursesEntity.get().setLevel(coursesDTO.getLevel());
            coursesEntity.get().setMaxAge(coursesDTO.getMaxAge());
            coursesEntity.get().setMinAge(coursesDTO.getMinAge());
            coursesEntity.get().setName(coursesDTO.getName());
            coursesEntity.get().setStartDate(coursesDTO.getStartDate());
            coursesEntity.get().setType(coursesDTO.getType());
            coursesEntity.get().setStatus("ACTIVE");

            return new ResponseEntity<>("Successfully Updated",HttpStatus.OK);


        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public ResponseEntity<?> allCoursesByEducationalCenter(String id) {

//        try {
//
//            Optional<EducationCenterEntity> educationCenterEntity = educationCenterRepository.findById(id);
//
//            if(!educationCenterEntity.isPresent()){
//                throw new Exception("Invalid Education Center Details");
//            }
//
//            List<CoursesEntity> coursesEntities = coursesRepository.findAllByEducationCenterEntityAndStatus(educationCenterEntity.get(),"ACTIVE");
//
//
//            List<CoursesDTO> coursesDTOList = new ArrayList<>();
//
//            if(coursesEntities!=null){
//
//                for (CoursesEntity coursesEntity : coursesEntities) {
//                    coursesDTOList.add(setCoursesDTO(coursesEntity));
//                }
//
//            }
//
//
//            return new ResponseEntity<>(coursesDTOList,HttpStatus.OK);
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return null;

    }

    @Override
    public ResponseEntity<?> allCourses() {
        try {

            List<CoursesEntity> coursesEntities = coursesRepository.findAllByStatus("ACTIVE");

            List<CoursesDTO> coursesDTOList = new ArrayList<>();

            if(coursesEntities!=null){

                for (CoursesEntity coursesEntity : coursesEntities) {
                    coursesDTOList.add(setCoursesDTO(coursesEntity));
                }

            }


            return new ResponseEntity<>(coursesDTOList,HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> searchCourses(String id) {

        try{

            Optional<CoursesEntity> coursesEntity =coursesRepository.findById(id);

            if(coursesEntity.isPresent()){
                return new ResponseEntity<>(setCoursesDTO(coursesEntity.get()),HttpStatus.OK);
            }

            throw new Exception("Invalid Course Details");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllCourseByUser(String userName) {

        try {

            List<CoursesEntity> coursesEntities = coursesRepository.findAllByStatusAndUser("ACTIVE",userName);


            List<CoursesDTO> coursesDTOList = new ArrayList<>();

            for (CoursesEntity coursesEntity : coursesEntities) {
                coursesDTOList.add(setCoursesDTO(coursesEntity));
            }

            return new ResponseEntity<>(coursesDTOList,HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public ResponseEntity<?> delete(String id) {

        try {

            if(deleteCourse(id)){
                return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
            }

            return new ResponseEntity<>("Failed to Deleted",HttpStatus.NO_CONTENT);

        } catch (Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


    }

    private CoursesDTO setCoursesDTO(CoursesEntity coursesEntity) {

        CoursesDTO coursesDTO = new CoursesDTO();
        coursesDTO.setEducationalQualifications(coursesEntity.getEducationalQualifications());
        coursesDTO.setImagePath(coursesEntity.getImagePath());
        coursesDTO.setLevel(coursesEntity.getLevel());
        coursesDTO.setMaxAge(coursesEntity.getMaxAge());
        coursesDTO.setMinAge(coursesEntity.getMinAge());
        coursesDTO.setName(coursesEntity.getName());
        coursesDTO.setStartDate(coursesEntity.getStartDate());
        coursesDTO.setType(coursesEntity.getType());
        coursesDTO.setId(coursesEntity.getId());
        coursesDTO.setDescription(coursesEntity.getDescription());

        List<CourseEducationCenterEntity> courseEducationCenterEntities = courseEducationCenterRepository.findAllByCoursesEntity(coursesEntity);

        List<EducationCenterDTO> educationCenterDTOList = new ArrayList<>();
        if(courseEducationCenterEntities!=null){
            for (CourseEducationCenterEntity courseEducationCenterEntity : courseEducationCenterEntities) {
                   educationCenterDTOList.add(setEducationCenter(courseEducationCenterEntity));
            }

        }

        coursesDTO.setEducationCenterDTOList(educationCenterDTOList);


        return coursesDTO;

    }

    private EducationCenterDTO setEducationCenter(CourseEducationCenterEntity courseEducationCenterEntity) {

        EducationCenterDTO educationCenterDTO = new EducationCenterDTO();
        educationCenterDTO.setTelNo(courseEducationCenterEntity.getEducationCenterEntity().getTelNo());
        educationCenterDTO.setId(courseEducationCenterEntity.getEducationCenterEntity().getId());
        educationCenterDTO.setGetEducationalCenterEmail(courseEducationCenterEntity.getEducationCenterEntity().getEmail());
        educationCenterDTO.setGetEducationalCenterAddress(courseEducationCenterEntity.getEducationCenterEntity().getAddress());
        educationCenterDTO.setFaxNo(courseEducationCenterEntity.getEducationCenterEntity().getFaxNo());
        educationCenterDTO.setEducationalCenterType(courseEducationCenterEntity.getEducationCenterEntity().getType());
        educationCenterDTO.setEducationalCenterName(courseEducationCenterEntity.getEducationCenterEntity().getName());
        educationCenterDTO.setBranch(courseEducationCenterEntity.getEducationCenterEntity().getBranch());
        return educationCenterDTO;
    }
}
