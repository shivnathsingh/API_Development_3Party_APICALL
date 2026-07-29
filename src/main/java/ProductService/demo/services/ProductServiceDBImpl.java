package ProductService.demo.services;

import ProductService.demo.models.Category;
import ProductService.demo.models.Product;
import ProductService.demo.repositories.CategoryRepo;
import ProductService.demo.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Primary
public class ProductServiceDBImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;


    @Override
    public Product createProduct(Product product) {

        System.out.println("Db Storage Create Product Service called");

        /*
        1. before creating just check if product with same id exist
        2. if exist throw exception
        3. if not create and return project
         */

        Optional<Product> productOptional = productRepo.findById(product.getId());
        if(productOptional.isPresent())
        {
            throw new RuntimeException("Product with id "+product.getId()+" already exist");
        }

        Long categoryId=product.getCategory().getId();
        Optional<Category> category=categoryRepo.findById(categoryId);
        if(category.isPresent())
        {
            product.setCategory(category.get());
        }else {
//            Category newCategory=new Category();
//            newCategory.setId(product.getCategory().getId());
//            newCategory.setDescription(product.getCategory().getDescription());
//            newCategory.setCreatedBy(product.getTitle());
//            categoryRepo.save(newCategory);
        }
        Category savedCategory=categoryRepo.findById(categoryId).orElseGet(()->

                {
                    Category newCategory=new Category();
                    newCategory.setId(product.getCategory().getId());
                    newCategory.setDescription(product.getCategory().getDescription());
                    return categoryRepo.save(newCategory);
                }
                );
        product.setCategory(savedCategory);
        Product savedProduct=productRepo.save(product);
        System.out.println("Product saved in repo");
        return  savedProduct;
    }

    @Override
    public Page<Product> getAllProduct(int page, int size) {

        System.out.println("Db Storage List of  Product Service called");

        Pageable pageable= PageRequest.of(page,size);
        Page<Product> products=productRepo.findAll(pageable);
        if(products.isEmpty())
        {
            throw new RuntimeException("No Product available in Inventory");

        }
        return products;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        System.out.println("Db Storage getSingleProduct  Service called");
        Optional<Product> productOptional = productRepo.findById(productId);
        if(productOptional.isEmpty())
        {
            throw new RuntimeException("Product with id "+productId+" does not  exist");
        }
        return productOptional.get();
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        System.out.println("Db Storage replaceProduct  Service called");

        /*
        1. check product exist or not
        2. if not throw exception
        3. if yes update in db
        4. return updated product
         */


        Optional<Product> optionalProduct = productRepo.findById(productId);
        if(optionalProduct.isEmpty()) {
            throw new RuntimeException("Product with id "+productId+" does not exist");
        }
       return productRepo.save(product);

    }
}
