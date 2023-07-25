package id.yozi.kpmservice.service.Impl;

import id.yozi.kpmservice.model.dto.CustomerRequest;
import id.yozi.kpmservice.model.dto.CustomerResponse;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import id.yozi.kpmservice.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public boolean validationNikCustomer(String nik) {
        return false;
    }

    @Override
    public ResponseTemplate<CustomerResponse> getCustomerByNik(String nik) {
        return null;
    }

    @Override
    public ResponseTemplate<CustomerResponse> addCustomer(CustomerRequest customerRequest) {
        return null;
    }

    @Override
    public ResponseTemplate<List<CustomerResponse>> getCustomers() {
        return null;
    }
}
