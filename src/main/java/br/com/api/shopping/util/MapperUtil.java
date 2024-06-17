package br.com.api.shopping.util;

import br.com.api.shopping.dto.ItemDto;
import br.com.api.shopping.dto.ShopDto;
import br.com.api.shopping.model.Item;
import br.com.api.shopping.model.Shop;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperUtil {
    private final ModelMapper modelMapper;

    public ShopDto convertToDTO(Shop shop) {
        ShopDto shopDto = modelMapper.map(shop, ShopDto.class);

        shopDto.setItems(shop.getItems()
                .stream()
                .map(item -> modelMapper.map(item, ItemDto.class))
                .toList());
        return shopDto;
    }

    public Shop covertToEntity(ShopDto shopDto) {
        Shop shop = modelMapper.map(shopDto, Shop.class);

        shop.setItems(shopDto.getItems().stream()
                .map(itemDto -> modelMapper.map(itemDto, Item.class))
                .toList());

        return shop;
    }
}
