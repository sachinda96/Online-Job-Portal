package lk.joinus.jobportal.service.impl;

import lk.joinus.jobportal.dto.JobSeekerProfileDTO;
import lk.joinus.jobportal.entity.JobSeeker;
import lk.joinus.jobportal.entity.User;
import lk.joinus.jobportal.repository.JObSeekerRepository;
import lk.joinus.jobportal.repository.UserRepository;
import lk.joinus.jobportal.service.JobSekerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class JobSeekerProfileServiceimpl implements JobSekerProfileService{
    @Autowired
    private JObSeekerRepository jobSeekerRepository;

    @Autowired
    private UserRepository userRepository;

    private String imagePath;

    private String CVPath;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<?> saveSeekerDetails(JobSeekerProfileDTO jobSeekerProfileDTO) {

        try {

            Optional<User> user=userRepository.findById(jobSeekerProfileDTO.getUserDTO().getUsername());

            if(user.isPresent()) {

                Optional<JobSeeker> jobSeeker = jobSeekerRepository.findById(jobSeekerProfileDTO.getId());

                if (!jobSeeker.isPresent()) {
                    jobSeeker = Optional.of(new JobSeeker());
                    ;
                    jobSeeker.get().setId(UUID.randomUUID().toString());
                }

                jobSeeker.get().setFirstName(jobSeekerProfileDTO.getFirstName());
                jobSeeker.get().setLastName(jobSeekerProfileDTO.getLastName());
                jobSeeker.get().setInterstIn(jobSeekerProfileDTO.getInterstIn());
                jobSeeker.get().setEmailAddress(jobSeekerProfileDTO.getEmailAddress());
                jobSeeker.get().setAddress(jobSeekerProfileDTO.getAddress());
                jobSeeker.get().setProvince(jobSeekerProfileDTO.getProvince());
                jobSeeker.get().setCity(jobSeekerProfileDTO.getCity());
                jobSeeker.get().setBirthDay(jobSeekerProfileDTO.getBirthDay());
                jobSeeker.get().setPhoneNumber(jobSeekerProfileDTO.getPhoneNumber());
                jobSeeker.get().setHighestEducation(jobSeekerProfileDTO.getHighestEducation());
                jobSeeker.get().setStream(jobSeekerProfileDTO.getStream());
                jobSeeker.get().setImagePath(jobSeekerProfileDTO.getImagePath());
                jobSeeker.get().setCvPath(jobSeekerProfileDTO.getCvPath());
                jobSeeker.get().setUser(user.get());

                jobSeekerRepository.save(jobSeeker.get());

                return new ResponseEntity<>("200",HttpStatus.OK);
            }

            return new ResponseEntity<>("204",HttpStatus.NO_CONTENT);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }

    }

    @Override
    public boolean uploadImage(MultipartFile file) {
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = null;
            try {

                outputStream = new BufferedOutputStream(
                        new FileOutputStream(
                                new File("F:/Server Images", file.getOriginalFilename())));
                imagePath = "http://localhost:8080/api/v1/profile/file?file=F:/Server Images/" + file.getOriginalFilename();
                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean uploadCV(MultipartFile file) {
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = null;
            try {

                outputStream = new BufferedOutputStream(
                        new FileOutputStream(
                                new File("F:/Server Images/CV", file.getOriginalFilename())));
                CVPath = "http://localhost:8080/api/v1/profile/file?file=F:/Server Images/CV/" + file.getOriginalFilename();
                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public ResponseEntity<?> searchSeeker(String userName) {

        try {


            Optional<User> user = userRepository.findById(userName);

            JobSeekerProfileDTO jobSeekerProfileDTO=new JobSeekerProfileDTO();

            if(user.isPresent()) {

                Optional<JobSeeker> jobSeeker = jobSeekerRepository.findTopByUser(user.get());

                if (jobSeeker.isPresent()) {

                    jobSeekerProfileDTO.setId(jobSeeker.get().getId());
                    jobSeekerProfileDTO.setFirstName(jobSeeker.get().getFirstName());
                    jobSeekerProfileDTO.setLastName(jobSeeker.get().getLastName());
                    jobSeekerProfileDTO.setInterstIn(jobSeeker.get().getInterstIn());
                    jobSeekerProfileDTO.setEmailAddress(jobSeeker.get().getEmailAddress());
                    jobSeekerProfileDTO.setAddress(jobSeeker.get().getAddress());
                    jobSeekerProfileDTO.setProvince(jobSeeker.get().getProvince());
                    jobSeekerProfileDTO.setCity(jobSeeker.get().getCity());
                    jobSeekerProfileDTO.setBirthDay(jobSeeker.get().getBirthDay());
                    jobSeekerProfileDTO.setPhoneNumber(jobSeeker.get().getPhoneNumber());
                    jobSeekerProfileDTO.setHighestEducation(jobSeeker.get().getHighestEducation());
                    jobSeekerProfileDTO.setStream(jobSeeker.get().getStream());
                    jobSeekerProfileDTO.setImagePath(jobSeeker.get().getImagePath());
                    jobSeekerProfileDTO.setCvPath(jobSeeker.get().getCvPath());


                }

            }

                return new ResponseEntity<>(jobSeekerProfileDTO,HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }



        }




}
