package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.dto.*;
import lk.ijse.jobportal.entity.*;
import lk.ijse.jobportal.repository.ApplyDetailReposotory;
import lk.ijse.jobportal.repository.ApplyJobRepository;
import lk.ijse.jobportal.service.ApplyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ApplyJobServiceImpl implements ApplyJobService {
    @Autowired
    private ApplyJobRepository applyJobRepository;

    @Autowired
    private ApplyDetailReposotory applyDetailReposotory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean applyJob(ApplyJobMainDTO applyJobMainDTO) {

        UserDTO userDTO=applyJobMainDTO.getApplyJobDTO().getJobSeeker().getUserDTO();
        User user=new User(userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getPassword());

        JobSeekerProfileDTO jobSeekerProfileDTO=applyJobMainDTO.getApplyJobDTO().getJobSeeker();
        JobSeeker jobSeekers=new JobSeeker();
        jobSeekers.setId(jobSeekerProfileDTO.getId());
        jobSeekers.setFirstName(jobSeekerProfileDTO.getFirstName());
        jobSeekers.setLastName(jobSeekerProfileDTO.getLastName());
        jobSeekers.setInterstIn(jobSeekerProfileDTO.getInterstIn());
        jobSeekers.setEmailAddress(jobSeekerProfileDTO.getEmailAddress());
        jobSeekers.setAddress(jobSeekerProfileDTO.getAddress());
        jobSeekers.setProvince(jobSeekerProfileDTO.getProvince());
        jobSeekers.setCity(jobSeekerProfileDTO.getCity());
        jobSeekers.setBirthDay(jobSeekerProfileDTO.getBirthDay());
        jobSeekers.setPhoneNumber(jobSeekerProfileDTO.getPhoneNumber());
        jobSeekers.setHighestEducation(jobSeekerProfileDTO.getHighestEducation());
        jobSeekers.setStream(jobSeekerProfileDTO.getStream());
        jobSeekers.setImagePath(jobSeekerProfileDTO.getImagePath());
        jobSeekers.setCvPath(jobSeekerProfileDTO.getCvPath());
        jobSeekers.setUser(user);

        JobsDTO jobsDTO=applyJobMainDTO.getJobsDTO();
        JobPosterDTO jobPosterDTO=applyJobMainDTO.getJobsDTO().getJobPosterDTO();
        JobPoster jobPoster=new JobPoster(jobPosterDTO.getUsername(),jobPosterDTO.getEmail(),jobPosterDTO.getCompanyname(),jobPosterDTO.getPassword());
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

        ApplyJobDTO applyJobDTO=applyJobMainDTO.getApplyJobDTO();
        ApplyJob applyJob=new ApplyJob();
        applyJob.setId(applyJobDTO.getAid());
        applyJob.setData(applyJobMainDTO.getApplyJobDetails().getApplyData());
        applyJob.setJobSeeker(jobSeekers);



        ApplyJobDetails_PK applyJobDetails_pk=new ApplyJobDetails_PK();
        applyJobDetails_pk.setId(jobs.getId());
        applyJobDetails_pk.setAid(applyJob.getId());

        ApplyJobDetailsDTO applyJobDetailsDTO=applyJobMainDTO.getApplyJobDetails();
        ApplyJobDetails applyJobDetails=new ApplyJobDetails();
        applyJobDetails.setApplyData(applyJobDetailsDTO.getApplyData());
        applyJobDetails.setApplyJob(applyJob);
        applyJobDetails.setJobs(jobs);
        applyJobDetails.setApplyJobDetails_pk(applyJobDetails_pk);

        applyJobRepository.save(applyJob);

        applyDetailReposotory.save(applyJobDetails);

        return true;
    }

    @Override
    public ApplyJobDTO getLastData() {
        ApplyJob job = applyJobRepository.getJob();

        ApplyJobDTO applyJobDTO=new ApplyJobDTO();
        applyJobDTO.setAid(job.getId());
        applyJobDTO.setData(job.getData());

        return applyJobDTO;
    }

    @Override
    public ArrayList<ApplyJobMainDTO> getApplyJob(String userName) {
        ArrayList<ApplyJobDetails> aLlApplyJobDetails = applyDetailReposotory.getALlApplyJobDetails();

        ArrayList<ApplyJobMainDTO> applyJobMainDTOList=new ArrayList<>();
        ApplyJobDTO applyJobDTO=null;
        UserDTO userDTO=null;
        JobsDTO jobsDTO=null;
        JobPosterDTO jobPosterDTO=null;
        ApplyJobDetailsDTO applyJobDetailsDTO=null;
        JobSeekerProfileDTO jobSeekerProfileDTO=null;
        ApplyJobMainDTO applyJobMainDTO=null;
        for (ApplyJobDetails applyJobDetails:aLlApplyJobDetails
             ) {
            if (applyJobDetails.getJobs().getJobPoster().getUsername().equals(userName)) {

                User user = applyJobDetails.getApplyJob().getJobSeeker().getUser();
                userDTO = new UserDTO(user.getUsername(), user.getEmail(), user.getPassword());
                JobSeeker jobSeeker = applyJobDetails.getApplyJob().getJobSeeker();
                jobSeekerProfileDTO = new JobSeekerProfileDTO();
                jobSeekerProfileDTO.setId(jobSeeker.getId());
                jobSeekerProfileDTO.setFirstName(jobSeeker.getFirstName());
                jobSeekerProfileDTO.setLastName(jobSeeker.getLastName());
                jobSeekerProfileDTO.setEmailAddress(jobSeeker.getEmailAddress());
                jobSeekerProfileDTO.setAddress(jobSeeker.getAddress());
                jobSeekerProfileDTO.setCity(jobSeeker.getCity());
                jobSeekerProfileDTO.setProvince(jobSeeker.getProvince());
                jobSeekerProfileDTO.setPhoneNumber(jobSeeker.getPhoneNumber());
                jobSeekerProfileDTO.setInterstIn(jobSeeker.getInterstIn());
                jobSeekerProfileDTO.setStream(jobSeeker.getStream());
                jobSeekerProfileDTO.setImagePath(jobSeeker.getImagePath());
                jobSeekerProfileDTO.setCvPath(jobSeeker.getCvPath());
                jobSeekerProfileDTO.setHighestEducation(jobSeeker.getHighestEducation());
                jobSeekerProfileDTO.setUserDTO(userDTO);

                jobSeekerProfileDTO.setBirthDay(jobSeeker.getBirthDay());
                ApplyJob applyJob = applyJobDetails.getApplyJob();
                applyJobDTO = new ApplyJobDTO();
                applyJobDTO.setAid(applyJob.getId());
                applyJobDTO.setData(applyJob.getData());
                applyJobDTO.setJobSeeker(jobSeekerProfileDTO);

                JobPoster jobPoster = applyJobDetails.getJobs().getJobPoster();
                jobPosterDTO = new JobPosterDTO(jobPoster.getUsername(), jobPoster.getEmail(), jobPoster.getCompanyname(), jobPoster.getPassword());
                Jobs jobs = applyJobDetails.getJobs();
                jobsDTO = new JobsDTO(jobs.getId(), jobs.getJobtitle(), jobs.getDiscription(), jobs.getCategory(), jobs.getIndustry(),
                        jobs.getBussinessFuntion(), jobs.getRole(), jobs.getMinsalary(), jobs.getMaxsalary(), jobs.getTotalvacncies(), jobs.getDedlinedate(),
                        jobs.getImagePath(), jobPosterDTO);

                applyJobDetailsDTO = new ApplyJobDetailsDTO(applyJobDetails.getApplyData(), jobsDTO, applyJobDTO);

                applyJobMainDTO = new ApplyJobMainDTO();
                applyJobMainDTO.setApplyJobDetails(applyJobDetailsDTO);
                applyJobMainDTO.setApplyJobDTO(applyJobDTO);
                applyJobMainDTO.setJobsDTO(jobsDTO);

                applyJobMainDTOList.add(applyJobMainDTO);
            }
        }
        return applyJobMainDTOList;
    }


}
