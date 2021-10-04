package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarBusinessService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    public Car getCarHardcode() {
        return new Car(1, "Audi", 120, "red");
    }

    public Car getSave(Car car) {
        return this.carRepository.save(car);
    }

}
