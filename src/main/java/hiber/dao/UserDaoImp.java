package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> createListUsers(User... users) {
        List<User> list = new ArrayList<>();
        for (User u : users) {
            sessionFactory.getCurrentSession().save(u);
            list.add(u);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<User> addUserInListUsers(User... users) {
        List<User> list = listUsers();
        for (User u : users) {
            sessionFactory.getCurrentSession().save(u);
            list.add(u);
        }
        return list;
    }

    @Override
    public List<User> listUsers() {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User").getResultList();
        System.out.println(list);
        return list;
    }

    @Override
    public User getUserByCarModelAndSeries(String model, int series) {
        Car car = sessionFactory.getCurrentSession()
                .createQuery("from Car where model = :model and series = :series", Car.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .getSingleResult();

        if (car != null) {
            System.out.println(car.getUser());
            return car.getUser();
        } else {
            return null;
        }
    }


}
