package com.thiertant.ecommerce;

import model.Client;
import model.Order;
import model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

//@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        //SpringApplication.run(EcommerceApplication.class, args);

        Product product1 = new Product(1547234L, "Produit 1", "Ma description", 12.5, "image/ici", 150);
        Product product2 = new Product(1547227L, "Produit 2", "Ma description", 38.9, "image/ici", 150);
        Product product3 = new Product(122472L, "Produit 3", "Ma description", 150.5, "image/ici", 150);
        Product product4 = new Product(9805472L, "Produit 4", "Ma description", 15.0, "image/ici", 150);

        Client client1 = new Client(18700980L, "Sébastien", "AHFIFZ");
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
    }

}
