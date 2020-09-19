package lk.joinus.jobportal.service;

import lk.joinus.jobportal.dto.JobPosterDTO;

public interface JobPosterService {

    public boolean addJobPoaser(JobPosterDTO jobPosterDTO);

    public boolean login(String username,String pasword);

    public JobPosterDTO loginPoster();





}
