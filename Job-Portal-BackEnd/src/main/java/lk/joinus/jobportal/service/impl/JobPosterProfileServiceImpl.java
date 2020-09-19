package lk.joinus.jobportal.service.impl;

import lk.joinus.jobportal.dto.JObPosterProfileDTO;
import lk.joinus.jobportal.dto.JobPosterDTO;
import lk.joinus.jobportal.dto.JsonFile;
import lk.joinus.jobportal.entity.JobPoster;
import lk.joinus.jobportal.entity.JobPosterProfile;
import lk.joinus.jobportal.repository.JobPosterProfileRepository;
import lk.joinus.jobportal.repository.JobPosterReposistory;
import lk.joinus.jobportal.service.JobPosterProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class JobPosterProfileServiceImpl implements JobPosterProfileService {
    private byte[] imageByte;
    private File file;
    private SerialBlob serialBlob;
    FileOutputStream fileOutputStream;
    private String path;
    private String FILE_PATH;

    @Autowired
    private JobPosterReposistory jobPosterReposistory;


    @Autowired
    private JobPosterProfileRepository jobPosterProfileRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<?> savePosterProfile( JObPosterProfileDTO posterProfileDTO) {


        try {

        JobPosterDTO jobPosterDTO=posterProfileDTO.getJobPosterDTO();

        Optional<JobPoster> jobPoster = jobPosterReposistory.findById(jobPosterDTO.getUsername());

        if(jobPoster.isPresent()){

            System.out.println(posterProfileDTO.getId());
            Optional<JobPosterProfile> jobPosterProfile =jobPosterProfileRepository.findById(posterProfileDTO.getId());

            if(!jobPosterProfile.isPresent()){
                jobPosterProfile= Optional.of(new JobPosterProfile());
                jobPosterProfile.get().setId(UUID.randomUUID().toString());
            }

            jobPosterProfile.get().setComapanyname(posterProfileDTO.getComapanyname());
            jobPosterProfile.get().setEmail(posterProfileDTO.getEmail());
            jobPosterProfile.get().setAddress(posterProfileDTO.getAddress());
            jobPosterProfile.get().setCity(posterProfileDTO.getCity());
            jobPosterProfile.get().setProvince(posterProfileDTO.getProvince());
            jobPosterProfile.get().setContactnumber(posterProfileDTO.getContactnumber());
            jobPosterProfile.get().setCompanyBackground(posterProfileDTO.getCompanyBackground());
            jobPosterProfile.get().setImagepaht(posterProfileDTO.getImagePath());
            jobPosterProfile.get().setJobPoster(jobPoster.get());
            jobPosterProfileRepository.save(jobPosterProfile.get());

            return new ResponseEntity<>("200",HttpStatus.OK);

        }

        return new ResponseEntity<>("204",HttpStatus.NO_CONTENT);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ArrayList<JObPosterProfileDTO> viewProfileData() {
        List<JobPosterProfile> allProfile = jobPosterProfileRepository.findAll();

        ArrayList<JObPosterProfileDTO> allDataProfile=new ArrayList();

        for (JobPosterProfile jobPosterProfile: allProfile
             ) {
            JObPosterProfileDTO jObPosterProfileDTO = new JObPosterProfileDTO();
            jObPosterProfileDTO.setComapanyname(jobPosterProfile.getComapanyname());
            jObPosterProfileDTO.setAddress(jobPosterProfile.getAddress());
            jObPosterProfileDTO.setCity(jobPosterProfile.getCity());
            jobPosterProfile.setEmail(jobPosterProfile.getEmail());
            jObPosterProfileDTO.setProvince(jobPosterProfile.getProvince());
            jObPosterProfileDTO.setContactnumber(jobPosterProfile.getContactnumber());
            jObPosterProfileDTO.setCompanyBackground(jobPosterProfile.getCompanyBackground());
            jObPosterProfileDTO.setImagePath(jobPosterProfile.getImagepaht());

            allDataProfile.add(jObPosterProfileDTO);

        }
        return  allDataProfile;

    }

    @Override
    public JObPosterProfileDTO searchPosterProfile(String name) {

        Optional<JobPosterProfile> byId = jobPosterProfileRepository.findById(name);
        JobPosterProfile jobPosterProfile=byId.get();

        JobPoster jobPoster=jobPosterProfile.getJobPoster();
        JobPosterDTO jobPosterDTO=new JobPosterDTO(jobPoster.getUsername(),jobPoster.getEmail(),jobPoster.getCompanyname(),jobPoster.getPassword());
        JObPosterProfileDTO jobPosterProfileDTO=new JObPosterProfileDTO();
        jobPosterProfileDTO.setComapanyname(jobPosterProfile.getComapanyname());
        jobPosterProfileDTO.setAddress(jobPosterProfile.getAddress());
        jobPosterProfileDTO.setCity(jobPosterProfile.getCity());
        jobPosterProfileDTO.setEmail(jobPosterProfile.getEmail());
        jobPosterProfileDTO.setProvince(jobPosterProfile.getProvince());
        jobPosterProfileDTO.setContactnumber(jobPosterProfile.getContactnumber());
        jobPosterProfileDTO.setCompanyBackground(jobPosterProfile.getCompanyBackground());
        jobPosterProfileDTO.setImagePath(jobPosterProfile.getImagepaht());
        jobPosterProfileDTO.setJobPosterDTO(jobPosterDTO);

        return jobPosterProfileDTO;
    }

    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file) {


        try {

            String filePath = "";

                BufferedOutputStream outputStream = null;
                    outputStream = new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("src/main/resources/images", file.getOriginalFilename())));
                    filePath = "http://localhost:8080/file?file=src/main/resources/images/" + file.getOriginalFilename();
                    //  System.out.println(multipartFile.getOriginalFilename());
                    outputStream.write(file.getBytes());
                    outputStream.flush();
                    outputStream.close();

                    return new ResponseEntity<>(new JsonFile(filePath), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<InputStreamResource> getImage(String path) {
        FILE_PATH=path;
        File file = new File(FILE_PATH);
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
                .body(resource);


    }

    @Override
    public ResponseEntity<?> getJobPosterProfile(String userName) {

        try {

            Optional<JobPoster> jobPoster = jobPosterReposistory.findById(userName);


            JObPosterProfileDTO jObPosterProfileDTO=new JObPosterProfileDTO();
            if(jobPoster.isPresent()){

                Optional<JobPosterProfile> jobPosterProfile = jobPosterProfileRepository.findOneByJobPoster(jobPoster.get());

                if(jobPosterProfile.isPresent()){

                    jObPosterProfileDTO.setId(jobPosterProfile.get().getId());
                    jObPosterProfileDTO.setAddress(jobPosterProfile.get().getAddress());
                    jObPosterProfileDTO.setCity(jobPosterProfile.get().getCity());
                    jObPosterProfileDTO.setComapanyname(jobPosterProfile.get().getComapanyname());
                    jObPosterProfileDTO.setCompanyBackground(jobPosterProfile.get().getCompanyBackground());
                    jObPosterProfileDTO.setImagePath(jobPosterProfile.get().getImagepaht());
                    jObPosterProfileDTO.setContactnumber(jobPosterProfile.get().getContactnumber());
                }


            }

            return new ResponseEntity<>(jObPosterProfileDTO,HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }


    }
}
