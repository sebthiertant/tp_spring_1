package com.thiertant.ecommerce.service;

import com.thiertant.ecommerce.exception.StockException;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderServiceImpl implements OrderService{

    private List<Order> allOrders = new ArrayList<>();
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    @Override
    public Order create(Order order) {
        if (Objects.equals(order.getStatus(), "Payée")){
        } else {
            order.setStatus("En cours");
        }
        return order;
    }

    @Override
    public void update(Order order) throws StockException {
        try {
            order.getOrderProductArrayList();
            // on itère sur liste des produits contenus dans la commande et on cherche les id dans le productService


            //productService.getProductById();

            // Si tout bon
            order.setStatus("Payée");
            throw new StockException();
        }
        catch(StockException e) {
            System.out.println(e);
        }
    }
}
