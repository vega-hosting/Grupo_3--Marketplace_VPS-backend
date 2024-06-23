package ufro.grupo3.vega_hosting.services;

import java.util.List;

import ufro.grupo3.vega_hosting.DTOs.UserDTO;

public interface UserService {

    public List<UserDTO> getAllUsers() throws Exception;

    public UserDTO getUserById(Integer id) throws Exception;

    public UserDTO createUser(UserDTO userDTO) throws Exception;

    public UserDTO updateUser(UserDTO userDTO) throws Exception;

    public void deleteUser(Integer id) throws Exception;

}
