package be.intecbrussel.service;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.repository.IProductRepository;
import be.intecbrussel.repository.ProductRepository;
import jakarta.persistence.EntityManager;

public class ProductService implements IProductService {
    //properties
    private IProductRepository repo = new ProductRepository();


    //custom methods
    @Override
    public void addProduct(Product product) {
        repo.createProduct(product);
    }

    @Override
    public Product getProduct(long id) {
        return repo.readProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        repo.updateProduct(product);
    }

    @Override
    public void deleteProduct(long id) {
        Product productToDelete = repo.readProduct(id);
        repo.deleteProduct(productToDelete);
    }

    @Override
    public void deleteProduct(Product product) {
        repo.deleteProduct(product);
    }
}
