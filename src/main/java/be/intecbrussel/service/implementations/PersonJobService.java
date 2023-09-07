package be.intecbrussel.service.implementations;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Job;
import be.intecbrussel.model.Person;
import be.intecbrussel.model.PersonJob;
import be.intecbrussel.repository.entities.IPersonJobRepository;
import be.intecbrussel.repository.implementations.PersonJobRepository;
import be.intecbrussel.service.entities.IJobService;
import be.intecbrussel.service.entities.IPersonJobService;
import be.intecbrussel.service.entities.IPersonService;
import jakarta.persistence.EntityManager;

public class PersonJobService implements IPersonJobService {

    private IPersonService personService = Service.getPersonService();
    private IJobService jobService = Service.getJobService();
    private IPersonJobRepository personJobRepository = new PersonJobRepository();
    @Override
    public void add(PersonJob personJob) {

        if(personJob.getJob().getId() == 0) {
            jobService.add(personJob.getJob());
        }

        if(personJob.getPerson().getId()==0){
            personService.add(personJob.getPerson());
        }

        if(personJob.getId()==0) {
            personJobRepository.create(personJob);
        }
    }

    @Override
    public PersonJob get(Long id) {
        return personJobRepository.read(PersonJob.class, id);
    }

    @Override
    public void update(PersonJob personJob) {
        if (personJobRepository.read(PersonJob.class, personJob.getPerson().getId()) == null) {
            // && personJob.getPerson().getId()==0
            //&& personJob.getJob().getId()==0){
            return;
        }

        if(personJob.getId()!=0 && personJob.getJob().getId()==0){
            jobService.add(personJob.getJob());

        } else if (personJob.getId()!=0 && personJob.getPerson().getId()==0) {
            personService.add(personJob.getPerson());
        }

        personJobRepository.update(personJob);
    }

    @Override
    public void delete(Long id) {

        if(id == 0) {
            return;
        }
        deletePersonJob(get(id));
    }

    private void deletePersonJob(PersonJob personJob) {

        if(personJobRepository.read(PersonJob.class, personJob.getId()) == null) {
            return;
        }
        personJobRepository.delete(PersonJob.class, personJob.getId());
    }
}
