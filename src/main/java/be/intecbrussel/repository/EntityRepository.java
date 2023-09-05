package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import jakarta.persistence.EntityManager;

public class EntityRepository <E> implements IEntityRepository <E>{
    @Override
    public void create(E entity) {

        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        entityManager.close();

    }

    @Override
    public E read(Class<E> returnClass, Object id) {

        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();
        E dbEntity = entityManager.find(returnClass, id);
        entityManager.close();

        return dbEntity;
    }

    @Override
    public void update(E entity) {
        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();

        entityManager.close();

    }

    @Override
    public void delete(Class<E> entityClass, Object obj) {
        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();

        entityManager.getTransaction().begin();
        E dbEntity = entityManager.find(entityClass, obj);
        entityManager.remove(dbEntity);
        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
