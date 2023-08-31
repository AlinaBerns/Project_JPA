package be.intecbrussel.repository;

import be.intecbrussel.model.*;

public interface IStorageRepository {
    //CREATE
    void createStorage(Storage storage);

    //READ
    Storage readStorage(long id);

    //UPDATE
    void updateStorage(long id, String newName);

    //DELETE
    void deleteStorage(long id);
}
