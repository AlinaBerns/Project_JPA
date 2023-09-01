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
    public Storage readStorage(long id) {
        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();
        //entityManager.getTransaction().begin();
        Storage storage;

        storage = entityManager.find(Storage.class, id);
        System.out.println(storage);

        //entityManager.getTransaction().commit();
        entityManager.close();

        return storage;
    }

    @Override
    public void updateStorage(Storage storage) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Storage storage1 = em.merge(storage);

        if(storage1.getId()!=(storage.getId())) {
            em.getTransaction().rollback();
        } else {
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public void deleteStorage(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Storage storage = em.find(Storage.class, id);

        em.remove(storage);

        em.getTransaction().commit();
        em.close();
    }
}
