package ProductService.demo.services;

import ProductService.demo.models.Product;
import ProductService.demo.models.SortParame;
import org.springframework.data.domain.Page;


import java.util.List;

public interface ISearchService {

    Page<Product> searchProduct(String query, Integer pageSize, Integer pageNo, List<SortParame> sortParames);

}
