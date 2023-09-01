package be.intecbrussel.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Storages {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    //properties
    private String name;

    @OneToMany (targetEntity = Product.class)
    private List<Product> storageContent;


    //constructors
    public Storages(String name) {
        this.name = name;
        this.storageContent = new ArrayList<>();
    }

    protected Storages() {
    }


    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getStorageContent() {
        return storageContent;
    }

    public void setStorageContent(List<Product> storageContent) {
        this.storageContent = storageContent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    //custom methods
    public void add(Product product) {
        this.storageContent.add(product);
    }

    public void add(Product... products) {
        for (Product product : products) {
            this.add(product);
        }
    }

    @Override
    public String toString() {
        return "Storages{" +
                "name='" + name + '\'' +
                ", storageContent=" + storageContent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storages storages = (Storages) o;
        return id == storages.id && Objects.equals(name, storages.name) && Objects.equals(storageContent, storages.storageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, storageContent);
    }
}
