package be.intecbrussel.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity //specifies that the model class corresponds to a table in the database
public class Product {
    //properties
    @Id //specifies the property is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //specifies that the Id is generated by the database, "strategy = GenerationType.X" specifies the Id's possible values
    //GenerationTypes explained: https://www.baeldung.com/hibernate-identifiers
    private long id;
    private String name;
    private double value;
    private double weight;

    //constructors
    protected Product() { //protected access modifier so JPA has access to a no-args constructor
    }

    public Product(String name, double value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }


    //getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



    //custom methods
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.value, value) == 0 && Double.compare(product.weight, weight) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, weight);
    }
}
