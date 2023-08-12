package Services;

import Mapping.Dto.ProductDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CustomerServices {
    List<ProductDto> getProdFromCategorPrice();
    List<ProductDto> getProdFromCategoryApplyDiscount();
    ProductDto getCheapestProduct();
    Map<String, Optional<ProductDto>> getMostExpensiveProduct();

    String getCheapestProductThread();
    List<ProductDto> getProdFromCategoryApplyDiscountThread();
    void sleepThread(int millis);
}
