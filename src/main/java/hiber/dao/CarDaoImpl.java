package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Car> createListCars(Car... cars) {
        List<Car> list = new ArrayList<>();
        for (Car c : cars) {
            sessionFactory.getCurrentSession().save(c);
            list.add(c);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Car> addCarInListCars(Car... cars) {
        List<Car> list = listCars();
        for (Car c : cars) {
            sessionFactory.getCurrentSession().save(c);
            list.add(c);
        }
        return list;
    }
    @Override
    public void addCarInUser(long userId, long carId) {
        User user = sessionFactory.getCurrentSession().get(User.class, userId);
        Car car = sessionFactory.getCurrentSession().get(Car.class, carId);
        user.setCar(car);
        car.setUser(user);
    }

    @Override
    public void addAllCarsInAllUsers() {

        List<User> listUsers = sessionFactory.getCurrentSession().createQuery("from User").getResultList();
        List<Car> listCars = listCars();
        for (User u : listUsers) {
            if (u != null && u.getId() <= listCars.size()) {
                int index = Math.toIntExact((u.getId() - 1));
                if (index >= 0 && index < listCars.size()) {
                    Car car = listCars.get(index);
                    if (car != null) {
                        u.setCar(car);
                    }
                }
            }
        }
    }

    @Override
    public List<Car> listCars() {
        List<Car> cars = sessionFactory.getCurrentSession().createQuery("from Car").getResultList();
        System.out.println(cars);
        return cars;
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
