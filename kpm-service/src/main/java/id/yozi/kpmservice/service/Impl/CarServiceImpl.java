package id.yozi.kpmservice.service.Impl;

import id.yozi.kpmservice.model.CarKPM;
import id.yozi.kpmservice.model.dto.CarRequest;
import id.yozi.kpmservice.model.dto.CarResponse;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import id.yozi.kpmservice.repository.CarRepository;
import id.yozi.kpmservice.service.CarService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseTemplate<List<CarResponse>> getCars() {
        ResponseTemplate<List<CarResponse>> response = new ResponseTemplate<>();

        List<CarKPM> carKPMS = carRepository.findAll();
        if(carKPMS.size() == 0) {
            response.setResponseCode(401);
            response.setResponseMessage("No Data");
        } else {
            List<CarResponse> carResponses = modelMapper.map(carKPMS, new TypeToken<List<CarResponse>>(){}.getType());
            response.setResponseCode(200);
            response.setResponseMessage("OK");
            response.setResponseData(carResponses);
        }
        return response;
    }

    @Override
    public ResponseTemplate<CarResponse> createCar(CarRequest carRequest) {
        ResponseTemplate<CarResponse> response = new ResponseTemplate<>();
        boolean carKPM = carRepository.existsByName(carRequest.getName());

        if(carKPM) {
            response.setResponseCode(401);
            response.setResponseMessage("Car has been exist");
            response.setResponseData(new CarResponse());
        } else {
            CarKPM request = new CarKPM();
            request.setBrand(carRequest.getBrand());
            request.setName(carRequest.getName());
            request.setYear(carRequest.getYear());
            request.setPrice(carRequest.getPrice());
            CarResponse carResponse = CarResponse.builder()
                    .name(carRequest.getName())
                    .brand(carRequest.getBrand())
                    .year(carRequest.getYear())
                    .price(carRequest.getPrice())
                    .build();
            response.setResponseCode(201);
            response.setResponseMessage("OK");
            response.setResponseData(carResponse);
            carRepository.save(request);
        }
        return response;
    }

    @Override
    public ResponseTemplate<CarResponse> deleteCar(String name) {
        return null;
    }
}
