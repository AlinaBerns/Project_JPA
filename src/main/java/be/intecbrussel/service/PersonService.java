package be.intecbrussel.service;

import be.intecbrussel.model.Person;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IPersonRepository;
import be.intecbrussel.repository.PersonRepository;

public class PersonService implements IPersonService{
    private IStorageService storageService;
    private PersonRepository personRepository = new PersonRepository();

    protected PersonService(StorageService storageService){
        this.storageService = storageService;
    }

    public PersonService() {
        this.storageService = new StorageService();
    }
    @Override
    public void add(Person person) {
        Storage favStorage = person.getFavoriteStorage();
        if (person.getFavoriteStorage() != null && person.getFavoriteStorage().getId() == 0) {
            storageService.add(favStorage);
        }
        personRepository.create(person);
    }

    @Override
    public Person get(Long aLong) {
        return personRepository.read(Person.class, aLong);
    }

    @Override
    public void update(Person entity) {
        personRepository.update(entity);
    }

    @Override
    public void delete(Long object) {
        personRepository.delete(Person.class, object);
    }
}
