package be.intecbrussel.service;

import be.intecbrussel.model.*;
import be.intecbrussel.repository.StorageRepository;

public class StorageService implements IStorageService {
    private StorageRepository storageRepository = new StorageRepository();
    ProductService productService = new ProductService();
    //custom methods
    @Override
    public void addStorage(Storages storages) {
        for (Product product : storages.getStorageContent()) {

            if(product.getId() == 0) {
                productService.addProduct(product);
            } else {
                productService.updateProduct(product); //= VOOR UPDATE
            }
        }
        storageRepository.createStorage(storages);
    }

    @Override
    public Storages getStorage(long id) {
        return storageRepository.readStorage(id);
    }

    @Override
    public void updateStorage(Storages storages) {
        storageRepository.updateStorage(storages);
    }

    @Override
    public void deleteStorage(long id) {
        storageRepository.deleteStorage(id);
    }
}
