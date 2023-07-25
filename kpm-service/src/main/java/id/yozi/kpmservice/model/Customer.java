package id.yozi.kpmservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "customer")
public class Customer {

    @Id
    @Column(name = "nik")
    private String NIK;
    private String fullName;
    private String age;
    private String gender;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<SubmitKPM> submissions;
}
