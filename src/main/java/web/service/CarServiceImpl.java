package web.service;

import web.models.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car(1,"ss","red"));
        cars.add(new Car(2,"b8","blue"));
        cars.add(new Car(3,"ree33","white"));
        cars.add(new Car(4,"df1234","black"));
        cars.add(new Car(5,"mariquri","orange"));
    }

    @Override
    public List<Car> listCars(int number) {
        return cars.subList(0, number);
    }
    @Override
    public List<Car> getAllCars() {
        return cars;
    }
    @Override
    public List<Car> getCarsByCount(Integer count){
        if (count == null) { return cars; }
        return count > 0 && count <=5 ? listCars(count) : cars;
    }
}
