package model;

public class OrderProduct {

    private Product product;
    private Order order;
    private Integer quantity;

    public OrderProduct() {
        super();
    }


    public OrderProduct(Product product, Order order, Integer quantity) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return product.getPrice() * this.quantity;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "product=" + product +
                ", quantity=" + this.quantity +
                '}';
    }
}
