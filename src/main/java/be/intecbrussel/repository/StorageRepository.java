package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

public class StorageRepository implements IStorageRepository {
    //custom methods
    @Override
    public void createStorage(Storage storage) {

        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(storage);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Storage readStorage(Storage name) {
        return null;
    }

    @Override
    public void updateStorage(String name) {

    }

    @Override
    public void deleteStorage(String name) {

    }
}
