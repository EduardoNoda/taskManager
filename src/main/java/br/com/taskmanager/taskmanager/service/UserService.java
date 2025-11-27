package br.com.taskmanager.taskmanager.service;

import br.com.taskmanager.taskmanager.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel createUser(UserModel user);

    UserModel changeRoleToAdmin(UserModel user);

    List<UserModel> findAll();

    UserModel getUserByEmail(String email);

    boolean isUserEmailPresent(String email);

    UserModel getUserById(Long userId);

    void deleteUser(Long id);
}
