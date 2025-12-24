package net.moncef.inventoryservice.web;


import net.moncef.inventoryservice.Entities.Product;
import net.moncef.inventoryservice.repos.ProductRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    private ProductRepo productRepo ;

    public ProductRestController (ProductRepo productRepo) {
        this.productRepo = productRepo ;
    }

    @GetMapping("/products")
    public List<Product> productList () {
        return  productRepo.findAll() ;
    }
    @GetMapping ("/products/{id}")
    public  Product productById (@PathVariable String id) {

        return productRepo.findById(id).get();
    }












}
