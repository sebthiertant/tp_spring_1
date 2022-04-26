package com.thiertant.ecommerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Order {

    private Long id;
    private Client client;
    private LocalDate dateCreated;
    private String status;
    private ArrayList<OrderProduct> orderProductArrayList;

    public Order() {
        super();
    }

    public Order(Long id, Client client, LocalDate dateCreated, String status, ArrayList<OrderProduct> orderProductArrayList) {
        this.id = id;
        this.client = client;
        this.dateCreated = dateCreated;
        this.status = status ;
        this.orderProductArrayList = orderProductArrayList;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<OrderProduct> getOrderProductArrayList() {
        return orderProductArrayList;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public void addProduct(Product product, Integer quantity) {
        boolean uniqueProduct = true;
        for (OrderProduct orderProduct : orderProductArrayList) {
            if (Objects.equals(orderProduct.getProduct().getId(), product.getId())) {
                orderProduct.setQuantity(orderProduct.getQuantity() + quantity);
                uniqueProduct = false;
            }
        }
        // essayer avec find sur l'arrayList
        if (uniqueProduct){
            orderProductArrayList.add(new OrderProduct(product, this, quantity));
        }
    }

    public Double getTotalOrderPrice(){
        Double totalPrice = 0d;
        for (OrderProduct orderProduct : orderProductArrayList) {
            totalPrice += orderProduct.getTotalPrice();
        }
        //orderProductArrayList.stream().map(n -> n.getTotalPrice()).reduce(0d, Double::sum);
        return totalPrice;
    }

    public int getNumberOfProducts() {
        return (int) orderProductArrayList.stream().distinct().count();
    }

    public int getTotalNumberOfProducts() {
        int totalQuantity = 0;
        orderProductArrayList.get(1).getQuantity();
        for (OrderProduct orderProduct : orderProductArrayList) {
            totalQuantity += orderProduct.getQuantity();
        }
        return totalQuantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", dateCreated=" + dateCreated +
                ", status='" + status + '\'' +
                ", orderProductArrayList=" + orderProductArrayList +
                '}';
    }
}
