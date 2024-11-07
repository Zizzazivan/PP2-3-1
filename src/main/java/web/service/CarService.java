package web.service;

import web.models.Car;

import java.util.List;

public interface CarService {


    List<Car> listCars(int number);
    List<Car> getAllCars();
}
