package br.com.api.shopping.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = -5453732339782816953L;

    private String productIdentifier;
    private Float price;
}
