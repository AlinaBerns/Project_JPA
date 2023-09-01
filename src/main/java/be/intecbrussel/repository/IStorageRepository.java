package be.intecbrussel.repository;

import be.intecbrussel.model.*;

public interface IStorageRepository {
    //CREATE
    void createStorage(Storages storages);

    //READ
    Storages readStorage(long id);

    //UPDATE
    void updateStorage(Storages storages);

    //DELETE
    void deleteStorage(long id);
}
