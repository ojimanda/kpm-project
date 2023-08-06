package id.yozi.kpmservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.yozi.kpmservice.model.dto.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity(name = "customer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "nik")
    private String NIK;
    private String fullName;
    private String dob;
    private String gender;
    private String province;
    private String city;
    private String subDistrict;
    private String postalCode;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<SubmitKPM> submissions;
}
