package Services;

import Mapping.Dto.ProductDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductServices {

    List<ProductDto> filteredBooks();
    List<ProductDto> toysDiscount();
    ProductDto listCheapest();
    Map<String, Optional<ProductDto>> mostExpensive();

    String getListCheapestThread();
    List<ProductDto> getToysDiscountThread();
    void sleepThread(int millis);

}