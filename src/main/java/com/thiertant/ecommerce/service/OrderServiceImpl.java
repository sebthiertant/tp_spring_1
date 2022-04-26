package com.thiertant.ecommerce.service;

import com.thiertant.ecommerce.exception.StockException;
import model.Order;
import model.OrderProduct;
import model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("orders")
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

        boolean matchingOrder = allOrders
                                .stream()
                                .anyMatch(o -> Objects.equals(o.getId(), order.getId()));

        if (matchingOrder){
            System.out.println("Commande déjà présente.");
        } else {
            order.setStatus("En cours");
            allOrders.add(order);
        }

        return order;
    }

    @Override
    public void update(Order order) throws StockException {

        for (OrderProduct orderProduct : order.getOrderProductArrayList()) {
            if (orderProduct.getProduct().getQuantity() - orderProduct.getQuantity() < 0) {
                throw new StockException("Stock insuffisant");
            } else {
                orderProduct.getProduct().setQuantity(orderProduct.getProduct().getQuantity() - orderProduct.getQuantity());
            }
        }

        if(Objects.equals(order.getStatus(), "En cours")) {
            order.setStatus("Payée");
        }
    }
}
