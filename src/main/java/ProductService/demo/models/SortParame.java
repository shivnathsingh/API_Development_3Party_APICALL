package ProductService.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class SortParame {

   private String name;
   private SortType sortType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }
}

