package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", "5", 1990));
        cars.add(new Car("AUDI", "Q5", 2016));
        cars.add(new Car("VOLVO", "XC90", 2020));
        cars.add(new Car("VW", "Polo", 1993));
        cars.add(new Car("SKODA", "Octavia", 2015));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getSubListCar(int quantity) {
        return cars.subList(0, quantity);
    }
}
