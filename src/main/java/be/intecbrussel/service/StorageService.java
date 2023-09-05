package be.intecbrussel.service;

import be.intecbrussel.model.*;
import be.intecbrussel.repository.EntityRepository;
import be.intecbrussel.repository.IEntityRepository;
import be.intecbrussel.repository.StorageRepository;

public class StorageService implements IStorageService {
    private IEntityService<Product, Long> productService;
    private StorageRepository storageIEntityRepository = new StorageRepository();

    protected StorageService (ProductService productService) {
        this.productService = productService;
    }

    public StorageService () {
        productService = new ProductService(this);
    }

    @Override
    public void add(Storage storage) {
        for (Product product : storage.getStorageContent()) {

            if(product.getId() == 0) {
                productService.add(product);
            } else {
                productService.update(product); //= VOOR UPDATE
            }
        }
        storageIEntityRepository.create(storage);
    }

    @Override
    public Storage get(Long aLong) {
        return storageIEntityRepository.read(Storage.class, aLong);
    }

    @Override
    public void update(Storage storage) {
        for (Product product: storage.getStorageContent()){
            if(product.getId() == 0) {
                productService.add(product);
            }
        }
        storageIEntityRepository.update(storage);
    }

    @Override
    public void delete(Long object) {
        storageIEntityRepository.delete(Storage.class, object);
    }

    @Override
    public void deleteProductFromStorage(Class<Storage> storageClass, Product product) {
        Storage dbStorage = storageIEntityRepository.read(storageClass,product.getId());
        dbStorage.getStorageContent().remove(product);
        update(dbStorage);
    }
}
