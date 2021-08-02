package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;


@Controller
public class CarController {
    
    private final CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/cars")
    public String printCar(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null || count > 5) {
            model.addAttribute("message", carDAO.getCars());
        } else if (count < 0) {
                model.addAttribute("message", "NEGATIVE MEANING");
        } else {
            model.addAttribute("message", carDAO.getSubListCar(count));
        }
        return "car";
    }

}
