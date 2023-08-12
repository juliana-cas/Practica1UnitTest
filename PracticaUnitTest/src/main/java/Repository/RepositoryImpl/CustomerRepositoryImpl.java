package Repository.RepositoryImpl;

import Domain.Models.Customer;
import Mapping.Dto.CustomerDto;
import Mapping.Mappers.CustomerMapper;
import Repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customers;

    public CustomerRepositoryImpl(){
        customers = new ArrayList<>();
        Customer c1 = new Customer(1L, "Juan", 2);
        Customer c2 = new Customer(2L, "Juliana", 1);
        Customer c3 = new Customer(3L, "Laura", 3);
        Customer c4 = new Customer(4L, "Sandra",3);
        Customer c5 = new Customer(5L, "Carlos",2);

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
    }


    @Override
    public List<CustomerDto> getAllCustomers() {
        return CustomerMapper.mapFrom(customers);
    }
}