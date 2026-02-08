package ProductService.demo.contollers;

import ProductService.demo.dtos.CreateProductRequestDto;
import ProductService.demo.dtos.CreateProductResponseDto;
import ProductService.demo.models.Product;
import ProductService.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController // to make this class as controleer to recieve call from dispacher
@RequestMapping("/products")


public class ProductController {


    ProductService productService;



    ProductController (@Qualifier("fakestoreproductservice") ProductService productService)
    {
        this.productService=productService;
    }

    @GetMapping("")
    public String getAllProduct()
    {
        return "Listof all product ";
    }


    //=============CREATE PRODUCT ==================
    @PostMapping ("")
    public CreateProductResponseDto createProducts(@RequestBody CreateProductRequestDto createProductRequestDto)
    {
            CreateProductResponseDto c = new CreateProductResponseDto();
           Product product =createProductRequestDto.toProduct(createProductRequestDto);
           Product response =productService.createProduct(product);

           return c.toDto(response);
    }

    @GetMapping("{id}")
    public String singleProduct(@PathVariable("id") Long productID)
    {
        return "this is your Product ID "+productID;
    }


    @RequestMapping(name = "SHIV",value = "/product/own")
    public String ourMethod()
    {
        return "Our own method called ";
    }



}
