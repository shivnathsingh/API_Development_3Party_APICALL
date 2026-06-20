package ProductService.demo.services;

import ProductService.demo.dtos.CreateProductRequestDto;
import ProductService.demo.dtos.CreateProductResponseDto;
import ProductService.demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProduct();
    Product getSingleProduct(Long productId);
    Product replaceProduct(Long productId,Product product);


}

