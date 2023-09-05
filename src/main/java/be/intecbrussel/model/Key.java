package be.intecbrussel.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "KeyTable") //!!!!!!!!!!!
public class Key {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Storage storage;

    public long getId() {
        return id;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", storage=" + storage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key key)) return false;
        return getId() == key.getId() && Objects.equals(getStorage(), key.getStorage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStorage());
    }
}
