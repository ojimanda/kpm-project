package id.yozi.kpmservice.controller;

import id.yozi.kpmservice.model.dto.DetailNIK;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import id.yozi.kpmservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:8083", maxAge = 3600)
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/validation/{nik}")
    @ResponseStatus(HttpStatus.OK)
    public boolean validationNik(@PathVariable("nik") String nik) throws IOException {
        return customerService.validationNikCustomer(nik);
    }

    @GetMapping("/detail/{nik}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseTemplate<DetailNIK> getCustomerDetail(@PathVariable("nik") String nik) throws IOException {
        return customerService.getCustomerByNik(nik);
    }
}
