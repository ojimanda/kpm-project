package id.yozi.kpmservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarResponse {

    private String name;

    private String brand;

    private String year;

    private BigInteger price;
}
