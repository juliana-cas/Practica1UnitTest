package Services;

import Domain.Models.Customer;
import Mapping.Dto.OrderDto;
import Mapping.Dto.ProductDto;

import java.util.List;
import java.util.Map;

public interface OrderServices {
    List<OrderDto> getBaby();
    List<OrderDto> list3Latest();
    double avgSpecificDate();
    double sumSpecificDate();
    Map<Customer,List<OrderDto>> ordersByTier();
    List<ProductDto> filterTierDate();

    Double getSumSpecificDateThread();
    void sleepThread(int millis);
    Double getAvgSpecificDateThread();
}
