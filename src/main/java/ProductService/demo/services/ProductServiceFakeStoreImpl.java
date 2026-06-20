package ProductService.demo.services;

import ProductService.demo.dtos.FakeStoreCreateProductRequestDto;
import ProductService.demo.dtos.FakeStoreCreateProductResponseDto;
import ProductService.demo.models.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Service
//@Primary
@Service("fakestoreproductservice")
public class ProductServiceFakeStoreImpl implements ProductService{

    FakeStoreCreateProductRequestDto fk=new FakeStoreCreateProductRequestDto();
    FakeStoreCreateProductResponseDto fkr=new FakeStoreCreateProductResponseDto();
    RestTemplate restTemplate;
    ProductServiceFakeStoreImpl(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(Product product) {


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

    @Override
    public List<Product> getAllProduct() {
        //https://fakestoreapi.com/products
        String url="https://fakestoreapi.com/products";
        List<Product> products=new ArrayList<>();
        FakeStoreCreateProductResponseDto fk=new FakeStoreCreateProductResponseDto();
       FakeStoreCreateProductResponseDto responseDto[]= restTemplate.getForObject(url, FakeStoreCreateProductResponseDto[].class);
       if(responseDto==null)
       {
           throw new RuntimeException("List of product not found");
       }
       for(FakeStoreCreateProductResponseDto reponse:responseDto)
       {
           products.add(fk.toProduct(reponse));
       }
       return products;
       
    }

    @Override
    public Product getSingleProduct(Long productId) {

        String  url="https://fakestoreapi.com/products/{productId}";
//        FakeStoreCreateProductResponseDto response = restTemplate.getForObject(url,FakeStoreCreateProductResponseDto.class,productId);

        /*
        now using getForEntity to take more info from host system
         */
//
        ResponseEntity<FakeStoreCreateProductResponseDto> response=restTemplate.getForEntity(
                url,FakeStoreCreateProductResponseDto.class,productId);

//        ResponseEntity<FakeStoreCreateProductResponseDto> response=restTemplate.pu




        if(response.hasBody() && response.getStatusCode().equals(HttpStatusCode.valueOf(200)))
        {return fkr.toProduct(response.getBody());}
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
       /*
       url to configure
       entity
       return response entity
       responseType
        */
        String url="https://fakestoreapi.com/products/{id}";

        FakeStoreCreateProductRequestDto request=FakeStoreCreateProductRequestDto.toFakeStore(product);
        HttpEntity<?> entity=new HttpEntity<>(request);


        ResponseEntity<FakeStoreCreateProductResponseDto> response=restTemplate.exchange(url,
                HttpMethod.PUT,entity, FakeStoreCreateProductResponseDto.class,productId);

        if(response.hasBody() && response.getStatusCode().equals(HttpStatus.valueOf(200)))
        {
            return FakeStoreCreateProductResponseDto.toProduct(response.getBody());
        }
        return null;
    }


}
