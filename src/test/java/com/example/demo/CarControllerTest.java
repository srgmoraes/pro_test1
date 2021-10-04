package com.example.demo;

import com.example.demo.controller.CarController;
import com.example.demo.model.Car;
import com.example.demo.service.CarBusinessService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarBusinessService carBusinessService;

    @Test
    public void car_basic() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/car").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Audi\",\"year\":120,\"color\":\"red\"}"))
                .andReturn();

    }

    @Test
    public void car_basic_with_space() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/car").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":    1,\"name\":\"Audi\",\"year\":120,\"color\":\"red\"}"))
                .andReturn();

    }

    @Test
    public void car_basic_without_color() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/car").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Audi\",\"year\":120}"))
                .andReturn();

    }


    @Test
    public void car_hardcode() throws Exception {

        Mockito.when(carBusinessService.getCarHardcode()).thenReturn(new Car(2, "VW", 120, "red"));

        RequestBuilder request = MockMvcRequestBuilders.get("/car-hardcode").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"name\":\"VW\",\"year\":120,\"color\":\"red\"}"))
                .andReturn();

    }

    @Test
    public void car_all_from_database() throws Exception {

        Mockito.when(carBusinessService.getAllCars()).thenReturn(List.of(new Car(2, "VW", 120, "red"), new Car(3, "VW", 121, "black")));

        RequestBuilder request = MockMvcRequestBuilders.get("/car-all-from-database").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":2,\"name\":\"VW\",\"year\":120,\"color\":\"red\"},{\"id\":3,\"name\":\"VW\",\"year\":121,\"color\":\"black\"}]"))
                .andReturn();

    }

//    @Test
//    public void car_save() throws Exception {
//
//        RequestBuilder request = MockMvcRequestBuilders.post("/car")
//                .accept(MediaType.APPLICATION_JSON).content("{\"name\":\"Audi\",\"year\":120,\"color\":\"red\"}")
//                .contentType(MediaType.APPLICATION_JSON);
//
//       mockMvc.perform(request)
//                .andExpect(status().isCreated());
//
//    }



}
