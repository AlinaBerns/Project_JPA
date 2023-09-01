package be.intecbrussel.service;

import be.intecbrussel.model.Storages;

public interface IStorageService {
    //CREATE
    void addStorage(Storages storages);

    //READ
    Storages getStorage(long id); //no Optional<>, in this project we're working with Exceptions.

    //UPDATE
    void updateStorage(Storages storages);

    //DELETE
    void deleteStorage(long id);
}
