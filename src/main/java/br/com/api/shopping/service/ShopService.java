package br.com.api.shopping.service;

import br.com.api.shopping.dto.ShopDto;
import br.com.api.shopping.model.Shop;
import br.com.api.shopping.repositories.IShopRepository;
import br.com.api.shopping.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopService {
    private final IShopRepository shopRepository;
    private final ConverterUtil util;


    public List<ShopDto> getAll() {
        return shopRepository.findAll()
                .stream()
                .map(util::converter)
                .toList();
    }

    public List<ShopDto> getByUser(String userIdentifier) {
        return shopRepository.findAllByUserIdentifier(userIdentifier)
                .stream()
                .map(util::converter)
                .toList();
    }

    public List<ShopDto> getByDate(ShopDto dto) {
        return shopRepository.findAllByDateGreaterThanEqual(
                        dto.getDate()
                ).stream()
                .map(util::converter)
                .toList();
    }

    public ShopDto findById(long productId) {
        return shopRepository.findById(productId)
                .map(util::converter)
                .orElseThrow(() -> new RuntimeException("product with id: " + productId + "not found"));

    }

    public ShopDto save(ShopDto dto) {
        dto.setTotal(dto.getItemsDto().stream()
                .map(itemDto -> itemDto.getPrice())
                .reduce((float) 0, Float::sum));

        Shop shop = util.converter(dto);
        shop.setDate(Instant.now());
        shop = shopRepository.save(shop);
        return util.converter(shop);
    }

}
