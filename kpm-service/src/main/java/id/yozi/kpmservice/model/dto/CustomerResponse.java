package id.yozi.kpmservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private String fullName;
    private String dob;
    private String gender;
    private Address address;

}
