package br.com.api.shopping.controller;

import br.com.api.shopping.dto.ShopDto;
import br.com.api.shopping.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/shopping")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ShopDto>> getShops() {
        return ResponseEntity.ok().body(shopService.getAll());
    }

    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ShopDto>> getShops(@PathVariable String userIdentifier) {
        return ResponseEntity.ok().body(shopService.getByUser(userIdentifier));
    }
}
