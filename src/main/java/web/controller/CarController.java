package web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private final CarService carService;

    CarController(CarService carService) {
        this.carService = carService;
    }

//    @GetMapping(value = "/cars")
//    public String showCars(@RequestParam(name = "count", required = false) Integer count, Model model) {
//        if(count != null && count > 0 && count <= 5) {
//            model.addAttribute("cars", carService.listCars(count));
//        } else {
//            model.addAttribute("cars",carService.getAllCars());
//        }
//        return "cars";
//    }
    // В CarController
    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(name = "count", required = false) Integer count, Model model) {
        model.addAttribute("cars", carService.getCarsByCount(count));
        return "cars";
    }
}
