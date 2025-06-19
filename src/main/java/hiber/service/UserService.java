package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void createListUsers(User... user);
    List<User> listUsers();
    List<User> addUserInListUsers(User... user);
}
