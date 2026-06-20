package ProductService.demo.contollers;

import ProductService.demo.dtos.CreateProductRequestDto;
import ProductService.demo.dtos.CreateProductResponseDto;
import ProductService.demo.dtos.FakeStoreCreateProductRequestDto;
import ProductService.demo.dtos.FakeStoreCreateProductResponseDto;
import ProductService.demo.models.Product;
import ProductService.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // to make this class as controleer to recieve call from dispacher
@RequestMapping("/products")


public class ProductController {


    ProductService productService;



    ProductController (@Qualifier("fakestoreproductservice") ProductService productService)
    {
        this.productService=productService;
    }


    // ==================== Fetch List of All Product
    @GetMapping("")
    public List<CreateProductResponseDto>  getAllProduct()
    {
        System.out.println("Fetching all products ");
        List<Product> products=productService.getAllProduct();
        List<CreateProductResponseDto> responseDtos=new ArrayList<>();
        CreateProductResponseDto responseDto=new CreateProductResponseDto();
        for(Product product:products)
        {
            responseDtos.add(responseDto.toProductResponseDto(product));
        }
        System.out.println("All products fetched");
        return responseDtos;

    }


    //=============CREATE PRODUCT ==================
    @PostMapping ("")
    public CreateProductResponseDto createProducts(@RequestBody CreateProductRequestDto createProductRequestDto)
    {
            CreateProductResponseDto c = new CreateProductResponseDto();
           Product product =createProductRequestDto.toProduct(createProductRequestDto);
//           Product response =productService.createProduct(product);

           return c.toProductResponseDto(product);
    }

    @GetMapping("{productId}/{catId}")
    public Product singleProduct(@PathVariable("productId") Long productId,
                                 @PathVariable("catId") Long categoryId)
    {

        Product product=new Product();
        product.setTitle("Iphone");
        product.setId(productId);

        return  product;


    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateProductResponseDto> getSingleProduct(@PathVariable("id") Long productId)
    {
        if(productId<=0){
         return  ResponseEntity.badRequest().build();
        }
        System.out.println("Fetching Product with id "+productId);
        CreateProductResponseDto responseDto=new CreateProductResponseDto();
        Product product = productService.getSingleProduct(productId);
        System.out.println("Product found with id "+productId);
        if(product!=null)
        return new ResponseEntity<>(responseDto.toProductResponseDto(product),HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(name = "SHIV",value = "/product/own")
    public String ourMethod()
    {
        return "Our own method called ";
    }



    // ====================== PUT API ========================

    @PutMapping("/{id}")
    public ResponseEntity<FakeStoreCreateProductResponseDto> replaceProduct(
            @PathVariable("id") Long productId, @RequestBody CreateProductRequestDto input
            )
    {
        if(productId<=0 || input ==null)
        {
            return ResponseEntity.badRequest().build();
        }
        Product product=productService.replaceProduct(productId,input.toProduct(input));
        if(product ==null)
            return ResponseEntity.badRequest().build();

        FakeStoreCreateProductResponseDto response=FakeStoreCreateProductResponseDto.toFakeStore(product);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

}
