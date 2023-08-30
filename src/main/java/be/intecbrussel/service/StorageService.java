package be.intecbrussel.service;

import be.intecbrussel.model.*;
import be.intecbrussel.repository.StorageRepository;

public class StorageService implements IStorageService {
    private StorageRepository storageRepository = new StorageRepository();
    ProductService productService = new ProductService();
    //custom methods
    @Override
    public void addStorage(Storage storage) {
        storageRepository.createStorage(storage);
    }

    @Override
    public Storage getStorage(String name) {
        return null;
    }

    @Override
    public void updateStorage(Storage storage) {

    }

    @Override
    public void deleteStorage(String name) {

    }
}
