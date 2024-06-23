package ufro.grupo3.vega_hosting.mappers;

import ufro.grupo3.vega_hosting.DTOs.UserDTO;
import ufro.grupo3.vega_hosting.models.User;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelephone(user.getTelephone());
        userDTO.setCompanyName(user.getCompanyName());
        userDTO.setCity(user.getCity());
        userDTO.setAddress(user.getAddress());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setTelephone(dto.getTelephone());
        user.setCompanyName(dto.getCompanyName());
        user.setCity(dto.getCity());
        user.setAddress(dto.getAddress());
        user.setPassword(dto.getPassword());
        return user;
    }
}
