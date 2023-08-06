package id.yozi.kpmservice.controller;

import id.yozi.kpmservice.service.CustomerService;
import id.yozi.kpmservice.service.SubmitKPMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8083", maxAge = 3600)
@RestController
@RequestMapping("/submit")
public class SubmitKPMController {

    @Autowired
    private SubmitKPMService submitKPMService;

    @Autowired
    private CustomerService customerService;

}
