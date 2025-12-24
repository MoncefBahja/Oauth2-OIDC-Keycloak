package net.moncef.inventoryservice;

import net.moncef.inventoryservice.Entities.Product;
import net.moncef.inventoryservice.repos.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner (ProductRepo productRepo){
      return args -> {

          productRepo.save(Product.builder()
                  .id(UUID.randomUUID().toString())
                  .name("computer")
                  .price(1234)
                  .quantity(12)
                  .build()) ;
          productRepo.save(Product.builder().name("SMART")
                  .id(UUID.randomUUID().toString())
                  .price(2223)
                  .quantity(25)
                  .build()) ;
          productRepo.save(Product.builder().name("PRINTER")
                  .id(UUID.randomUUID().toString())
                  .price(6666)
                  .quantity(20)
                  .build()) ;
      };
    }


}
