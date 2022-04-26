package com.thiertant.ecommerce;

import com.thiertant.ecommerce.exception.StockException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan("com.*")
public class EcommerceApplication {

    public static void main(String[] args) throws StockException {

        SpringApplication.run(EcommerceApplication.class, args);

    }

}
