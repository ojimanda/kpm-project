package id.yozi.kpmservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    private String province;
    private String city;
    private String subDistrict;
    private String postalCode;

}
