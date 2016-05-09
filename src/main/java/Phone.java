import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Phone {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "number")
    private String number;
    @Column(name = "category")
    private String category;

    public Phone(String number, String category) {
        this.number = number;
        this.category = category;
    }

}
