package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private final List<Car> listCar = getListCar();

    @GetMapping("/car")
    public String printCar(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null || count > 5) {
            model.addAttribute("message", listCar);
        } else if (count < 0) {
                model.addAttribute("message", "NEGATIVE MEANING");
        } else {
            model.addAttribute("message", getSubListCar(count));
        }
        return "car";
    }

    private List<Car> getListCar() {
        List<Car> list = new ArrayList<>();
        list.add(new Car("BMW", "5", 1990));
        list.add(new Car("AUDI", "Q5", 2016));
        list.add(new Car("VOLVO", "XC90", 2020));
        list.add(new Car("VW", "Polo", 1993));
        list.add(new Car("SKODA", "Octavia", 2015));
        return list;
    }

    private List<Car> getSubListCar(int quantity) {
        return listCar.subList(0, quantity);
    }
}
