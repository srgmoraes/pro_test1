package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarBusinessService carBusinessService;

    @GetMapping("/car")
    public Car getCar() {
        return new Car(1, "Audi", 120, "red");
    }

    @GetMapping("/car-hardcode")
    public Car getCarHardcode() {
        return this.carBusinessService.getCarHardcode();
    }

    @GetMapping("/car-all-from-database")
    public List<Car> getAllCars() {
        return this.carBusinessService.getAllCars();
    }

    @PostMapping("/car")
    public Car getCarSave(@RequestBody Car car) {
        return this.getCarSave(car);
    }

}
