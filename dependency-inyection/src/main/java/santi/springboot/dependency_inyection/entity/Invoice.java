package santi.springboot.dependency_inyection.entity;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Invoice {


    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    @Autowired
    private List<Item> items;

    //this method has the main difference with the constructor in the fact that it is executed after the creation of the bean
    //that means that we have available all the objects injected
    @PostConstruct
    public void init(){
       client.setName(client.getLastname().concat(" modificado"));

    }

    @PreDestroy
    public void destroy(){
        System.out.println("destruyendo el componente Bean invoice");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getTotal(){
       Integer total = 0;
       for(Item item : items){
           total += item.getImporte();
       }
       return total;
    }
}
