package com.thiertant.ecommerce;

import com.thiertant.ecommerce.exception.StockException;
import com.thiertant.ecommerce.service.ClientService;
import com.thiertant.ecommerce.service.OrderService;
import com.thiertant.ecommerce.service.ProductService;
import model.Client;
import model.Order;
import model.OrderProduct;
import model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;

//@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) throws StockException {
        //SpringApplication.run(EcommerceApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

        ProductService productService = context.getBean("products", ProductService.class);

        Product product1 = new Product(1547234L, "Produit 1", "Ma description", 12.5, "image/ici", 150);
        Product product2 = new Product(1547227L, "Produit 2", "Ma description", 38.9, "image/ici", 150);
        Product product3 = new Product(122472L, "Produit 3", "Ma description", 150.5, "image/ici", 150);
        Product product4 = new Product(9805472L, "Produit 4", "Ma description", 15.0, "image/ici", 150);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);

        productService.getAllProducts().forEach(System.out::println);


        ClientService clientService = context.getBean("clients", ClientService.class);

        Client client1 = new Client(18700980L, "Sébastien", "AHFIFZ");
        Client client2 = new Client(18700272L, "Cécilia", "AHFIFZ");


        clientService.save(client1);
        clientService.save(client2);

        clientService.getAllClient().forEach(System.out::println);


        OrderService orderService = context.getBean("orders", OrderService.class);
        Order order1 = new Order(1L, client1, LocalDate.now(), "null", new ArrayList<OrderProduct>());
        Order order2 = new Order(2L, client2, LocalDate.now(), "null", new ArrayList<OrderProduct>());

        order1.addProduct(product1, 200);
        order1.addProduct(product3, 4);

        System.out.println(order1); // Le statut doit être à “null”


        // On utilise le bean de type service pour ajouter cette commande
        orderService.create(order1);
        System.out.println(order1); // Le statut doit être à “En cours”


        try {
            orderService.update(order1);
            System.out.println(order1); // Le statut doit être à “Payée”
        }
        catch(StockException e) {
            System.err.println("StockException: " + e.getMessage());
        }

        //orderService.update(order1);

        //orderService.getAllOrders().forEach(System.out::println);

        /*

        //System.out.println(client1);

        Order order = new Order(946289L, client1, LocalDate.now(), "Payée");

        order.addProduct(product1, 2);
        order.addProduct(product1, 2);
        order.addProduct(product1, 2);
        order.addProduct(product1, 2);

        order.addProduct(product2, 26);

        order.addProduct(product3, 15);
        order.addProduct(product4, 6);

        System.out.println(order);
        System.out.println(order.getTotalNumberOfProducts());
        System.out.println(order.getTotalOrderPrice());

         */

    }

}
