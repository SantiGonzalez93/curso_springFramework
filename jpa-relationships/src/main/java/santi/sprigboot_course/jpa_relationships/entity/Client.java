package santi.sprigboot_course.jpa_relationships.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;

    //The cascade annotation means that when you create a client, the address will also be created
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private List<Address> addreses;

    public Client() {
    this.addreses = new ArrayList<>();

    }
    public Client(String name, String lastname) {
        this();
        this.name = name;
        this.lastname = lastname;
    }

    public List<Address> getAddreses() {
        return addreses;
    }

    public void setAddreses(List<Address> addreses) {
        this.addreses = addreses;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", addreses=" + addreses +
                '}';
    }
}
