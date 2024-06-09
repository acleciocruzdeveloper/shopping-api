package br.com.api.shopping.service;

import br.com.api.shopping.dto.ItemDto;
import br.com.api.shopping.dto.ShopDto;
import br.com.api.shopping.model.Shop;
import br.com.api.shopping.repositories.IShopRepository;
import br.com.api.shopping.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopService {
    private final IShopRepository shopRepository;
    private final MapperUtil mapper;


    public List<ShopDto> getAll() {
        return shopRepository.findAll()
                .stream()
                .map(mapper::convertToDTO)
                .toList();
    }

    public List<ShopDto> getByUser(String userIdentifier) {
        return shopRepository.findAllByUserIdentifier(userIdentifier)
                .stream()
                .map(mapper::convertToDTO)
                .toList();
    }

    public List<ShopDto> getByDate(ShopDto dto) {
        return shopRepository.findAllByDateGreaterThanEqual(dto.getDate())
                .stream()
                .map(mapper::convertToDTO)
                .toList();
    }

    public ShopDto findById(long productId) {
        return shopRepository.findById(productId)
                .map(mapper::convertToDTO)
                .orElseThrow(() -> new RuntimeException("product with id: " + productId + "not found"));

    }

    public ShopDto save(ShopDto dto) {
        dto.setTotal(dto.getItems().stream()
                .map(ItemDto::getPrice)
                .reduce((float) 0, Float::sum));
        Shop shop = mapper.covertToEntity(dto);
        shop.setDate(new Date());
        Shop saved = shopRepository.save(shop);
        return mapper.convertToDTO(saved);
    }

}
