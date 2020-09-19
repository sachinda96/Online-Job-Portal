package lk.joinus.jobportal.service;

import lk.joinus.jobportal.dto.UserDTO;

public interface UserService {

    public boolean addUser(UserDTO userDTO);

    public boolean login(String username,String pasword);

    public UserDTO loginUser(String username,String password)throws Exception;
}
