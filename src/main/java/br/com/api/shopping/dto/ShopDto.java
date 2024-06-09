package br.com.api.shopping.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopDto {
    @NotBlank(message = "user identifier field cannot blank")
    private String userIdentifier;
    @NotNull
    private Float total;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date date;
    @NotNull
    private List<ItemDto> items;
}
