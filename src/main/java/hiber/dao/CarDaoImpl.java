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
        for(Car c : cars){
            sessionFactory.getCurrentSession().save(c);
            list.add(c);
        }
        return list;
    }

    @Override
    public List<Car> listCars() {
        List<Car> cars = sessionFactory.getCurrentSession().createQuery("from Car").getResultList();
        System.out.println(cars);
        return cars;
    }
}
