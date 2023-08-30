package be.intecbrussel.model;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    //properties
    private String name;
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
