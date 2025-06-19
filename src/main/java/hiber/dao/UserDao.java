package hiber.dao;

import hiber.model.User;
import java.util.List;

public interface UserDao {
   List<User> createListUsers(User... users);
   List<User> listUsers();
   User getUserByCarModelAndSeries(String model, int series);
   List<User> addUserInListUsers(User... user);
}
