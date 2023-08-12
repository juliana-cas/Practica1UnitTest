package Repository.RepositoryImpl;


import Domain.Models.Product;
import Mapping.Dto.ProductDto;
import Mapping.Mappers.ProductMapper;
import Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;

    public ProductRepositoryImpl() {
        products = new ArrayList<Product>();
        Product product1 = new Product(1L,"Cien años de soledad","Libros",150000.0);
        Product product2 = new Product(2L,"El principito","Libros",80000.0);
        Product product3 = new Product(3L,"Maravilloso desastre","Libros",70000.0);
        Product product4 = new Product(4L,"Me before you","Libros",110000.0);
        Product product5 = new Product(5L,"Pañales","Bebé",20000.0);
        Product product6 = new Product(6L,"Coche","Bebé",100000.0);
        Product product7 = new Product(7L,"Peluche de oso","Juguetes",50000.0);
        Product product8 = new Product(8L,"Pelota","Juguetes",15000.0);
        Product product9 = new Product(9L,"Bajo la misma estrella","Libros",150000.0);
        Product product10 = new Product(10L,"Ciudades de papel","Libros",60000.0);

        products = List.of(product1,product2,product3,product4,product5,product6,product7,product8,product9,product10);

    }


    @Override
    public List<ProductDto> getAllProducts() {
        return ProductMapper.mapFrom(products);
    }
}