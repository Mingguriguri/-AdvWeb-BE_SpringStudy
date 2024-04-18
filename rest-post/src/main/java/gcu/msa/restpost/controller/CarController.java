package gcu.msa.restpost.controller;

import gcu.msa.restpost.domain.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
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
