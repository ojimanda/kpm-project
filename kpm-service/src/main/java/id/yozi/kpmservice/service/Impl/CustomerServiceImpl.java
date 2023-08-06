package id.yozi.kpmservice.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.jconsole.JConsoleContext;
import id.yozi.kpmservice.model.Customer;
import id.yozi.kpmservice.model.dto.*;
import id.yozi.kpmservice.repository.CustomerRepository;
import id.yozi.kpmservice.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    private HttpServletRequest servletRequest;

    private HttpServletResponse servletResponse;

    ModelMapper mapper = new ModelMapper();

    public CustomerServiceImpl(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.servletRequest = servletRequest;
        this.servletResponse = servletResponse;
    }

    @Override
    public boolean validationNikCustomer(String nik) throws IOException {
        DetailNIKResponse response = getDetailCustomer(nik);
        return response.getStatus().equals("success");
    }

    @Override
    public ResponseTemplate<DetailNIK> getCustomerByNik(String nik) throws IOException {
        DetailNIKResponse response = getDetailCustomer(nik);
        if(response.getStatus().equals("success")) {
            return ResponseTemplate.<DetailNIK>builder()
                    .responseCode(200)
                    .responseMessage("OK")
                    .responseData(response.getData()).build();
        } else {
            return ResponseTemplate.<DetailNIK>builder()
                    .responseCode(400)
                    .responseMessage(response.getPesan())
                    .build();
        }
    }

    @Override
    public ResponseTemplate<CustomerResponse> addCustomer(CustomerRequest customerRequest) throws IOException {
        DetailNIKResponse response = getDetailCustomer(customerRequest.getNik());
        ResponseTemplate<CustomerResponse> responseTemplate;
        if(response.getStatus().equals("success")) {
            DetailNIK detailCustomer = response.getData();
            Customer customer = Customer.builder()
                    .NIK(customerRequest.getNik())
                    .fullName(customerRequest.getFullName())
                    .dob(detailCustomer.getLahir())
                    .gender(detailCustomer.getKelamin())
                    .city(detailCustomer.getKotakab())
                    .province(detailCustomer.getProvinsi())
                    .subDistrict(detailCustomer.getKecamatan())
                    .postalCode(detailCustomer.getTambahan().getKodepos()).build();
            CustomerResponse customerResponse = mapper.map(customerRequest, CustomerResponse.class);
            responseTemplate = ResponseTemplate.<CustomerResponse>builder()
                    .responseCode(201)
                    .responseMessage("OK")
                    .responseData(customerResponse).build();
            customerRepository.save(customer);
        } else {
            responseTemplate = ResponseTemplate.<CustomerResponse>builder()
                    .responseCode(400)
                    .responseMessage(response.getPesan()).build();
        }

        return responseTemplate;
    }

    @Override
    public ResponseTemplate<List<CustomerResponse>> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponses = mapper.map(customers, new TypeToken<List<CustomerResponse>>(){}.getType());
        return ResponseTemplate.<List<CustomerResponse>>builder()
                .responseCode(200)
                .responseMessage("OK")
                .responseData(customerResponses).build();
    }

    private DetailNIKResponse getDetailCustomer(String nik) throws IOException {
        String stringUrl = "http://localhost:7777/generate-nik/" + nik;
        ObjectMapper mapper = new ObjectMapper();
        if (nik.length() < 16) {
            DetailNIKResponse response = new DetailNIKResponse();
            response.setStatus("Error");
            response.setPesan("NIK must be 16 character");
            return response;
        }

        URL url = new URL(stringUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try {
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());
                BufferedReader bf = new BufferedReader(isrObj);
                return mapper.readValue(bf.readLine(), DetailNIKResponse.class);
            } else {
                return DetailNIKResponse.builder().status("Error").pesan("NIK Not Valid").build();
            }
        } catch (ConnectException err) {
            return DetailNIKResponse.builder().status("Error").pesan(err.getMessage()).build();
        }
    }
}
