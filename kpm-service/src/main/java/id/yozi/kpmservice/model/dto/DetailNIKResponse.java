package id.yozi.kpmservice.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"rel", "href", "method"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailNIKResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("pesan")
    private String pesan;
    @JsonProperty("data")
    private DetailNIK data;

}
