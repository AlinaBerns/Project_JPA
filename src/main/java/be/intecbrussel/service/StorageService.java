package be.intecbrussel.service;

import be.intecbrussel.model.*;
import be.intecbrussel.repository.StorageRepository;

public class StorageService implements IStorageService {
    private StorageRepository storageRepository = new StorageRepository();
    ProductService productService = new ProductService();
    //custom methods
    @Override
    public void addStorage(Storage storage) {
        for (Product product : storage.getStorageContent()) {

            if(product.getId() == 0) {
                productService.addProduct(product);
            } else {
                productService.updateProduct(product.getId(), product.getName()); //= VOOR UPDATE
            }
        }
        storageRepository.createStorage(storage);
    }

    @Override
    public Storage getStorage(long id) {
        return storageRepository.readStorage(id);
    }

    @Override
    public void updateStorage(long id, String newName) {
        storageRepository.updateStorage(id, newName);
    }

    @Override
    public void deleteStorage(long id) {
        storageRepository.deleteStorage(id);
    }
}
