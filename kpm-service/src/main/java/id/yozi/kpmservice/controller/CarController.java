package id.yozi.kpmservice.controller;

import id.yozi.kpmservice.model.dto.CarRequest;
import id.yozi.kpmservice.model.dto.CarResponse;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import id.yozi.kpmservice.service.CarService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    private HttpServletRequest request;

    private HttpServletResponse response;

    @Autowired
    public CarController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseTemplate<List<CarResponse>> getAllCars() {
        return carService.getCars();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseTemplate<CarResponse> addCar(@RequestBody CarRequest carRequest) {
        return carService.createCar(carRequest);
    }

}
