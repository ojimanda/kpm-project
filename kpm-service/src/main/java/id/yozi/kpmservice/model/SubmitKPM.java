package id.yozi.kpmservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Data
@Entity(name = "submit_kpm")
public class SubmitKPM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_nik")
    @JsonIgnore
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CarKPM car;
    private BigInteger salary;
    private int tenor;
    private double downPayment;
    private double credit;
    private boolean isApproved = false;


}
