package Mapping.Mappers;

import Domain.Models.Product;
import Mapping.Dto.ProductDto;

import java.util.List;

public class ProductMapper {

    public static ProductDto mapFrom(Product source){
        return new ProductDto(source.getId(),
                source.getName(),
                source.getCategory(),
                source.getPrice());
    }

    public static Product mapFrom(ProductDto source){
        return  new Product(source.id(),
                source.name(),
                source.category(),
                source.price());
    }

    public static List<ProductDto> mapFrom(List<Product> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
    public static List<Product> mapFromDto(List<ProductDto> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
