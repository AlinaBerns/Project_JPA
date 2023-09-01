package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.service.StorageService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Metamodel;
import org.hibernate.mapping.Set;

public class ProductRepository implements IProductRepository {
    @Override
    public void createProduct(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();

        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Product readProduct(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        //em.getTransaction().begin();
        Product dbProduct;

        dbProduct = em.find(Product.class, id);

        //em.getTransaction().commit();
        em.close();

        System.out.println(dbProduct);

        return dbProduct;
    }

    @Override
    public void updateProduct(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Product productTest = em.merge(product);

        if(!productTest.equals(product)) {
            em.getTransaction().rollback();
        } else{
            em.getTransaction().commit();
        }

        em.close();
    }

    @Override
    public void deleteProduct(Product product) {
        EntityManager em1 = EMFProvider.getEMF().createEntityManager();
        em1.getTransaction().begin();
        Product dbProduct = em1.find(Product.class, product.getId());
        em1.remove(dbProduct);
        em1.getTransaction().commit();

        em1.close();
    }
}
