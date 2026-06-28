package ProductService.demo.dtos;

import ProductService.demo.models.Category;
import ProductService.demo.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import tools.jackson.databind.ser.jdk.JDKKeySerializers;

@Data


public class CreateProductRequestDto {


    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 3,max = 10,message = "Title len bw 3 to 10 character")
    private String title;
    @NotBlank
    @Size(min = 3,max = 10,message = "Desciption len bw 3 to 50 character")
    private String description;
    @NonNull
    @Positive
    private double price;
    private String imageUrl;
    @NotBlank
    private Category category;

    // Mapper method to map Product Request DTO to Product

    public static Product toProduct(CreateProductRequestDto createProductRequestDto)
    {
        Product product= new Product();
        System.out.println("ProductRequestDto to Product Mapping method called ");
        product.setId(createProductRequestDto.getId());
        product.setTitle(createProductRequestDto.getTitle());
        product.setDescription(createProductRequestDto.getDescription());
        product.setPrice(createProductRequestDto.getPrice());
        product.setImageUrl(createProductRequestDto.getImageUrl());
        Category category1=new Category();
        category1.setId(createProductRequestDto.getCategory().getId());
        category1.setDescription(createProductRequestDto.getCategory().getDescription());
        product.setCategory(category1);

        System.out.println("In ProductRequestDto to Product Mapping Product created with below details");
        Product.printProduct(product);

        return product;
    }

    public static void printProductRequestDto(CreateProductRequestDto productRequestDto)
    {
        if(productRequestDto==null)
        {
            System.out.println("In printProductRequestDto Method productRequestDto is passed as null ");
            return ;
        }
        System.out.println("productRequestDtoId "+productRequestDto.getId()
                +" productRequestDtoTitle "+productRequestDto.getTitle()
                +" productRequestDtoDescription "+productRequestDto.getDescription()
                +" productRequestDtoPrice "+productRequestDto.getPrice()
                +" productRequestDtoImageUrl "+productRequestDto.getImageUrl()
                +" productRequestDtoCategoryID "+productRequestDto.getCategory().getId()
                +" productRequestDtoCategoryDescription "+productRequestDto.getCategory().getDescription()
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
