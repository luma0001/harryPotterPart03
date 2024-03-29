package kea.exersice.harrypotter003.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import org.springframework.data.annotation.Id;
import jakarta.persistence.Id;

import java.util.Arrays;
import java.util.List;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @jakarta.persistence.Id
    private int id;

    private String name;
    private String founder;

    @ElementCollection
    private List<String> colors;

    public House(String name, String founder, List<String>  colors) {
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public House() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}