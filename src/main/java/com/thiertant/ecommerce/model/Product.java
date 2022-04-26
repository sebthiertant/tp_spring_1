package com.thiertant.ecommerce.model;

public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String picture;
    private Integer quantity;

    public Product() {
        super();
    }

    public Product(Long id, String name, String description, Double price, String picture, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
