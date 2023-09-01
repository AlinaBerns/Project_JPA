package be.intecbrussel.service;

import be.intecbrussel.model.Storage;

public interface IStorageService {
    //CREATE
    void addStorage(Storage storage);

    //READ
    Storage getStorage(long id); //no Optional<>, in this project we're working with Exceptions.

    //UPDATE
    void updateStorage(Storage storage);

    //DELETE
    void deleteStorage(long id);
}
