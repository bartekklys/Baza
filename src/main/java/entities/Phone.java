package entities;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private String number;
    @Column(name = "category")
    private String category;

    public Phone(){}

    public Phone(String number, String category) {
        this.number = number;
        this.category = category;
    }
}
