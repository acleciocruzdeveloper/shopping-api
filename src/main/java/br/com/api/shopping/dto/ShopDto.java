package br.com.api.shopping.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopDto {
    @NotBlank(message = "user identifier field cannot blank")
    private String userIdentifier;
    @NotNull
    private Float total;
    @NotNull
    private Instant date;
    @NotNull
    private List<ItemDto> itemsDto;
}
