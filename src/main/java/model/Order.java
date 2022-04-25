package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

    private Long id;
    private Client client;
    private LocalDate dateCreated;
    private String status;
    private ArrayList<OrderProduct> orderProductArrayList;

    public Order() {
        super();
    }

    public Order(Long id, Client client, LocalDate dateCreated, String status) {
        this.id = id;
        this.client = client;
        this.dateCreated = dateCreated;
        this.status = status;
        this.orderProductArrayList = new ArrayList<>();
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
        for (int i = 0; i < orderProductArrayList.size(); i++) {
            if (orderProductArrayList.get(i).getProduct().getId() == product.getId()) {
                orderProductArrayList.get(i).setQuantity(orderProductArrayList.get(i).getQuantity() + quantity);
                uniqueProduct = false;
            }
        }
        if (uniqueProduct){
            orderProductArrayList.add(new OrderProduct(product, this, quantity));
        }
    }

    public Double getTotalOrderPrice(){
        Double totalPrice = 0d;
        //orderProductArrayList.forEach((orderProduct) -> totalPrice += orderProduct.getTotalPrice()); J'aurais préféré cette solution mais je n'arrive pas à comprendre comment la résoudre
        for (int i = 0; i < orderProductArrayList.size(); i++) {
            totalPrice += orderProductArrayList.get(i).getTotalPrice();
        }
        return totalPrice;
    }

    public int getNumberOfProducts() {
        return (int) orderProductArrayList.stream().distinct().count();
    }

    public int getTotalNumberOfProducts() {
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
                ", orderProductArrayList=" + orderProductArrayList +
                '}';
    }
}
