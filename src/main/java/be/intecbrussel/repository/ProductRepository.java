package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import jakarta.persistence.EntityManager;

public class ProductRepository extends EntityRepository<Product> implements IProductRepository {

}
