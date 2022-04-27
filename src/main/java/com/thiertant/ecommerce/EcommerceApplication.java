package com.thiertant.ecommerce;

import com.thiertant.ecommerce.exception.StockException;
import com.thiertant.ecommerce.model.Product;
import com.thiertant.ecommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan("com.*")
public class EcommerceApplication {

    public static void main(String[] args) throws StockException {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ProductService productService) {
        return args -> {
            Product product1 = new Product(1L, "Echiquier 1", "desc1", 12d, "url1", 14);
            Product product2 = new Product(2L, "Echiquier 2", "desc2", 32d, "url2", 13);
            Product product3 = new Product(2L, "Echiquier 3", "desc2", 32d, "url2", 13);
            Product product4 = new Product(2L, "Echiquier 4", "desc2", 32d, "url2", 13);

            productService.save(product1);
            productService.save(product2);
            productService.save(product3);
            productService.save(product4);
        };
    }

}
