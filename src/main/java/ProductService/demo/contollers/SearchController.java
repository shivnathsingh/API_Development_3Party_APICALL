package ProductService.demo.contollers;

import ProductService.demo.dtos.SearchRequestDto;
import ProductService.demo.models.Product;
import ProductService.demo.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")

public class SearchController {


    @Autowired
   private ISearchService iSearchService;
    @PostMapping()
    public Page<Product> getAllProduct(@RequestBody SearchRequestDto searchRequestDto)
    {

        return iSearchService.searchProduct(searchRequestDto.getQuery(),searchRequestDto.getPageSize(),searchRequestDto.getPageNo(),searchRequestDto.getLst());

    }

}
