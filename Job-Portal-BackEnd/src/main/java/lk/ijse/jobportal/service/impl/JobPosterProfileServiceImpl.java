package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.JObPosterProfileDTO;
import lk.ijse.jobportal.dto.JobPosterDTO;
import lk.ijse.jobportal.entity.JobPoster;
import lk.ijse.jobportal.entity.JobPosterProfile;
import lk.ijse.jobportal.repository.JobPosterProfileRepository;
import lk.ijse.jobportal.service.JobPosterProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
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
    private JobPosterProfileRepository jobPosterProfileRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean savePosterProfile( JObPosterProfileDTO posterProfileDTO) {

        JobPosterDTO jobPosterDTO=posterProfileDTO.getJobPosterDTO();
        JobPoster jobPoster=new JobPoster(jobPosterDTO.getUsername(),jobPosterDTO.getEmail(),jobPosterDTO.getCompanyname(),jobPosterDTO.getPassword());

        JobPosterProfile jobPosterProfile=new JobPosterProfile();
        jobPosterProfile.setComapanyname(posterProfileDTO.getComapanyname());
        jobPosterProfile.setEmail(posterProfileDTO.getEmail());
        jobPosterProfile.setAddress(posterProfileDTO.getAddress());
        jobPosterProfile.setCity(posterProfileDTO.getCity());
        jobPosterProfile.setProvince(posterProfileDTO.getProvince());
        jobPosterProfile.setContactnumber(posterProfileDTO.getContactnumber());
        jobPosterProfile.setCompanyBackground(posterProfileDTO.getCompanyBackground());
        jobPosterProfile.setImagepaht(path);
        jobPosterProfile.setJobPoster(jobPoster);

        jobPosterProfileRepository.save(jobPosterProfile);

        return true;
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
        jobPosterProfileDTO.setImagePath(path);
        jobPosterProfileDTO.setJobPosterDTO(jobPosterDTO);


        return jobPosterProfileDTO;
    }

    @Override
    public boolean uploadFile(MultipartFile file) {

        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = null;
            try {

                outputStream = new BufferedOutputStream(
                        new FileOutputStream(
                                new File("F:/Server Images", file.getOriginalFilename())));
                path = "http://localhost:8080/api/v1/profile/file?file=F:/Server Images/" + file.getOriginalFilename();
                //  System.out.println(multipartFile.getOriginalFilename());
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
}
