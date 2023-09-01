package be.intecbrussel.repository;

import be.intecbrussel.model.Product;

public interface IProductRepository {
    //CREATE
    void createProduct(Product product);

    //READ
    Product readProduct(long id);

    //UPDATE
    void updateProduct(Product product);

    //DELETE
    void deleteProduct(Product name);
}
