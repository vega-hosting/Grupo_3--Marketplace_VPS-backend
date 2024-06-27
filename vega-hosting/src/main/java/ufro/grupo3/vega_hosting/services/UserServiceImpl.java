package ufro.grupo3.vega_hosting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ufro.grupo3.vega_hosting.DTOs.UserDTO;
import ufro.grupo3.vega_hosting.mappers.UserMapper;
import ufro.grupo3.vega_hosting.models.Subscription;
import ufro.grupo3.vega_hosting.models.User;
import ufro.grupo3.vega_hosting.repositories.SubscriptionRepository;
import ufro.grupo3.vega_hosting.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        try {
            List<User> users = userRepository.findAll();
            return users.stream()
                    .map(UserMapper::toUserDTO)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new Exception("Error fetching users: " + e.getMessage());
        }
    }

    @Override
    public UserDTO getUserById(Integer id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return UserMapper.toUserDTO(optionalUser.get());
        } else {
            throw new Exception("User not found with id: " + id);
        }
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws Exception {
        try {
            User user = UserMapper.toEntity(userDTO);
            user = userRepository.save(user);
            return UserMapper.toUserDTO(user);
        } catch (DataAccessException e) {
            throw new Exception("Error creating user: " + e.getMessage());
        }
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) throws Exception {
        try {
            Optional<User> optionalUser = userRepository.findById(userDTO.getId());
            if (optionalUser.isPresent()) {
                User userToUpdate = optionalUser.get();
                userToUpdate.setName(userDTO.getName());
                userToUpdate.setEmail(userDTO.getEmail());
                userToUpdate.setTelephone(userDTO.getTelephone());
                userToUpdate.setCompanyName(userDTO.getCompanyName());
                userToUpdate.setCity(userDTO.getCity());
                userToUpdate.setAddress(userDTO.getAddress());
                userToUpdate.setPassword(userDTO.getPassword());

                userToUpdate = userRepository.save(userToUpdate);
                return UserMapper.toUserDTO(userToUpdate);
            } else {
                throw new Exception("User not found with id: " + userDTO.getId());
            }
        } catch (DataAccessException e) {
            throw new Exception("Error updating user: " + e.getMessage());
        }
    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        try {
            List<Subscription> subscriptions = subscriptionRepository.findByUserId(id);

            if (subscriptions != null && !subscriptions.isEmpty()) {
                for (Subscription subscription : subscriptions) {
                    subscriptionRepository.delete(subscription);
                }
            }
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
            } else {
                throw new Exception("User not found with id: " + id);
            }
        } catch (DataAccessException e) {
            throw new Exception("Error deleting user: " + e.getMessage());
        }
    }

}
