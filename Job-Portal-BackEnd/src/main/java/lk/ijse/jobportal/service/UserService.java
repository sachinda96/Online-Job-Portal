package lk.ijse.jobportal.service;

import lk.ijse.jobportal.dto.UserDTO;

public interface UserService {

    public boolean addUser(UserDTO userDTO);

    public boolean login(String username,String pasword);

    public UserDTO loginUser(String username,String password)throws Exception;
}
