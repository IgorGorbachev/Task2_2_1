package hiber.service;


import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.ResourceTransactionManager;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private LocalSessionFactoryBean getSessionFactory;
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    private ResourceTransactionManager resourceTransactionManager;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public User getUserByCarModelAndSeries(String model, int series) {

        Car car = (Car) sessionFactory.getCurrentSession()
                .createQuery("from Car where model = :model and series = :series")
                .setParameter("model", model)
                .setParameter("series", series)
                .uniqueResult();
        if (car != null) {
            System.out.println(car.getUser());
            return car.getUser();
        } else {
            return null;
        }
    }
}
