package Repository;

import Mapping.Dto.ProductDto;

import java.util.List;

public interface ProductRepository {

    public List<ProductDto> getAllProducts();

}