package lk.practice.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
    private String id;
    private String name;
    private double price;

    // Default constructor
    public Product() {}

    // Parameterized constructor
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
