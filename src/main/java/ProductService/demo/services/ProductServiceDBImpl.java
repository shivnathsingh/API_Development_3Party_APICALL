package ProductService.demo.services;

import ProductService.demo.dtos.CreateProductResponseDto;
import ProductService.demo.models.Product;
import org.springframework.stereotype.Service;

@Service("dbproductservice")
public class ProductServiceDBImpl implements ProductService{

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
