package be.intecbrussel.service.implementations;

import be.intecbrussel.model.Product;
import be.intecbrussel.repository.entities.IProductRepository;
import be.intecbrussel.repository.implementations.ProductRepository;
import be.intecbrussel.service.entities.IProductService;
import be.intecbrussel.service.entities.IStorageService;

public class ProductService implements IProductService {
    private IProductRepository repo = new ProductRepository();

    protected IStorageService storageService = Service.getStorageService();

    @Override
    public void add(Product product) {
        if (product.getId() != 0) {
            update(product);
        }

        repo.create(product);
    }

    @Override
    public Product get(Long id) {
        return repo.read(Product.class, id);
    }

    @Override
    public void update(Product product) {
        repo.update(product);
    }

    @Override
    public void delete(Long id) {
        if (id == 0) {
            return;
        }

        deleteProduct(get(id));
    }

    @Override
    public void deleteProduct(Product product) {
        if (product.getId() == 0) {
            return;
        }

        storageService.deleteProductFromStorage(product);
        repo.delete(Product.class, product.getId());
    }
}