package id.yozi.kpmservice.model.dto;


import lombok.Data;

@Data
public class CustomerRequest {

    private String nik;
    private String fullName;
    private String dob;
    private String gender;
    private Address address;

}
