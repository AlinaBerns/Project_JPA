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
