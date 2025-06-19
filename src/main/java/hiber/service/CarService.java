package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService {
    List<Car> createListCars(Car... cars);
    List<Car> addCarInListCars(Car... cars);
    List<Car> listCars();
    void addCarInUser(long userId, long carId);
    void addAllCarsInAllUsers();
}
