package be.intecbrussel.model;
import jakarta.persistence.*;

@Entity
public class PersonJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Job job;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Person person;
    private double salary;

    protected PersonJob(){

    }

    public PersonJob(Job job, Person person, double salary){
        this.job = job;
        this.person = person;
        this.salary=salary;
    }

    public long getId() {
        return id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PersonJob{" +
                "id=" + id +
               // ", job=" + job +
                ", person=" + person +
                ", salary=" + salary +
                '}';
    }
}
