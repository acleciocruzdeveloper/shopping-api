package br.com.api.shopping.util;

import br.com.api.shopping.dto.ShopDto;
import br.com.api.shopping.model.Shop;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConverterUtil {

    private final ModelMapper modelMapper;

    public <D, T> T converter(D dto, Class<T> entidade) {
        return modelMapper.map(dto, entidade);
    }

    public ShopDto converter(Shop shop) {
        return modelMapper.map(shop, ShopDto.class);
    }
}
