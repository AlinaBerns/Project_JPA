package be.intecbrussel.service.implementations;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.implementations.StorageRepository;
import be.intecbrussel.service.entities.IKeyService;
import be.intecbrussel.service.entities.IPersonService;
import be.intecbrussel.service.entities.IProductService;
import be.intecbrussel.service.entities.IStorageService;

import java.util.List;
import java.util.Optional;

public class StorageService implements IStorageService {
    private StorageRepository storageRepository = new StorageRepository();

    protected IProductService productService = Service.getProductService();
    protected IKeyService keyService = Service.getKeyService();
    protected IPersonService personService = Service.getPersonService();

    @Override
    public void add(Storage storage) {
        if (storage.getId() != 0) {
            update(storage);
        }

        storageRepository.create(storage);
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                productService.add(product);
            } else {
                productService.update(product);
            }
        }
    }

    @Override
    public Storage get(Long id) {
        return storageRepository.read(Storage.class, id);
    }

    @Override
    public void update(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                productService.add(product);
            }
        }

        storageRepository.update(storage);
    }

    @Override
    public void delete(Long id) {
        Storage dbStorage = get(id);
        personService.deleteStorageFromPerson(dbStorage);
        keyService.deleteKeyByStorage(dbStorage);

        storageRepository.delete(Storage.class, id);
    }

    @Override
    public void deleteProductFromStorage(Product product) {
        Storage dbStorage = storageRepository.readStorage(product);
        dbStorage.getStorageContent().remove(product);
        update(dbStorage);
    }

}