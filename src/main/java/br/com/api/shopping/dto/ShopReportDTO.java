package br.com.api.shopping.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopReportDTO {
    private Integer count;
    private Double total;
    private Double mean;
}
