package hiber.service;


import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void createListUsers(User... user) {
        userDao.createListUsers(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Transactional
    @Override
    public List<User> addUserInListUsers(User... user) {
        return userDao.addUserInListUsers(user);
    }


}
