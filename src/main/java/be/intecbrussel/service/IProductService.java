package be.intecbrussel.service;

import be.intecbrussel.model.Product;

public interface IProductService {
    //CREATE
    void addProduct(Product product);

    //READ
    Product getProduct(long id); //no Optional<>, in this project we're working with Exceptions.

    //UPDATE
    void updateProduct(long id, String newName);

    //DELETE
    void deleteProduct(long id);

    void deleteProduct(Product product);
}
