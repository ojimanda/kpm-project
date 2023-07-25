package id.yozi.kpmservice.model.dto;

import id.yozi.kpmservice.model.CarKPM;
import id.yozi.kpmservice.model.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubmissionResponse {

    private Customer customer;
    private CarKPM car;
    private int tenor;
    private double downPayment;
    private double credit;
}
