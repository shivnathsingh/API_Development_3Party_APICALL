package ProductService.demo.services;

import ProductService.demo.dtos.CreateProductResponseDto;
import ProductService.demo.dtos.FakeStoreCreateProductRequestDto;
import ProductService.demo.dtos.FakeStoreCreateProductResponseDto;
import ProductService.demo.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Service
//@Primary
@Service("fakestoreproductservice")
public class ProductServiceFakeStoreImpl implements ProductService{

    RestTemplate restTemplate;
    ProductServiceFakeStoreImpl(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(Product product) {

        FakeStoreCreateProductRequestDto fk=new FakeStoreCreateProductRequestDto();
        FakeStoreCreateProductResponseDto fkr=new FakeStoreCreateProductResponseDto();
        FakeStoreCreateProductRequestDto request=fk.toFakeStore(product);
        System.out.println("request_title "+request.getTitle());
        System.out.println("request_Description  "+request.getDescription());
        System.out.println("request_price "+request.getPrice());



        FakeStoreCreateProductResponseDto response =restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreCreateProductResponseDto.class);

        System.out.println("response_title "+response.getTitle());
        System.out.println("request_Description  "+response.getDescription());
        System.out.println("request_price "+response.getPrice());
        System.out.println("response_id "+response.getId());

        Product product1=fkr.toProduct(response);
        return product1;
    }
}
