package com.example.demo;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void test_find_all() {
        List<Car> cars = carRepository.findAll();
        Assertions.assertEquals(3, cars.size());

    }

}
