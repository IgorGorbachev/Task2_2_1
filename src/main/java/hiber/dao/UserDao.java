package hiber.dao;

import hiber.model.User;
import java.util.List;

public interface UserDao {
   List<User> createListUsers(User... users);
   List<User> listUsers();
   List<User> addUserInListUsers(User... user);
}
