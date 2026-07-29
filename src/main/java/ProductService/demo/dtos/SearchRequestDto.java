package ProductService.demo.dtos;

import ProductService.demo.models.SortParame;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class SearchRequestDto {

    private String query;
    private Integer pageSize;
    private Integer pageNo;
    List<SortParame> lst=new ArrayList<>();

    public List<SortParame> getLst() {
        return lst;
    }

    public void setLst(List<SortParame> lst) {
        this.lst = lst;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
