import Services.ServicesImpl.OrderServicesImpl;
import Services.ServicesImpl.ProductServicesImpl;
import Services.OrderServices;
import Services.ProductServices;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static ProductServices productService;
    private static OrderServices orderService;

    public static void main(String[] args) {

        productService = new ProductServicesImpl();
        orderService = new OrderServicesImpl(productService);

        Scanner n = new Scanner(System.in);
        int opc = 0;

        while (opc != 16) {
            System.out.println("Escribe un número para hacer consulta..." +
                    " 1. Productos de categoría Libros con un precio mayor a 100.000" +
                    " 2. Pedidos que incluyan productos de la categoría Bebé." +
                    " 3. Productos de la categoría Juguetes con descuento del 10%. " +
                    " 4. Productos pedidos por clientes de nivel 2 entre el 01 de febrero de 2021 y el 01 de abril de 2021." +
                    " 5. Productos de la categoría Libros con los precios más bajos." +
                    " 6. Los 3 pedidos más recientes, con base en la fecha de la orden" +
                    " 7. Suma total de los pedidos tomados en una fecha." +
                    " 8. Promedio de pago en los pedidos en una fecha determinada." +
                    " 9. Mapa de datos con registros de pedidos agrupados por cliente." +
                    " 10. Producto más costoso en cada categoría." +
                    " 11. Implementación de un proceso asíncrono utilizando runAsync." +
                    " 12. Implementación de un proceso asíncrono utilizando supplyAsync. " +
                    " 13. Implementación de thenAccept después de un proceso asíncrono. " +
                    " 14. Implementación de thenApply y exceptionally después de un proceso asíncrono." +
                    " 15. Implementación de thenRun después de un proceso asíncrono." +
                    " 16. Salir.");
            opc = n.nextInt();

            switch (opc) {
                case 1 -> {
                    System.out.println(productService.filteredBooks());
                }
                case 2 -> {
                    System.out.println(orderService.getBaby());
                }
                case 3 -> {
                    System.out.println(productService.toysDiscount());
                }
                case 4 -> {
                    System.out.println(orderService.filterTierDate());
                }
                case 5 -> {
                    System.out.println(productService.listCheapest());
                }
                case 6 -> {
                    System.out.println(orderService.list3Latest());
                }
                case 7 -> {
                    System.out.println(orderService.sumSpecificDate());
                }
                case 8 -> {
                    System.out.println(orderService.avgSpecificDate());
                }
                case 9 -> {
                    System.out.println(orderService.ordersByTier());
                }
                case 10 -> {
                    System.out.println(productService.mostExpensive());
                }
                case 11 -> {
                    CompletableFuture.runAsync(() -> System.out.println(productService.getListCheapestThread()));
                    productService.sleepThread(5000);
                    System.out.println("Main thread finished");
                }
                case 12 -> {
                    System.out.println(CompletableFuture.supplyAsync(() -> productService.getToysDiscountThread()).join());
                }
                case 13 -> {
                    CompletableFuture.supplyAsync(() -> productService.getToysDiscountThread())
                            .thenAccept(System.out::println);
                    productService.sleepThread(8000);
                }
                case 14 -> {
                    CompletableFuture.supplyAsync(() -> orderService.getSumSpecificDateThread())
                            .thenApply(result -> result + orderService.getAvgSpecificDateThread())
                            .exceptionally(error -> 0.0)
                            .thenAccept(System.out::println);
                    orderService.sleepThread(3000);
                }
                case 15 -> {
                    CompletableFuture.supplyAsync(() -> orderService.getAvgSpecificDateThread())
                            .thenAccept(System.out::println)
                            .thenRun(() -> System.out.println(productService.getListCheapestThread()));
                    orderService.sleepThread(5000);
                }
                case 16 -> {
                    System.out.println("Closed");
                }
                default -> {
                    System.out.println("Invalid number");
                }
            }

        }
    }
}