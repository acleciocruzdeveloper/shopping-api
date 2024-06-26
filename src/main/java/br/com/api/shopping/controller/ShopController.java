package br.com.api.shopping.controller;

import br.com.api.shopping.dto.ShopDto;
import br.com.api.shopping.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/shopping/shop_by_date")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ShopDto>> getShops(@RequestBody ShopDto dto) {
        return ResponseEntity.ok().body(shopService.getByDate(dto));
    }

    @GetMapping("/shopping/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ShopDto> getById(@PathVariable long id) {
        return ResponseEntity.ok().body(shopService.findById(id));
    }

    @PostMapping("/shopping")
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDto create(@RequestBody ShopDto dto) {
        return shopService.save(dto);
    }

//    @GetMapping("/shopping/report/search")
//    public List<ShopDto> getShopbyFilter(
//            @RequestParam(name = "dataInicio") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataInicio,
//            @RequestParam(name = "dataFim", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataFim,
//            @RequestParam(name = "valorMinimo", required = false) Float valorMinimo) {
//        return shopService.getShopByFilter(dataInicio, dataFim, valorMinimo);
//    }

}
