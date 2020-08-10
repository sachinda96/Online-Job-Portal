package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.*;
import lk.ijse.jobportal.entity.*;
import lk.ijse.jobportal.repository.*;
import lk.ijse.jobportal.service.ApplyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ApplyJobServiceImpl implements ApplyJobService {
    @Autowired
    private ApplyJobRepository applyJobRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JObSeekerRepository jObSeekerRepository;

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private JobPosterReposistory jobPosterReposistory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<?> applyJob(ApplyJobMainDTO applyJobMainDTO) {

        try {

            Optional<User> user=userRepository.findById(applyJobMainDTO.getUserName());

            Optional<Jobs> jobs = jobsRepository.findById(applyJobMainDTO.getJobId());

            if(user.isPresent() && jobs.isPresent()){

                Optional<JobSeeker> jobSeeker = jObSeekerRepository.findTopByUser(user.get());

                if(jobSeeker.isPresent()){

                    ApplyJob applyJob=new ApplyJob();
                    applyJob.setId(UUID.randomUUID().toString());
                    applyJob.setApplyDate(dateToString(new Date()));
                    applyJob.setJobSeeker(jobSeeker.get());
                    applyJob.setJobs(jobs.get());
                    applyJob.setCvPath(jobSeeker.get().getCvPath());

                    applyJobRepository.save(applyJob);

                    return new ResponseEntity<>("200", HttpStatus.OK);

                }

            }

            return new ResponseEntity<>("204", HttpStatus.NO_CONTENT);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<?> getAllAppliedJobsByUser(String username) {

        try {

            Optional<User> user =userRepository.findById(username);

            List<ViewAppliedJobDTO> viewAppliedJobDTOList = new ArrayList<>();

            if(user.isPresent()){

                Optional<JobSeeker> jobSeeker = jObSeekerRepository.findTopByUser(user.get());

                if(jobSeeker.isPresent()){

                    List<ApplyJob> applyJobList = applyJobRepository.findAllByJobSeeker(jobSeeker.get());

                    if(applyJobList != null){

                        for (ApplyJob applyJob : applyJobList) {

                            ViewAppliedJobDTO viewAppliedJobDTO = new ViewAppliedJobDTO();
                            viewAppliedJobDTO.setApplyDate(applyJob.getApplyDate());
                            viewAppliedJobDTO.setCompanyName(applyJob.getJobs().getJobPoster().getCompanyname());
                            viewAppliedJobDTO.setJobTitle(applyJob.getJobs().getJobtitle());
                            viewAppliedJobDTO.setIndustry(applyJob.getJobs().getIndustry());
                            viewAppliedJobDTO.setJobCategory(applyJob.getJobs().getCategory());
                            viewAppliedJobDTO.setJobId(applyJob.getJobs().getId());

                            viewAppliedJobDTOList.add(viewAppliedJobDTO);

                        }

                    }

                }

            }

            return new ResponseEntity<>(viewAppliedJobDTOList,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllAppliedEmployeeByUser(String username) {

        try {

            Optional<JobPoster> jobPoster = jobPosterReposistory.findById(username);

            List<NewEmployeeDTO> newEmployeeDTOList = new ArrayList<>();

            if (jobPoster.isPresent()){

               List<Jobs> jobs = jobsRepository.findAllByJobPoster(jobPoster.get());

               if(jobs != null){

                   List<ApplyJob> applyJobList = applyJobRepository.findAllByJobsIn(jobs);

                   if(applyJobList != null){

                       for (ApplyJob applyJob : applyJobList) {
                           NewEmployeeDTO newEmployeeDTO = new NewEmployeeDTO();
                           newEmployeeDTO.setAppliedDate(applyJob.getApplyDate());
                           newEmployeeDTO.setCvPath(applyJob.getCvPath());
                           newEmployeeDTO.setId(applyJob.getId());
                           newEmployeeDTO.setJobCategory(applyJob.getJobs().getCategory());
                           newEmployeeDTO.setJobSeekerName(applyJob.getJobSeeker().getFirstName()+" "+applyJob.getJobSeeker().getLastName());
                           newEmployeeDTO.setJobTitle(applyJob.getJobs().getJobtitle());
                           newEmployeeDTOList.add(newEmployeeDTO);
                       }

                   }

               }

            }

            return new ResponseEntity<>(newEmployeeDTOList,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<?> countByAllAppliedJobs(String userName) {

        try {

        Optional<User> user = userRepository.findById(userName);

        if(user.isPresent()){

           Optional<JobSeeker> jobSeeker = jObSeekerRepository.findTopByUser(user.get());

           if (jobSeeker.isPresent()){
              return new ResponseEntity<>(applyJobRepository.countByJobSeeker(jobSeeker.get()),HttpStatus.OK);
           }

        }
            return new ResponseEntity<>(0,HttpStatus.NO_CONTENT);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String dateToString(Date date)throws Exception{

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        return dateFormat.format(date);
    }

    @Override
    public ApplyJobDTO getLastData() {
        ApplyJob job = applyJobRepository.getJob();

        ApplyJobDTO applyJobDTO=new ApplyJobDTO();
        ////applyJobDTO.setAid(job.getId().t);
       // applyJobDTO.setData(job.getData());

        return applyJobDTO;
    }
}
