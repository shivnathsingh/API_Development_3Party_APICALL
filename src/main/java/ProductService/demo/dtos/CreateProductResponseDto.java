package ProductService.demo.dtos;

import ProductService.demo.models.Category;
import ProductService.demo.models.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class CreateProductResponseDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static CreateProductResponseDto toProductResponseDto(Product product)
    {
        System.out.println("Product to ProductResponseDto Mapping service called");
        CreateProductResponseDto createProductResponseDto=new CreateProductResponseDto();
        createProductResponseDto.setId(product.getId());
        createProductResponseDto.setTitle(product.getTitle());
        createProductResponseDto.setDescription(product.getDescription());
        createProductResponseDto.setPrice(product.getPrice());
        createProductResponseDto.setImageUrl(product.getImageUrl());
        createProductResponseDto.setCategory(product.getCategory());
        System.out.println("ProductResponseDto created with below details ");
        CreateProductResponseDto.printProductResponseDto(createProductResponseDto);

        return createProductResponseDto;
    }

    public static void printProductResponseDto(CreateProductResponseDto responseDto)
    {
        if(responseDto==null)
        {
            System.out.println("In printProductResponseDto Method responseDto is passed as null ");
            return ;
        }
        System.out.println("responseDtoId "+responseDto.getId()
                +" responseDtoTitle "+responseDto.getTitle()
                +" responseDtoDescription "+responseDto.getDescription()
                +" responseDtoPrice "+responseDto.getPrice()
                +" responseDtoImageUrl "+responseDto.getImageUrl()
                +" responseDtoCategoryID "+responseDto.getCategory().getId()
                +" responseDtoCategoryDescription "+responseDto.getCategory().getDescription()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
