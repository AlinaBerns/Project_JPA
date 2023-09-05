package be.intecbrussel.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    private Storage favoriteStorage;

    protected Person () {

    }

    public Person(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Storage getFavoriteStorage() {
        return favoriteStorage;
    }

    public void setFavoriteStorage(Storage favoriteStorage) {
        this.favoriteStorage = favoriteStorage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && Objects.equals(getName(), person.getName()) && Objects.equals(getFavoriteStorage(), person.getFavoriteStorage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFavoriteStorage());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", favoriteStorage=" + favoriteStorage +
                '}';
    }
}
