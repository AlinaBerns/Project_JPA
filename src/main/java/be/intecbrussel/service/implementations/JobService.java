package be.intecbrussel.service.implementations;

import be.intecbrussel.model.Job;
import be.intecbrussel.model.Person;
import be.intecbrussel.model.PersonJob;
import be.intecbrussel.repository.entities.IJobRepository;
import be.intecbrussel.repository.entities.IPersonJobRepository;
import be.intecbrussel.repository.implementations.JobRepository;
import be.intecbrussel.repository.implementations.PersonJobRepository;
import be.intecbrussel.service.entities.IJobService;
import be.intecbrussel.service.entities.IPersonJobService;
import be.intecbrussel.service.entities.IPersonService;

import java.util.List;

public class JobService implements IJobService {
    private IJobRepository jobRepository = new JobRepository();
    protected IPersonService personService = Service.getPersonService();
    protected IPersonJobService personJobService = Service.getPersonJobService();

    @Override
    public void add(Job job) {
        if (job.getId() != 0) {
            update(job);
        }

        for (PersonJob employee : job.getEmployees()) {
            if (employee.getId() == 0) {
                personService.add(employee.getPerson());
            } else {
                personService.update(employee.getPerson());
            }
        }

        jobRepository.create(job);
    }

    @Override
    public Job get(Long id) {
        return jobRepository.read(Job.class, id);
    }

    @Override
    public void update(Job job) {
        for (PersonJob employee : job.getEmployees()) {
            if (employee.getId() == 0) {
                personService.add(employee.getPerson());
            }
        }
        jobRepository.update(job);
    }

    @Override
    public void delete(Long id) {
        if(get(id) == null){
            return;
        }
        jobRepository.delete(Job.class, id);
    }

    @Override
    public void deletePersonFromJob(Person person) {
        List<Job> jobs = jobRepository.readJobs(person);

        for (Job job : jobs) {
            job.getEmployees().remove(person);
            update(job);
        }
    }
}
