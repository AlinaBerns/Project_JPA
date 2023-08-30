package be.intecbrussel.repository;

import be.intecbrussel.model.*;

public interface IStorageRepository {
    //CREATE
    void createStorage(Storage storage);

    //READ
    Storage readStorage(Storage name);

    //UPDATE
    void updateStorage(String name);

    //DELETE
    void deleteStorage(String name);
}
