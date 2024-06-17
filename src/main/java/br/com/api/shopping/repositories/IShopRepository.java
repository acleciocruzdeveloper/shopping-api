package br.com.api.shopping.repositories;

import br.com.api.shopping.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface IShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findAllByUserIdentifier(String userIdentifier);
    List<Shop> findAllByTotalGreaterThan(Float total);
    List<Shop> findAllByDateGreaterThanEqual(LocalDateTime date);

}
