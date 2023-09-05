package be.intecbrussel.service;

import be.intecbrussel.model.Product;

public interface IEntityService <E, ID> {
    void add(E entity);
    E get(ID id);
    void update(E entity);
    void delete(ID object);
}
