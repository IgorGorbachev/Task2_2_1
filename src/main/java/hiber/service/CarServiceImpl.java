package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public List<Car> createListCars(Car... cars) {
        return carDao.createListCars(cars);
    }
    @Transactional
    @Override
    public List<Car> addCarInListCars(Car... cars) {
        return carDao.addCarInListCars(cars);
    }

    @Transactional
    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Transactional
    @Override
    public void addCarInUser(long userId, long carId) {
        carDao.addCarInUser(userId, carId);
    }

    @Transactional
    @Override
    public void addAllCarsInAllUsers() {
        carDao.addAllCarsInAllUsers();
    }

    @Transactional
    @Override
    public User getUserByCarModelAndSeries(String model, int series){
        return carDao.getUserByCarModelAndSeries(model,series);
    };
}
