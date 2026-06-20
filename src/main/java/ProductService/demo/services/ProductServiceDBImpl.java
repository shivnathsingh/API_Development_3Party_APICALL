package ProductService.demo.services;

import ProductService.demo.dtos.CreateProductResponseDto;
import ProductService.demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbproductservice")
public class ProductServiceDBImpl implements ProductService{

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }
}
