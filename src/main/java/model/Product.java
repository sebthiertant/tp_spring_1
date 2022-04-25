package model;

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
}
