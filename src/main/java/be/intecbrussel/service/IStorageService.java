package be.intecbrussel.service;

import be.intecbrussel.model.Storage;

public interface IStorageService {
    //CREATE
    void addStorage(Storage storage);

    //READ
    Storage getStorage(long id); //no Optional<>, in this project we're working with Exceptions.

    //UPDATE
    void updateStorage(long id, String newName);

    //DELETE
    void deleteStorage(long id);
}
