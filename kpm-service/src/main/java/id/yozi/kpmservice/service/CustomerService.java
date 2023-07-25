package id.yozi.kpmservice.service;

import id.yozi.kpmservice.model.dto.CustomerRequest;
import id.yozi.kpmservice.model.dto.CustomerResponse;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public boolean validationNikCustomer(String nik);
    public ResponseTemplate<CustomerResponse> getCustomerByNik(String nik);

    public ResponseTemplate<CustomerResponse> addCustomer(CustomerRequest customerRequest);

    public ResponseTemplate<List<CustomerResponse>> getCustomers();

}
