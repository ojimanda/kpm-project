package id.yozi.kpmservice.service.Impl;


import id.yozi.kpmservice.model.User;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import id.yozi.kpmservice.model.dto.SubmissionRequest;
import id.yozi.kpmservice.model.dto.SubmissionResponse;
import id.yozi.kpmservice.repository.SubmitKPMRepository;
import id.yozi.kpmservice.service.CarService;
import id.yozi.kpmservice.service.CustomerService;
import id.yozi.kpmservice.service.SubmitKPMService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitKPMServiceImpl implements SubmitKPMService {

    @Autowired
    private CarService carService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SubmitKPMRepository submitKPMRepository;

    private HttpServletRequest servletRequest;

    private HttpServletResponse servletResponse;

    public SubmitKPMServiceImpl(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.servletRequest = servletRequest;
        this.servletResponse = servletResponse;
    }

    @Override
    public ResponseTemplate<List<SubmissionResponse>> getUserSubmissions(User user) {
        return null;
    }

    @Override
    public ResponseTemplate<SubmissionResponse> getSubmission(Long id) {
        return null;
    }

    @Override
    public ResponseTemplate<SubmissionResponse> addSubmission(SubmissionRequest submissionRequest) {
        return null;
    }

    @Override
    public ResponseTemplate<SubmissionResponse> updateSubmission(Long id) {
        return null;
    }
}
