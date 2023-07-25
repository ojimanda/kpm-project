package id.yozi.kpmservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate<T> {

    private Integer responseCode;

    private String responseMessage;

    private T responseData;
}
