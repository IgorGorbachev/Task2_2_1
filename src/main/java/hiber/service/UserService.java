package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void createListUsers(User... user);

    List<User> listUsers();

    User getUserByCarModelAndSeries(String model, int series);

    List<User> addUserInListUsers(User... user);

    void addCarInUser(long userId, long carId);

    void addAllCarsInAllUsers();
}
