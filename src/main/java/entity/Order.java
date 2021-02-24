package entity;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private int id;
    private Account customer;
    List<Item> items;
    private int status;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", items=" + items +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getCustomer() {
        return customer;
    }

    public void setCustomer(Account customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Order() {
    }

    public Order(int id, Account customer, List<Item> items, int status) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.status = status;
    }
}
