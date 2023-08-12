package Repository.RepositoryImpl;


import Domain.Models.Customer;
import Domain.Models.Order;
import Domain.Models.Product;
import Mapping.Dto.OrderDto;
import Mapping.Mappers.CustomerMapper;
import Mapping.Mappers.OrderMapper;
import Mapping.Mappers.ProductMapper;
import Repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    List<Product> products;
    List<Customer> customer;
    List<Order> orders;

    public OrderRepositoryImpl(){
        CustomerRepositoryImpl customerRepo = new CustomerRepositoryImpl();
        ProductRepositoryImpl productRepo = new ProductRepositoryImpl();
        customer = CustomerMapper.mapFromDto(customerRepo.getAllCustomers());
        products = ProductMapper.mapFromDto(productRepo.getAllProducts());

        Order order1 = new Order(1L,"Processed",LocalDate.of(2022,5,10)
                ,LocalDate.now(),products.subList(3, 5),customer.get(2));
        Order order2 = new Order(2L,"Processed",LocalDate.of(2021,3,25)
                ,LocalDate.now(),products.subList(2, 1),customer.get(1));
        Order order3 = new Order(3L,"Processed",LocalDate.now(),LocalDate.now(),products.subList(9, 4),customer.get(1));
        Order order4 = new Order(4L,"Processed",LocalDate.of(2023,7,15)
                ,LocalDate.now(),products.subList(2, 8),customer.get(2));
        Order order5 = new Order(5L,"Processed",LocalDate.of(2021,1,12)
                ,LocalDate.now(),products.subList(3, 5),customer.get(1));
        Order order6 = new Order(6L,"Processed",LocalDate.of(2021,4,18)
                ,LocalDate.now(),products.subList(4,7),customer.get(2));
        Order order7 = new Order(7L,"Processed",LocalDate.of(2020,10,9)
                , LocalDate.now(),products.subList(1, 10),customer.get(0));

        orders = List.of(order1, order2, order3, order4, order5, order6,order7);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return OrderMapper.mapFrom(orders);
    }

}
