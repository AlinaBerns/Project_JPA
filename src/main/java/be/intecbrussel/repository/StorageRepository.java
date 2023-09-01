package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storages;
import be.intecbrussel.service.ProductService;
import be.intecbrussel.service.StorageService;
import jakarta.persistence.EntityManager;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StorageRepository implements IStorageRepository {
    //custom methods
    @Override
    public void createStorage(Storages storages) {

        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(storages);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Storages readStorage(long id) {
        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();
        //entityManager.getTransaction().begin();
        Storages storages;

        storages = entityManager.find(Storages.class, id);
        System.out.println(storages);

        //entityManager.getTransaction().commit();
        entityManager.close();

        return storages;
    }

    @Override
    public void updateStorage(Storages storages) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Storages storages1 = em.merge(storages);

        if(storages1.getId()!=(storages.getId())) {
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
        Storages storages = em.find(Storages.class, id);

        em.remove(storages);

        em.getTransaction().commit();
        em.close();
    }

   // public void deleteProductInStorage(long idStorage, Product product) {
      //  StorageService storageService = new StorageService();
     //   ProductService productService = new ProductService();
        //Iterator<Product> productIterator = storageService
               // .getStorage(idStorage)
               // .getStorageContent()
               // .iterator();

       // Product product1 = productIterator.next();
       // if(product1.getId()==product.getId()){
            //productIterator.remove();
           // productService.deleteProduct(product.getId());

       // }

       // EntityManager entityManager = EMFProvider.getEMF().createEntityManager();
        //entityManager.getTransaction().begin();
       // entityManager.createQuery("ALTER TABLE STORAGES nocheck constraint all").executeUpdate();
        //entityManager.getTransaction().commit();
       // entityManager.close();

       // productService.deleteProduct(product.getId());

    //}
}
