package ProductService.demo.services;

import ProductService.demo.dtos.CreateProductRequestDto;
import ProductService.demo.dtos.CreateProductResponseDto;
import ProductService.demo.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product createProduct(Product product);
}
