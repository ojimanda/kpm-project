package id.yozi.kpmservice.service;

import id.yozi.kpmservice.model.dto.CustomerRequest;
import id.yozi.kpmservice.model.dto.CustomerResponse;
import id.yozi.kpmservice.model.dto.DetailNIK;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Service
public interface CustomerService {

    public boolean validationNikCustomer(String nik) throws IOException;
    public ResponseTemplate<DetailNIK> getCustomerByNik(String nik) throws IOException;

    public ResponseTemplate<CustomerResponse> addCustomer(CustomerRequest customerRequest) throws IOException;

    public ResponseTemplate<List<CustomerResponse>> getCustomers();

}
