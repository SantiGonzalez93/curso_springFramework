package santi.springboot.dependency_inyection;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import santi.springboot.dependency_inyection.entity.Item;
import santi.springboot.dependency_inyection.entity.Product;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value = "classpath:data.properties")
public class AppConfig {


    @Bean
    public List<Item> itemInvoice(){

        Product p1 = new Product("Motorola M71", 450);
        Product p2 = new Product("Camara Sony", 800);

        return Arrays.asList(new Item(p1,2), new Item(p2,3));
    }
}
