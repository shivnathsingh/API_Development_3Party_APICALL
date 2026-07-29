package ProductService.demo.services;

import ProductService.demo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ProductService {

    Product createProduct(Product product);
    Page<Product> getAllProduct(int page, int size);
    Product getSingleProduct(Long productId);
    Product replaceProduct(Long productId,Product product);


}

