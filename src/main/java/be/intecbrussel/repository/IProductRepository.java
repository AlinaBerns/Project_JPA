package be.intecbrussel.repository;

import be.intecbrussel.model.Product;

public interface IProductRepository {
    //CREATE
    void createProduct(Product product);

    //READ
    Product readProduct(long id);

    //UPDATE
    void updateProduct(long id, String newName);

    //DELETE
    void deleteProduct(Product name);
}
