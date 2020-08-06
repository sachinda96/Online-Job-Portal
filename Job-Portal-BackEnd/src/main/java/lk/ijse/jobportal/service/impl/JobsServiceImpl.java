package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.JobPosterDTO;
import lk.ijse.jobportal.dto.JobsDTO;
import lk.ijse.jobportal.dto.PostJobDTO;
import lk.ijse.jobportal.dto.QulificationDTO;
import lk.ijse.jobportal.entity.JobPoster;
import lk.ijse.jobportal.entity.Jobs;
import lk.ijse.jobportal.entity.Qulifications;
import lk.ijse.jobportal.repository.JobPosterReposistory;
import lk.ijse.jobportal.repository.JobsRepository;
import lk.ijse.jobportal.repository.QulificationRepository;
import lk.ijse.jobportal.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class JobsServiceImpl implements JobsService {

    private  byte[] byteObjects;
    private FileOutputStream fileOutputStream=null;
    private File file;
    private ArrayList<PostJobDTO> allPostJobs;
    private ArrayList<PostJobDTO> posterPostedJobs;
    private String path="";

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private QulificationRepository qulificationRepository;

    @Autowired
    private JobPosterReposistory jobPosterReposistory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<?> addJob(PostJobDTO postJobDTO) {

        try {

            JobPosterDTO jobPosterDTO=postJobDTO.getJobsDTO().getJobPosterDTO();
            JobPoster jobPoster=jobPosterReposistory.findById(jobPosterDTO.getUsername()).get();

            JobsDTO jobsDTO=postJobDTO.getJobsDTO();

            QulificationDTO qulificationDTO=postJobDTO.getQulificationDTO();

            Optional<Jobs> jobs = jobsRepository.findById(jobsDTO.getId());

            if(!jobs.isPresent()){
                jobs = Optional.of(new Jobs());
                jobs.get().setId(UUID.randomUUID().toString());
            }

            jobs.get().setJobtitle(jobsDTO.getJobtitle());
            jobs.get().setDiscription(jobsDTO.getDiscription());
            jobs.get().setCategory(jobsDTO.getCategory());
            jobs.get().setIndustry(jobsDTO.getIndustry());
            jobs.get().setBussinessFuntion(jobsDTO.getBussinessfuntion());
            jobs.get().setRole(jobsDTO.getRole());
            jobs.get().setMinsalary(jobsDTO.getMinsalary());
            jobs.get().setMaxsalary(jobsDTO.getMaxsalary());

            jobs.get().setTotalvacncies(jobsDTO.getTotalvacncies());
            jobs.get().setDedlinedate(jobsDTO.getDedlinedate());
            jobs.get().setImagePath(postJobDTO.getJobsDTO().getIamgePath());
            jobs.get().setJobPoster(jobPoster);



            Optional<Qulifications> qulifications = qulificationRepository.findById(qulificationDTO.getId());

            if(!qulifications.isPresent()){
                qulifications = Optional.of(new Qulifications());
                qulifications.get().setId(UUID.randomUUID().toString());
            }


            qulifications.get().setMinimumqulification(qulificationDTO.getMinimumqulification());
            qulifications.get().setEducationalspecialization(qulificationDTO.getEducationalspecialization());
            qulifications.get().setRequiredexperience(qulificationDTO.getRequiredexperience());
            qulifications.get().setGenderpreference(qulificationDTO.getGenderpreference());
            qulifications.get().setMaximumage(qulificationDTO.getMaximumage());
            qulifications.get().setSkill(qulificationDTO.getSkill());
            qulifications.get().setJobs(jobs.get());
            System.out.println(qulificationDTO.getMaximumage());
            qulifications.get().setMinimumage(qulificationDTO.getMinimumage());

            jobsRepository.save(jobs.get());
            qulificationRepository.save(qulifications.get());

            return new ResponseEntity<>("200", HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ArrayList<JobsDTO> getAllJObs() {
        ArrayList<JobsDTO> alljobsDto = new ArrayList<>();

        List<Jobs> alljobs = jobsRepository.findAll();

        for (Jobs jobs : alljobs) {
                JobsDTO jobsDTOl = new JobsDTO();
                System.out.println(jobs.getJobtitle());
                jobsDTOl.setJobtitle(jobs.getJobtitle());
                jobsDTOl.setDiscription(jobs.getDiscription());
                jobsDTOl.setBussinessfuntion(jobs.getBussinessFuntion());
                jobsDTOl.setCategory(jobs.getCategory());
                jobsDTOl.setIamgePath(jobs.getImagePath());
                jobsDTOl.setIndustry(jobs.getIndustry());
                jobsDTOl.setDedlinedate(jobs.getDedlinedate());
                jobsDTOl.setMinsalary(jobs.getMinsalary());
                jobsDTOl.setMaxsalary(jobs.getMaxsalary());
                jobsDTOl.setRole(jobs.getRole());
                jobsDTOl.setTotalvacncies(jobs.getTotalvacncies());

                alljobsDto.add(jobsDTOl);


            }
            return alljobsDto;
        }

    @Override
    public ArrayList<PostJobDTO> getAllPostJobs() {

        List<Qulifications> qulifications=qulificationRepository.getAllPostJob();

         allPostJobs=new ArrayList<>();


        for (Qulifications qulification:qulifications
             ) {
            Jobs jobs=qulification.getJobs();

            JobsDTO jobsDTOl=new JobsDTO();
            jobsDTOl.setId(jobs.getId());
            jobsDTOl.setJobtitle(jobs.getJobtitle());
            jobsDTOl.setDiscription(jobs.getDiscription());
            jobsDTOl.setBussinessfuntion(jobs.getBussinessFuntion());
            jobsDTOl.setCategory(jobs.getCategory());
            jobsDTOl.setIamgePath(jobs.getImagePath());
            jobsDTOl.setIndustry(jobs.getIndustry());
            jobsDTOl.setDedlinedate(jobs.getDedlinedate());
            jobsDTOl.setMinsalary(jobs.getMinsalary());
            jobsDTOl.setMaxsalary(jobs.getMaxsalary());
            jobsDTOl.setRole(jobs.getRole());
            jobsDTOl.setTotalvacncies(jobs.getTotalvacncies());

            JobPoster jobPoster=jobs.getJobPoster();
            JobPosterDTO jobPosterDTO=new JobPosterDTO(jobPoster.getUsername(),jobPoster.getEmail(),jobPoster.getCompanyname(),jobPoster.getPassword());

            jobsDTOl.setJobPosterDTO(jobPosterDTO);


            QulificationDTO qulificationDTO=new QulificationDTO();
            qulificationDTO.setId(qulification.getId());
            qulificationDTO.setMinimumqulification(qulification.getMinimumqulification());
            qulificationDTO.setEducationalspecialization(qulification.getEducationalspecialization());
            qulificationDTO.setRequiredexperience(qulification.getRequiredexperience());
            qulificationDTO.setGenderpreference(qulification.getGenderpreference());
            qulificationDTO.setMaximumage(qulification.getMaximumage());
            qulificationDTO.setSkill(qulification.getSkill());

            PostJobDTO postJobDTO=new PostJobDTO(jobsDTOl,qulificationDTO);

            allPostJobs.add(postJobDTO);
        }

        return  allPostJobs;

    }

    @Override
    public ArrayList<PostJobDTO> getPosterPostedJobs(String username) {
        getAllJObs();
        ArrayList<PostJobDTO> allPostJob=allPostJobs;

        posterPostedJobs=new ArrayList<>();
        System.out.println("set");
        JobsDTO jobs=null;
        JobPosterDTO jobPosters=null;
        QulificationDTO qulification=null;
        PostJobDTO postJobDTOs=null;
        QulificationDTO qulificationDTOs=null;

        for (PostJobDTO postJobDTO:allPostJob
             ) {

            System.out.println(postJobDTO.getJobsDTO().getJobPosterDTO().getUsername());
            if (username.equals(postJobDTO.getJobsDTO().getJobPosterDTO().getUsername())) {
                System.out.println(username.equals(postJobDTO.getJobsDTO().getJobPosterDTO().getUsername()));
                jobs = postJobDTO.getJobsDTO();

                JobsDTO jobsDTOl = new JobsDTO();
                System.out.println(jobs.getCategory());
                jobsDTOl.setId(jobs.getId());
                jobsDTOl.setJobtitle(jobs.getJobtitle());
                jobsDTOl.setDiscription(jobs.getDiscription());
                jobsDTOl.setBussinessfuntion(jobs.getBussinessfuntion());
                jobsDTOl.setCategory(jobs.getCategory());
                jobsDTOl.setIamgePath(jobs.getIamgePath());
                jobsDTOl.setIndustry(jobs.getIndustry());
                jobsDTOl.setDedlinedate(jobs.getDedlinedate());
                jobsDTOl.setMinsalary(jobs.getMinsalary());
                jobsDTOl.setMaxsalary(jobs.getMaxsalary());
                jobsDTOl.setRole(jobs.getRole());
                jobsDTOl.setTotalvacncies(jobs.getTotalvacncies());

                System.out.println(jobsDTOl);
                jobPosters = jobs.getJobPosterDTO();
                JobPosterDTO jobPosterDTO = new JobPosterDTO(jobPosters.getUsername(), jobPosters.getEmail(), jobPosters.getCompanyname(), jobPosters.getPassword());

                System.out.println(jobPosterDTO);

                jobsDTOl.setJobPosterDTO(jobPosterDTO);


                qulification = postJobDTO.getQulificationDTO();

                System.out.println(qulification);
                qulificationDTOs = new QulificationDTO();
                qulificationDTOs.setId(qulification.getId());
                qulificationDTOs.setMinimumqulification(qulification.getMinimumqulification());
                qulificationDTOs.setEducationalspecialization(qulification.getEducationalspecialization());
                qulificationDTOs.setRequiredexperience(qulification.getRequiredexperience());
                qulificationDTOs.setGenderpreference(qulification.getGenderpreference());
                qulificationDTOs.setMaximumage(qulification.getMaximumage());
                qulificationDTOs.setSkill(qulification.getSkill());

                System.out.println(qulificationDTOs);
                System.out.println(jobsDTOl);
                postJobDTOs = new PostJobDTO();
                System.out.println(qulificationDTOs.getEducationalspecialization());
                postJobDTOs.setJobsDTO(jobsDTOl);
               postJobDTOs.setQulificationDTO(qulificationDTOs);
                System.out.println(postJobDTOs.getQulificationDTO().getEducationalspecialization());

                posterPostedJobs.add(postJobDTOs);
                System.out.println(posterPostedJobs);
            }
        }

        return posterPostedJobs;
    }

    @Override
    public boolean uploadImage(MultipartFile file) {

        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = null;
            try {

                outputStream = new BufferedOutputStream(
                        new FileOutputStream(
                                new File("F:/Server Images/jobs", file.getOriginalFilename())));
                path = "http://localhost:8080/api/v1/profile/file?file=F:/Server Images/jobs/" + file.getOriginalFilename();
                System.out.println(path);
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
    public ResponseEntity<?> searchJob(String id) {


        try {

            PostJobDTO postJobDTO = new PostJobDTO();

            Optional<Jobs> jobs = jobsRepository.findById(id);

            if(jobs.isPresent()){

                JobsDTO jobsDTOl = new JobsDTO();
                jobsDTOl.setId(jobs.get().getId());
                jobsDTOl.setJobtitle(jobs.get().getJobtitle());
                jobsDTOl.setDiscription(jobs.get().getDiscription());
                jobsDTOl.setBussinessfuntion(jobs.get().getBussinessFuntion());
                jobsDTOl.setCategory(jobs.get().getCategory());
                jobsDTOl.setIamgePath(jobs.get().getImagePath());
                jobsDTOl.setIndustry(jobs.get().getIndustry());
                jobsDTOl.setDedlinedate(jobs.get().getDedlinedate());
                jobsDTOl.setMinsalary(jobs.get().getMinsalary());
                jobsDTOl.setMaxsalary(jobs.get().getMaxsalary());
                jobsDTOl.setRole(jobs.get().getRole());
                jobsDTOl.setTotalvacncies(jobs.get().getTotalvacncies());
                postJobDTO.setJobsDTO(jobsDTOl);

                Optional<Qulifications> qulifications = qulificationRepository.findOneByJobs(jobs.get());

                if(qulifications.isPresent()){
                    QulificationDTO qulificationDTOs = new QulificationDTO();
                    qulificationDTOs.setId(qulifications.get().getId());
                    qulificationDTOs.setMinimumqulification(qulifications.get().getMinimumqulification());
                    qulificationDTOs.setEducationalspecialization(qulifications.get().getEducationalspecialization());
                    qulificationDTOs.setRequiredexperience(qulifications.get().getRequiredexperience());
                    qulificationDTOs.setGenderpreference(qulifications.get().getGenderpreference());
                    qulificationDTOs.setMaximumage(qulifications.get().getMaximumage());
                    qulificationDTOs.setMinimumage(qulifications.get().getMinimumage());
                    qulificationDTOs.setSkill(qulifications.get().getSkill());
                    postJobDTO.setQulificationDTO(qulificationDTOs);
                }

            }

            return new ResponseEntity<>(postJobDTO,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public boolean deleteJob(Long id) {

        qulificationRepository.deleteById(id.toString());
        return true;
    }

    @Override
    public boolean updateJob(PostJobDTO postJobDTO) {
        JobPosterDTO jobPosterDTO=postJobDTO.getJobsDTO().getJobPosterDTO();
        JobPoster jobPoster=new JobPoster(jobPosterDTO.getUsername(),jobPosterDTO.getEmail(),jobPosterDTO.getCompanyname(),jobPosterDTO.getPassword());

        JobsDTO jobsDTO=postJobDTO.getJobsDTO();

        QulificationDTO qulificationDTO=postJobDTO.getQulificationDTO();
        System.out.println(postJobDTO.getJobsDTO().getCategory());
        System.out.println(jobsDTO.getBussinessfuntion());
        System.out.println(postJobDTO.getQulificationDTO().getGenderpreference());
        System.out.println(qulificationDTO.getGenderpreference());

        Jobs jobs=new Jobs();
        jobs.setId(jobsDTO.getId());
        jobs.setJobtitle(jobsDTO.getJobtitle());
        jobs.setDiscription(jobsDTO.getDiscription());
        jobs.setCategory(jobsDTO.getCategory());
        jobs.setIndustry(jobsDTO.getIndustry());
        jobs.setBussinessFuntion(jobsDTO.getBussinessfuntion());
        jobs.setRole(jobsDTO.getRole());
        jobs.setMinsalary(jobsDTO.getMinsalary());
        jobs.setMaxsalary(jobsDTO.getMaxsalary());
        jobs.setTotalvacncies(jobsDTO.getTotalvacncies());
        jobs.setDedlinedate(jobsDTO.getDedlinedate());
        jobs.setImagePath(jobsDTO.getIamgePath());
        jobs.setJobPoster(jobPoster);

        Qulifications qulifications=new Qulifications();
        qulifications.setId(qulificationDTO.getId());
        qulifications.setMinimumqulification(qulificationDTO.getMinimumqulification());
        qulifications.setEducationalspecialization(qulificationDTO.getEducationalspecialization());
        qulifications.setRequiredexperience(qulificationDTO.getRequiredexperience());
        qulifications.setGenderpreference(qulificationDTO.getGenderpreference());
        qulifications.setMaximumage(qulificationDTO.getMaximumage());
        qulifications.setSkill(qulificationDTO.getSkill());
        qulifications.setJobs(jobs);

        jobsRepository.save(jobs);
        qulificationRepository.save(qulifications);

        return true;
    }

    @Override
    public long getTotalJobs() {
        return jobsRepository.getTotalCustomers();
    }


}
