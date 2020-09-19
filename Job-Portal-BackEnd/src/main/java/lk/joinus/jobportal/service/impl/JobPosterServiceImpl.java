package lk.joinus.jobportal.service.impl;

import lk.joinus.jobportal.dto.JobPosterDTO;
import lk.joinus.jobportal.entity.JobPoster;
import lk.joinus.jobportal.repository.JobPosterReposistory;
import lk.joinus.jobportal.service.JobPosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class JobPosterServiceImpl implements JobPosterService {


    @Autowired
    private JobPosterReposistory jobPosterReposistory;

    private JobPoster jobPosterMain;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addJobPoaser(JobPosterDTO jobPosterDTO) {
        JobPoster jobPoster=new JobPoster(jobPosterDTO.getUsername(),jobPosterDTO.getEmail(),jobPosterDTO.getCompanyname(),jobPosterDTO.getPassword());
        jobPosterReposistory.save(jobPoster);
        return true;
    }

    @Override
    public boolean login(String username, String pasword) {
        boolean exists = jobPosterReposistory.existsById(username);

        if (!exists){
            return false;
        }

        JobPoster jobPoster = jobPosterReposistory.findById(username).get();

        jobPosterMain=new JobPoster(jobPoster.getUsername(),jobPoster.getEmail(),jobPoster.getCompanyname(),jobPoster.getPassword());

        return jobPoster.getPassword().equals(pasword);
    }

    @Override
    public JobPosterDTO loginPoster() {
        JobPosterDTO jobPosterDTO=new JobPosterDTO(jobPosterMain.getUsername(),jobPosterMain.getEmail(),jobPosterMain.getCompanyname(),jobPosterMain.getPassword());
        return  jobPosterDTO;
    }
}
