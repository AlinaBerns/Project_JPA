package be.intecbrussel.model;
import jakarta.persistence.*;

@Entity
public class PersonJob {
   /* @EmbeddedId
    private PersonJobId id;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(cascade = CascadeType.MERGE)
    //@MapsId("jobId")
    private Job job;

    @ManyToOne(cascade = CascadeType.MERGE)
    //@MapsId("personId")
    private Person person;
    private double salary;

    protected PersonJob(){

    }

    public PersonJob(Job job, Person person, double salary){
        this.job = job;
        this.person = person;
        this.salary=salary;
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

    public long getId() {
        return id;
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

   /* @Embeddable
    private static class PersonJobId  {
        private long jobId;
        private long personId;

        public PersonJobId(long jobId, long personId){
            this.jobId = jobId;
            this.personId = personId;
        }

        public PersonJobId(){}
    }*/
}
