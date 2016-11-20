package uet.k59t.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.UserDTO;
import uet.k59t.model.User;
import uet.k59t.repository.UserRepository;

/**
 * Created by Long on 11/21/2016.
 */
@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public User createUser(UserDTO userDTO) {
        User user = userRepository.findByUserName(userDTO.getUserName());
        if(user == null){
            user = new User();
            user.setUserName(userDTO.getUserName());
            user.setPassword(userDTO.getPassword());
            return userRepository.save(user);
        }
        else {
            throw new NullPointerException("Username da ton tai");
        }
    }
}
