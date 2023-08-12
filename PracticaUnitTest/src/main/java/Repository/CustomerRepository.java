package Repository;

import Mapping.Dto.CustomerDto;

import java.util.List;

public interface CustomerRepository {

    public List<CustomerDto> getAllCustomers();

}