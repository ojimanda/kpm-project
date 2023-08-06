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
public class DetailNIK {

        @JsonProperty("nik")
        private String nik;
        @JsonProperty("kelamin")
        private String kelamin;
        @JsonProperty("lahir")
        private String lahir;
        @JsonProperty("provinsi")
        private String provinsi;
        @JsonProperty("kotakab")
        private String kotakab;
        @JsonProperty("kecamatan")
        private String kecamatan;
        @JsonProperty("uniqcode")
        private String uniqcode;
        @JsonProperty("tambahan")
        private Tambahan tambahan;

        @Data
        public static class Tambahan {
            @JsonProperty("kodepos")
            private String kodepos;
            @JsonProperty("pasaran")
            private String pasaran;
            @JsonProperty("usia")
            private String usia;
            @JsonProperty("ultah")
            private String ultah;
            @JsonProperty("zodiak")
            private String zodiak;
        }
}
