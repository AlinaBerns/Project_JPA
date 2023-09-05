package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IEntityRepository;
import be.intecbrussel.repository.ProductRepository;

public class ProductService implements IProductService {
    private IStorageService storageService;
    private IEntityRepository<Product> productIEntityRepository = new ProductRepository();

    protected ProductService (StorageService storageService) {
        this.storageService = storageService;
    }

    public ProductService() {
        storageService = new StorageService(this);
    }

    @Override
    public void add(Product entity) {
        productIEntityRepository.create(entity);
    }

    @Override
    public Product get(Long aLong) {
        return productIEntityRepository.read(Product.class, aLong);
    }

    @Override
    public void update(Product entity) {
        productIEntityRepository.update(entity);
    }

    @Override
    public void delete(Long object) {
        storageService = new StorageService();
        Product product1 = productIEntityRepository.read(Product.class, object);


        storageService.deleteProductFromStorage(Storage.class, product1);
        productIEntityRepository.delete(Product.class, object);
    }
}
