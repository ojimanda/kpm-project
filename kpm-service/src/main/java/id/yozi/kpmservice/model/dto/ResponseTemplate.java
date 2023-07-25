package id.yozi.kpmservice.model.dto;

import lombok.Data;

@Data
public class ResponseTemplate<T> {

    private Integer responseCode;

    private String responseMessage;

    private T responseData;
}
