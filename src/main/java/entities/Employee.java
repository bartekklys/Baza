package entities;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public Employee(){}

    public Employee(String firstName, String lastName, int salary, Address address, Phone phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    public Phone getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "First name: " + firstName + ", Last name: " + lastName + ", Salary: " + salary +
                ", Phone number: " + phone.getNumber() + ", Category: " + phone.getCategory() + ", City: " + address.getCity() + ", Street: " +
                address.getStreet() + ", Post code: " + address.getPostCode();
    }
}