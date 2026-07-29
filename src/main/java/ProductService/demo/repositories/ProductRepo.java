package ProductService.demo.repositories;

import ProductService.demo.models.Product;
;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    Product save(Product product);
    Optional<Product> findById(Long productId);

    @Override
    Page<Product> findAll(Pageable pageable);

//    List<Product> findByNameEquals(String query);

Page<Product> findByTitleEquals(String query,Pageable pageable);
}
