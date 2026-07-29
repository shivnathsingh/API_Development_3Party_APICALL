package ProductService.demo.services;

import ProductService.demo.models.Product;
import ProductService.demo.models.SortParame;
import ProductService.demo.models.SortType;
import ProductService.demo.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class JpaBasedSearchService implements  ISearchService{

    @Autowired
    ProductRepo productRepo;

    @Override
    public Page<Product> searchProduct(String query, Integer pageSize, Integer pageNo, List<SortParame> sortParames) {
//        Sort sortbyPrice=Sort.by("price").descending();
//        Sort sortById=Sort.by("id").descending();
//        Sort sort=sortbyPrice.and(sortById);

        Sort sort=null;
        if(!sortParames.isEmpty())
        {
            System.out.println("Length of sort parameter "+sortParames.size());

            System.out.println("Sorting by "+sortParames.get(0).getName()+" in "+sortParames.get(0).getSortType().toString());
            if(sortParames.get(0).getSortType().equals(SortType.ASC))
            {
               sort=Sort.by(sortParames.get(0).getName()).ascending();
            }else {
                sort=Sort.by(sortParames.get(0).getName()).descending();
            }

            for(int i=1;i<sortParames.size();i++)
            {
                System.out.println("Sorting by "+sortParames.get(i).getName()+" in "+sortParames.get(0).getSortType().toString());

                Sort temp=null;
                if(sortParames.get(i).getSortType().equals(SortType.ASC))
                {
                    temp=Sort.by(sortParames.get(i).getName()).ascending();
                }else {
                    temp=Sort.by(sortParames.get(i).getName()).descending();
                }
                sort=sort.and(temp);
            }
        }
        if(sort==null)
            return productRepo.findByTitleEquals(query, PageRequest.of(pageNo,pageSize));
        return productRepo.findByTitleEquals(query, PageRequest.of(pageNo,pageSize,sort));

    }
}
