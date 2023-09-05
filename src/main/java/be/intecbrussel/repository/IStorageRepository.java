package be.intecbrussel.repository;

import be.intecbrussel.model.*;

public interface IStorageRepository extends IEntityRepository<Storage>{
    Storage readStorage(Product product);
}
