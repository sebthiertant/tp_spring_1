package model;

import java.time.LocalDate;

public class Order {

    private Long id;
    private Long client_id;
    private LocalDate dateCreated;
    private String status;


    public Order() {
        super();
    }

    public Long getId() {
        return id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }
}
