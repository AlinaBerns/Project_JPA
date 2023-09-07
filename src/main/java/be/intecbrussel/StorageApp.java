package be.intecbrussel;

import be.intecbrussel.model.*;
import be.intecbrussel.service.entities.*;
import be.intecbrussel.service.implementations.*;

public class StorageApp {
    public static void main(String[] args) {

        Product p1 = new Product("Apple", 1.50, 2.75);
        Product p2 = new Product("Potato is now a fruit", 0.95, 0.50);
        Product p3 = new Product("Banana", 3.60, 4.50);
        Product p4 = new Product("Train", 50, 60);

        Storage s1 = new Storage("Fruits And Trains");
        s1.add(p1,p2,p3,p4);

        Product pp1 = new Product("a",1,1);
        Product pp2 = new Product("b",1,1);
        Product pp3 = new Product("c",1,1);

        Storage s2 = new Storage("oops");
        s2.add(pp1,pp2,pp3);

        Person person = new Person("Jean-Bon");
        person.setFavoriteStorage(s1);

        Person person1 = new Person("Jean-tille");
        person1.setFavoriteStorage(s1);

        Person person2 = new Person("Jean-Neymar");
        person2.setFavoriteStorage(s2);

        Key key = new Key();
        key.setStorage(s2);

        Job job = new Job("Java Developer", "Develop in java");
        //job.getEmployees().add(person2);

        IProductService productService = Service.getProductService();
        IStorageService storageService = Service.getStorageService();
        IPersonService personService = Service.getPersonService();
        IKeyService keyService = Service.getKeyService();
        IJobService jobService = Service.getJobService();

        keyService.add(key);

        s2.setName("Someone forgot to merge");

        keyService.update(key);

        personService.add(person2);

        Key dbKey = keyService.get(1L);
        System.out.println(dbKey);

        Person dbPerson = personService.get(1L);
        System.out.println(dbPerson);

        //storageService.delete(s2.getId());
        jobService.add(job);

        job.setJobTitle("C# developer");
        job.setJobDescription("Develop in C#");

        jobService.update(job);

        //jobService.delete(1L);

        Job dbJob = jobService.get(1L);
        System.out.println(dbJob);

        Key key1 = new Key();
        key1.setStorage(s1);

        Job job1 = new Job("Butcher", "Makes JeanBons");

        PersonJob jeanbonsCutsOfJeanBons = new PersonJob(job1, person, 5000.0);

        job1.getEmployees().add(jeanbonsCutsOfJeanBons);
        person.getJobs().add(jeanbonsCutsOfJeanBons);

        jobService.add(job1);

        job1 = jobService.get(job1.getId());
        jobService.update(job1);

        PersonJob personJob = new PersonJob(job, person1, 4000.0);
        PersonJobService personJobService = new PersonJobService();
        personJobService.add(personJob);
        personJobService.add(personJob);

        System.out.println(personJobService.get(1L));

        Person person3 = new Person("Ron");
        personJob.setPerson(person3);
        personJobService.update(personJob);

        personJobService.delete(1L);

        personService.delete(3L);

        jobService.delete(1L);
        jobService.delete(1L);

    }
}