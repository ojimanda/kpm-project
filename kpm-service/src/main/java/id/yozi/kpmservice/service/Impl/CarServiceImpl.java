package id.yozi.kpmservice.service.Impl;

import id.yozi.kpmservice.model.CarKPM;
import id.yozi.kpmservice.model.dto.CarRequest;
import id.yozi.kpmservice.model.dto.CarResponse;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import id.yozi.kpmservice.repository.CarRepository;
import id.yozi.kpmservice.service.CarService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
            response.setResponseCode(400);
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
            response.setResponseCode(400);
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
    public ResponseTemplate<CarResponse> getCarByName(String name) {
        ResponseTemplate<CarResponse> response = new ResponseTemplate<>();
        boolean isExist = carRepository.existsByName(name);
        if(isExist) {
            CarKPM carKPM = carRepository.findByName(name);

            response = ResponseTemplate.<CarResponse>builder()
                    .responseCode(200)
                    .responseMessage("OK")
                    .responseData(modelMapper.map(carKPM, CarResponse.class)).build();
        } else {
            response = ResponseTemplate.<CarResponse>builder()
                    .responseCode(400)
                    .responseMessage("Car with name "+ name+ " not found.").build();
        }
        return response;
    }

    @Override
    public ResponseTemplate<CarResponse> editCar(Long id, CarRequest carRequest) {

        ResponseTemplate<CarResponse> response = new ResponseTemplate<>();
        boolean isExist = carRepository.existsById(id);
        if(isExist) {
            CarKPM carKPM = carRepository.findById(id).orElseThrow();
            carKPM.setName(carRequest.getName());
            carKPM.setYear(carRequest.getYear());
            carKPM.setBrand(carRequest.getBrand());
            carKPM.setPrice(carRequest.getPrice());
            CarResponse carResponse = CarResponse.builder()
                    .name(carKPM.getName())
                    .brand(carKPM.getBrand())
                    .price(carKPM.getPrice())
                    .year(carKPM.getYear()).build();
            carRepository.save(carKPM);
            return ResponseTemplate.<CarResponse>builder()
                    .responseCode(200)
                    .responseMessage("OK")
                    .responseData(carResponse).build();
        } else {
            return ResponseTemplate.<CarResponse>builder()
                    .responseCode(400)
                    .responseMessage("Car doesn't exist")
                    .responseData(null).build();
        }
    }

    @Override
    public ResponseTemplate<CarResponse> deleteCar(String name) {
        boolean isExist = carRepository.existsByName(name);
        String message;
        int responseCode;
        if(isExist) {
            carRepository.deleteByName(name);
            message = "Car with name "+ name + " has been deleted.";
            responseCode = 200;
        } else {
            message = "Car with name "+ name + " not found.";
            responseCode = 400;
        }
        return ResponseTemplate.<CarResponse>builder()
                .responseCode(responseCode)
                .responseMessage(message)
                .responseData(null).build();
        }
}
