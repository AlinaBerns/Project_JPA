package be.intecbrussel;

import be.intecbrussel.model.*;
import be.intecbrussel.service.*;

public class StorageApp {
    public static void main(String[] args) {
        Product p1 = new Product("Apple", 1.00, 1.5);
        Product p2 = new Product("Potato", 2.00, 2.5);
        Product p3 = new Product("Tomato", 3.00, 3.5);
        Product p4 = new Product("Banana", 4.00, 4.5);

        IProductService productService = new ProductService();
        Storage s1 = new Storage("Fruits & vegetables");

        productService.add(p1);
        productService.add(p2);
        productService.add(p3);
        productService.add(p4); //= DEZE WERKT ALS WE GEEN CASCADE.PERSIST HEBBEN, GEBRUIK NOOIT CASCADE.ALL

        //READ PRODUCT
        System.out.println(productService.get(1L));

        //UPDATE PRODUCT
        p1.setName("RED APPLE");
        productService.update(p1);

        System.out.println(productService.get(p1.getId()));


        StorageService service = new StorageService();

        //Create Storage Entity
        s1.add(p1, p2, p3, p4);
        service.add(s1);

        StorageService storageService = new StorageService();

        //READ STORAGE
        System.out.println(storageService.get(1L));

        //UPDATE STORAGE
        s1.setName("upd_FRUITS & VEGETABLES ");
        storageService.update(s1);
        System.out.println(storageService.get(s1.getId()));

        //DELETE STORAGE
        //storageService.delete(Storage.class,1);

        //REMOVE PRODUCT
        productService.delete(p1.getId());

        s1.setName("A bit of everything...");


        //CREATE PERSONS
        Person person = new Person("Jean-Bon");
        person.setFavoriteStorage(s1);

        Person person1 = new Person("Jean-Tille");

        //SET FAVORITE STORAGE
        person1.setFavoriteStorage(s1);

        PersonService personService = new PersonService();

        //ADD PERSON
        personService.add(person);
        personService.add(person1);

        //UPDATE STORAGE
        person1.setName("Ella");
        personService.update(person1);

        //DELETE PERSON
        personService.delete(person1.getId());

        KeyService keyService = new KeyService();
        Key key = new Key();

        //ADD KEY
        keyService.add(key);

        //UPDATE KEY
        key.setStorage(s1);
        keyService.update(key);

        //GET KEY
        keyService.get(key.getId());

        //DELETE KEY
        keyService.delete(1L);

    }
}
