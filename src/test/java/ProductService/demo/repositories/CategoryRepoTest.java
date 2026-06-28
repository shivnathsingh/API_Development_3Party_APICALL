package ProductService.demo.repositories;

import ProductService.demo.models.Category;
import ProductService.demo.models.Product;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    CategoryRepo categoryRepo;

    @Test
    // This is used to declare a method as test case
    @Transactional
    // this is used just to rollback test cases data not to run test cases , without this also
    // we can execute test cases
    void testFetchType() {

        System.out.println("Transaction Active = "
                + TransactionSynchronizationManager.isActualTransactionActive());

        Category category = categoryRepo.findById(1L).orElseThrow();

        System.out.println("Category = " + category.getDescription());

        System.out.println("Product Count = " + category.getProductList().size());

//        for (Product p : category.getProductList()) {
//            System.out.println(p.getTitle() + " " + p.getCategory().getDescription());
//        }
    }


    // mvn test -Dtest=ProductServiceTest#testSaveProduct
    // mvn test -Dtest=CategoryRepoTest#testFetchMode
    @Test
    @Transactional
    void testFetchMode() {


        List<Category> categor1 = categoryRepo.findAll();

        for (Category category : categor1) {
            System.out.println("Category = " + category.getDescription());
            System.out.println("Product Count = " + category.getProductList().size());
            for (Product p : category.getProductList()) {
                System.out.println(p.getTitle() + " " + p.getCategory().getDescription());
            }
        }
    }





}