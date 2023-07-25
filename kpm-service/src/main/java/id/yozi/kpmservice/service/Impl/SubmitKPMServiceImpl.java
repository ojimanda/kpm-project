package id.yozi.kpmservice.service.Impl;

import id.yozi.kpmservice.repository.CarRepository;
import id.yozi.kpmservice.repository.CustomerRepository;
import id.yozi.kpmservice.repository.SubmitKPMRepository;
import id.yozi.kpmservice.service.SubmitKPMService;
import org.springframework.beans.factory.annotation.Autowired;


public class SubmitKPMServiceImpl implements SubmitKPMService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SubmitKPMRepository submitKPMRepository;

}
