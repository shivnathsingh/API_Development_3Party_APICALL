package ProductService.demo.contollers;

import ProductService.demo.dtos.CreateProductRequestDto;
import ProductService.demo.dtos.CreateProductResponseDto;
import ProductService.demo.dtos.FakeStoreCreateProductRequestDto;
import ProductService.demo.dtos.FakeStoreCreateProductResponseDto;
import ProductService.demo.models.Product;
import ProductService.demo.services.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // to make this class as controller to receive call from dispatcher
@RequestMapping("/products")   // To declare this as base url
@Validated                    // to enable validation for path variable

public class ProductController {


//    ProductService productService;

//    ProductController ( ProductService productService)
//    {
//        this.productService=productService;
//    }

    @Autowired
//    @Qualifier("productServiceDBImpl")
    private ProductService productService;


    // ==================== Fetch List of All Product
//    @GetMapping("")
//    public ResponseEntity<Page<CreateProductResponseDto>>  getAllProduct(@RequestParam("page") int page,@RequestParam("offset") int offset)
//    {
//        System.out.println("Fetching all products ");
//        Page<Product> products=productService.getAllProduct(page,offset);
//        Page<CreateProductResponseDto> responseDtos= (Page<CreateProductResponseDto>) products.stream().map(CreateProductResponseDto::toProductResponseDto).toList();
//        System.out.println("All products fetched");
//        return ResponseEntity.ok(responseDtos);
//
//    }

    @GetMapping
    public ResponseEntity<Page<CreateProductResponseDto>> getAllProduct(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Product> products = productService.getAllProduct(page, size);

        Page<CreateProductResponseDto> responseDtos =
                products.map(CreateProductResponseDto::toProductResponseDto);

        return ResponseEntity.ok(responseDtos);
    }


    //=============CREATE PRODUCT ==================
    @PostMapping ("")
    public ResponseEntity<CreateProductResponseDto> createProducts(@Valid @RequestBody CreateProductRequestDto productRequestDto)
    {
            CreateProductRequestDto.printProductRequestDto(productRequestDto);
            Product product= CreateProductRequestDto.toProduct(productRequestDto);
            Product savedProduct =productService.createProduct(product);
            CreateProductResponseDto productResponseDto=CreateProductResponseDto.toProductResponseDto(savedProduct);
            return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<CreateProductResponseDto> getSingleProduct(  @PathVariable("productId") @Positive Long productId)
    {
        Product product = productService.getSingleProduct(productId);
        CreateProductResponseDto responseDto=CreateProductResponseDto.toProductResponseDto(product);
        return ResponseEntity.ok(responseDto);

    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CreateProductResponseDto> getSingleProduct(@PathVariable("id") Long productId)
//    {
//        if(productId<=0){
//         return  ResponseEntity.badRequest().build();
//        }
//        System.out.println("Fetching Product with id "+productId);
//        CreateProductResponseDto responseDto=new CreateProductResponseDto();
//        Product product = productService.getSingleProduct(productId);
//        System.out.println("Product found with id "+productId);
//        if(product!=null)
//        return new ResponseEntity<>(responseDto.toProductResponseDto(product),HttpStatus.OK);
//
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }


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
