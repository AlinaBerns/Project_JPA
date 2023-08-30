package be.intecbrussel;

import be.intecbrussel.model.*;
import be.intecbrussel.repository.IProductRepository;
import be.intecbrussel.repository.ProductRepository;
import be.intecbrussel.service.IProductService;
import be.intecbrussel.service.ProductService;

public class StorageApp {
    public static void main(String[] args) {
        Product p1 = new Product("Apple", 1.00, 1.5);
        Product p2 = new Product("Potato", 2.00, 2.5);
        Product p3 = new Product("Tomato", 3.00, 3.5);
        Product p4 = new Product("Banana", 4.00, 4.5);

        Storage s1 = new Storage("Fruits & vegetables");
        s1.add(p1, p2, p3, p4);

        IProductService productService = new ProductService();

        //ADD PRODUCT
        productService.addProduct(p1);
        productService.addProduct(p2);
        productService.addProduct(p3);
        productService.addProduct(p4);

        //READ PRODUCT
        productService.getProduct(3);

        //UPDATE PRODUCT
        productService.updateProduct(4, "GreenApple");

        //REMOVE PRODUCT
        productService.deleteProduct(1);


    }
}
