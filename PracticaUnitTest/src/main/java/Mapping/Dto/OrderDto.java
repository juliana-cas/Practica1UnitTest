package Mapping.Dto;

import Domain.Models.Customer;
import Domain.Models.Product;

import java.time.LocalDate;
import java.util.List;

public record OrderDto(Long id,
                       String status,
                       LocalDate orderDate,
                       LocalDate deliveryDate,
                       List<Product> products,
                       Customer customer) {
}