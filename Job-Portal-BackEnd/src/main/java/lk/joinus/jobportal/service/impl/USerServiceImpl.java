package lk.joinus.jobportal.service.impl;

import lk.joinus.jobportal.dto.UserDTO;
import lk.joinus.jobportal.entity.JobPoster;
import lk.joinus.jobportal.entity.User;
import lk.joinus.jobportal.repository.JobPosterReposistory;
import lk.joinus.jobportal.repository.UserRepository;
import lk.joinus.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class USerServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobPosterReposistory jobPosterReposistory;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addUser(UserDTO userDTO) {
        User user=new User(userDTO.getUsername(),userDTO.getEmail(),userDTO.getPassword());
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean login(String username, String pasword) {
        boolean exists = userRepository.existsById(username);

        if (!exists){
            jobPosterReposistory.existsById(username);
            JobPoster jobPoster = jobPosterReposistory.findById(username).get();

            return jobPoster.getPassword().equals(pasword);

        }

        User user = userRepository.findById(username).get();
        return user.getPassword().equals(pasword);


    }

    @Override
    public UserDTO loginUser(String username, String password)throws Exception {
        boolean exists = userRepository.existsById(username);

        if(!exists){
            jobPosterReposistory.existsById(username);
            JobPoster jobPoster = jobPosterReposistory.findById(username).get();

            if(jobPoster.getPassword().equalsIgnoreCase(password)){
                UserDTO userDTO = new UserDTO();
                userDTO.setEmail(jobPoster.getEmail());
                userDTO.setUsername(jobPoster.getUsername());
                userDTO.setType("POSTER");
                return userDTO;
            }

            throw new Exception("Invalid UserName Or Password");

        }else{
            boolean existsuser = userRepository.existsById(username);
            if(existsuser){
                User user = userRepository.findById(username).get();
                if (user.getPassword().equals(password)){
                    UserDTO userDTO=new UserDTO();
                    userDTO.setUsername(user.getUsername());
                    userDTO.setEmail(user.getEmail());
                    userDTO.setPassword(user.getPassword());
                    userDTO.setType("SEEKER");
                    return userDTO;
                }
                throw new Exception("Invalid UserName Or Password");
            }


        }
        throw new Exception("Failed to login");

    }
}
