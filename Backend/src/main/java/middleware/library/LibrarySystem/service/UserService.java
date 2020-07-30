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
        System.out.println(user);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }

    public User getUserById(int id) throws Exception {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUserByName(String name) throws Exception {
        return userRepository.findByName(name);
    }

    public String deleteUser(int id) throws Exception {
        userRepository.deleteById(id);
        return "User removed with ID : " + id;
    }

    public User updateUser(User user) throws Exception {
        System.out.println(user.getUsr_id());
        User user1 = userRepository.findById(user.getUsr_id()).orElse(null);
        user1.setName(user.getName());
        user1.setAddress(user.getAddress());
        user1.setEmail(user.getEmail());
        user1.setDob(user.getDob());
        return userRepository.save(user1);
    }

}
