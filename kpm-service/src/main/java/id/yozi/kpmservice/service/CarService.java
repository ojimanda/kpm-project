package id.yozi.kpmservice.service;

import id.yozi.kpmservice.model.dto.CarRequest;
import id.yozi.kpmservice.model.dto.CarResponse;
import id.yozi.kpmservice.model.dto.ResponseTemplate;

import java.util.List;

public interface CarService {

    public ResponseTemplate<List<CarResponse>> getCars();
    public ResponseTemplate<CarResponse> createCar(CarRequest carRequest);
    public ResponseTemplate<CarResponse> deleteCar(String name);
}
