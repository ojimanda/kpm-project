package id.yozi.kpmservice.service.Impl;


import id.yozi.kpmservice.model.User;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import id.yozi.kpmservice.model.dto.SubmissionResponse;
import id.yozi.kpmservice.repository.SubmitKPMRepository;
import id.yozi.kpmservice.service.CarService;
import id.yozi.kpmservice.service.CustomerService;
import id.yozi.kpmservice.service.SubmitKPMService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class SubmitKPMServiceImpl implements SubmitKPMService {

    @Autowired
    private CarService carService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SubmitKPMRepository submitKPMRepository;

    @Override
    public ResponseTemplate<List<SubmissionResponse>> getUserSubmissions(User user) {
        return null;
    }

    @Override
    public ResponseTemplate<SubmissionResponse> getSubmission(Long id) {
        return null;
    }
}
