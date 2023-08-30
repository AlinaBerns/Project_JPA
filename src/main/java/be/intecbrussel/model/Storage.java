package be.intecbrussel.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Storage {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    //properties
    private String name;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Product> storageContent;


    //constructors
    public Storage(String name) {
        this.name = name;
        this.storageContent = new ArrayList<>();
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

    public void add(Product... products) { // ... = var args, equivalent to an array
        for (Product product : products) {
            this.add(product);
        }
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", storageContent=" + storageContent +
                '}';
    }
}
