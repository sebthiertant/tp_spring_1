package model;

public class OrderProduct {

    private Long product_id;
    private Long order_id;
    private Integer quantity;

    public OrderProduct() {
        super();
    }

    public Long getProduct_id() {
        return product_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
