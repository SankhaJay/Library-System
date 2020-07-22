package middleware.library.LibrarySystem.service;

import middleware.library.LibrarySystem.entity.User;
import middleware.library.LibrarySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) throws Exception {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }

    public User getUserByNIC(String nic) throws Exception {
        return userRepository.findById(nic).orElse(null);
    }

    public User getUserByName(String name) throws Exception {
        return userRepository.findByName(name);
    }

    public String deleteUser(String nic) throws Exception {
        userRepository.deleteById(nic);
        return "User removed with NIC : " + nic;
    }

    public User updateUser(User user) throws Exception {
        User user1 = userRepository.findById(user.getNic()).orElse(null);
        user1.setName(user.getName());
        user1.setAddress(user.getAddress());
        user1.setAge(user.getAge());
        return userRepository.save(user1);
    }

}
