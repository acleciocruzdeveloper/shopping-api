package br.com.api.shopping.core;

import br.com.api.shopping.dto.ItemDto;
import br.com.api.shopping.dto.ShopDto;
import br.com.api.shopping.model.Item;
import br.com.api.shopping.model.Shop;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Shop, ShopDto>() {
            @Override
            protected void configure() {
                map().setUserIdentifier(source.getUserIdentifier());
                map().setDate(source.getDate());
                map().setTotal(source.getTotal());
            }
        });

        modelMapper.addMappings(new PropertyMap<Item, ItemDto>() {
            @Override
            protected void configure() {
                map().setProductIdentifier(source.getProductIdentifier());
                map().setPrice(source.getPrice());
            }
        });
        return modelMapper;
    }

}
