package gcu.msa.restpost.controller;

import gcu.msa.restpost.domain.Car;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Tag(name = "Car info", description = "차량정보출력")
public class CarController {

    @GetMapping("/car")
    public String getCarInfo(){
        return "Hello";
    }

    @PostMapping("/car")
    public ResponseEntity<String> setCarInfo(@RequestBody Car car){
        Car inCar = new Car();
        inCar.setId(car.getId());
        inCar.setBrand(car.getBrand());
        inCar.setName(car.getName());
        inCar.setPrice(car.getPrice());

        return ResponseEntity.ok(inCar.toString());
    }
}
