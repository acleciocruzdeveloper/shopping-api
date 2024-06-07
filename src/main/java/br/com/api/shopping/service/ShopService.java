package br.com.api.shopping.service;

import br.com.api.shopping.dto.ShopDto;
import br.com.api.shopping.repositories.IShopRepository;
import br.com.api.shopping.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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



}
