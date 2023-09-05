package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class StorageRepository extends EntityRepository<Storage> implements IStorageRepository {
    //custom methods
    @Override
    public Storage readStorage(Product product) {
        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();
        String queryString = "SELECT s FROM Storage s JOIN s.storageContent p where p.id = ?1";
        Query query = entityManager.createQuery(queryString);

        query.setParameter(1, product.getId());


        //Will throw exception if product is not part of a storage
        Storage resultSet = (Storage) query.getSingleResult();
        return resultSet;
    }
}
