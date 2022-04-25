package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

    private Long id;
    private Client client;
    private LocalDate dateCreated;
    private String status;

    public Order() {
        super();
    }

    public Order(Long id, Client client, LocalDate dateCreated, String status) {
        this.id = id;
        this.client = client;
        this.dateCreated = dateCreated;
        this.status = status;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public void addProduct(Product product, Integer quantity) {
        OrderProduct orderProduct = new OrderProduct(product, this, quantity);
    }

    public Double getTotalOrderPrice(ArrayList<OrderProduct> orderProductArrayList){
        Double totalPrice = 0d;
        //orderProductArrayList.forEach((orderProduct) -> totalPrice += orderProduct.getTotalPrice()); J'aurais préféré cette solution mais je n'arrive pas à comprendre comment la résoudre
        for (int i = 0; i < orderProductArrayList.size(); i++) {
            totalPrice += orderProductArrayList.get(i).getTotalPrice();
        }
        return totalPrice;
    }

    public int getNumberOfProducts(ArrayList<OrderProduct> orderProductArrayList) {
        return (int) orderProductArrayList.stream().distinct().count();
    }

    public int getTotalNumberOfProducts(ArrayList<OrderProduct> orderProductArrayList) {
        int totalQuantity = 0;
        orderProductArrayList.get(1).getQuantity();
        for (int i = 0; i < orderProductArrayList.size(); i ++) {
            totalQuantity += orderProductArrayList.get(i).getQuantity();
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
                '}';
    }
}
