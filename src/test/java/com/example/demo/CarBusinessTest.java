package com.example.demo;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarBusinessService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CarBusinessTest {

    @InjectMocks
    private CarBusinessService carBusinessService;

    @Mock
    private CarRepository carRepository;

    @Test
    public void car_all_from_database() {

        Mockito.when(carRepository.findAll()).thenReturn(List.of(new Car(2, "VW", 120, "red"), new Car(3, "VW", 121, "black")));

        List<Car> cars = carBusinessService.getAllCars();

        Assertions.assertEquals(2, cars.get(0).getId());

    }

}
