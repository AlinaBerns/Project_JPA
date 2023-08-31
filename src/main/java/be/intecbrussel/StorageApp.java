package be.intecbrussel;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.*;
import be.intecbrussel.repository.IProductRepository;
import be.intecbrussel.repository.ProductRepository;
import be.intecbrussel.repository.StorageRepository;
import be.intecbrussel.service.IProductService;
import be.intecbrussel.service.ProductService;
import be.intecbrussel.service.StorageService;
import jakarta.persistence.EntityManager;

public class StorageApp {
    public static void main(String[] args) {
        Product p1 = new Product("Apple", 1.00, 1.5);
        Product p2 = new Product("Potato", 2.00, 2.5);
        Product p3 = new Product("Tomato", 3.00, 3.5);
        Product p4 = new Product("Banana", 4.00, 4.5);

        IProductService productService = new ProductService();
        Storage s1 = new Storage("Fruits & vegetables");

        productService.addProduct(p1);
        productService.addProduct(p2);
        productService.addProduct(p3);
        productService.addProduct(p4);

        StorageService service = new StorageService();

        //Create Storage Entity
        s1.add(p1, p2, p3, p4);
        service.addStorage(s1);

        //READ PRODUCT
        //productService.getProduct(3);

        //UPDATE PRODUCT
        //productService.updateProduct(2, "GreenApple");
        //productService.getProduct(2);

        //REMOVE PRODUCT
        //productService.deleteProduct(1);

        StorageService storageService = new StorageService();

        //READ STORAGE
        storageService.getStorage(1);

        //UPDATE STORAGE
        storageService.updateStorage(1, "UPDATE_Fruits & vegetables");
        storageService.getStorage(1);

        //DELETE STORAGE
        storageService.deleteStorage(1);
    }
}
