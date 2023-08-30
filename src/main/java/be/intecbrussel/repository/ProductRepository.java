package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import jakarta.persistence.EntityManager;

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
        em.getTransaction().begin();
        Product dbProduct;

        dbProduct = em.find(Product.class, id);
        em.getTransaction().commit();
        em.close();

        System.out.println(dbProduct);

        return dbProduct;
    }

    @Override
    public void updateProduct(long id, String newName) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Product productTest = em.find(Product.class, id);
        em.merge(productTest);
        productTest.setName(newName);

        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void deleteProduct(Product name) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Product dbProduct = em.find(Product.class, name.getId());
        em.remove(dbProduct); //OR em.remove(em.merge(product));
        em.getTransaction().commit();

        em.close();

    }
}
