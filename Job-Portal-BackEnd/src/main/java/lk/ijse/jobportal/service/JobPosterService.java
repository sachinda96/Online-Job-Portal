package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.JobPosterDTO;
import org.springframework.web.multipart.MultipartFile;

public interface JobPosterService {

    public boolean addJobPoaser(JobPosterDTO jobPosterDTO);

    public boolean login(String username,String pasword);

    public JobPosterDTO loginPoster();





}
