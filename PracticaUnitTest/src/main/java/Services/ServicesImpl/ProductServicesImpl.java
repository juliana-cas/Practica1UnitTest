package Services.ServicesImpl;


import Mapping.Dto.OrderDto;
import Mapping.Dto.ProductDto;
import Repository.ProductRepository;
import Repository.RepositoryImpl.ProductRepositoryImpl;
import Services.ProductServices;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServicesImpl implements ProductServices {

    List<ProductDto> products;
    List<OrderDto> orders;

    public ProductServicesImpl() {
        ProductRepository repo = new ProductRepositoryImpl();
        products = repo.getAllProducts();
    }


    @Override
    public List<ProductDto> filteredBooks() {
        return products.stream()
                .filter(e -> e.category().equalsIgnoreCase("Libros"))
                .filter(e -> e.price() > 100000)
                .toList();
    }

    @Override
    public List<ProductDto> toysDiscount() {
        return products.stream()
                .filter(e -> e.category().equalsIgnoreCase("Juguetes"))
                .map(dis -> {
                    double discountedPrice = dis.price() * 0.10;
                    return new ProductDto(dis.id(),dis.name(), dis.category(), dis.price() - discountedPrice);
                })
                .toList();
    }

    @Override
    public ProductDto listCheapest() {
        return products.stream()
                .filter(e -> e.category().equalsIgnoreCase("Libros"))
                .min(Comparator.comparing(ProductDto::price)).orElse(null);
    }

    @Override
    public Map<String, Optional<ProductDto>> mostExpensive() {
        return products.stream()
                .collect(Collectors.groupingBy(ProductDto::category,Collectors.
                        maxBy(Comparator.comparing(ProductDto::price))));
    }

    @Override
    public String getListCheapestThread() {
        sleepThread(3000);
        return "Thread finished "+ listCheapest();
    }

    @Override
    public List<ProductDto> getToysDiscountThread() {
        sleepThread(4000);
        return toysDiscount();    }

    @Override
    public void sleepThread(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
