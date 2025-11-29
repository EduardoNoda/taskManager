package br.com.taskmanager.taskmanager.service;

import br.com.taskmanager.taskmanager.model.RoleModel;
import br.com.taskmanager.taskmanager.model.UserModel;
import br.com.taskmanager.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserModel createUser(UserModel user) {
        if (userRepository.findByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.setRole(RoleModel.USER);
        return userRepository.save(user);
    }

    @Override
    public UserModel changeRoleToAdmin(Long userId) {
        UserModel user = getUserById(userId);
        user.setRole(RoleModel.ADMIN);
        return userRepository.save(user);
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserModel getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
