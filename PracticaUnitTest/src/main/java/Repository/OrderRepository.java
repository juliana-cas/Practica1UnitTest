package Repository;

import Mapping.Dto.OrderDto;

import java.util.List;

public interface OrderRepository {

    List<OrderDto> getAllOrders();
}