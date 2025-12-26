package net.moncef.inventoryservice.web;


import net.moncef.inventoryservice.Entities.Product;
import net.moncef.inventoryservice.repos.ProductRepo;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping ("/auth")
    public  Authentication authentication (Authentication authentication) {
        return  authentication ;
    }












}
