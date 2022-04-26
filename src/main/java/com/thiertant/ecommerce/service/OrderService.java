package com.thiertant.ecommerce.service;

import com.thiertant.ecommerce.exception.StockException;
import com.thiertant.ecommerce.model.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrders();
    public Order create(Order order);
    public void update(Order order) throws StockException;

}
