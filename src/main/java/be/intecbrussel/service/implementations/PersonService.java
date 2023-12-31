package be.intecbrussel.service.implementations;

import be.intecbrussel.model.Person;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.entities.IPersonRepository;
import be.intecbrussel.repository.implementations.PersonRepository;
import be.intecbrussel.service.entities.IJobService;
import be.intecbrussel.service.entities.IPersonService;
import be.intecbrussel.service.entities.IStorageService;

import java.util.List;

public class PersonService implements IPersonService {
    private IPersonRepository personRepository = new PersonRepository();

    protected IStorageService storageService = Service.getStorageService();
    protected IJobService jobService = Service.getJobService();

    @Override
    public void add(Person person) {
        if (person.getId() != 0) {
            update(person);
        }

        Storage favStorage = person.getFavoriteStorage();
        if (favStorage != null && favStorage.getId() == 0) {
            storageService.add(favStorage);
        } else if (favStorage != null) {
            storageService.update(favStorage);
        }

        personRepository.create(person);
    }

    @Override
    public Person get(Long id) {
        return personRepository.read(Person.class, id);
    }

    @Override
    public void update(Person person) {
        Storage favStorage = person.getFavoriteStorage();
        if (favStorage != null && favStorage.getId() == 0) {
            storageService.add(favStorage);
        }

        personRepository.update(person);
    }

    @Override
    public void delete(Long id) {
        jobService.deletePersonFromJob(get(id));
        personRepository.delete(Person.class, id);
    }

    @Override
    public void deleteStorageFromPerson(Storage storage) {
        List<Person> dbPeople = personRepository.readPeople(storage);

        for (Person dbPerson : dbPeople) {
            dbPerson.setFavoriteStorage(null);
            update(dbPerson);
        }
    }
}