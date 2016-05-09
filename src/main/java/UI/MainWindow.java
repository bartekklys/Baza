package UI;

import Entities.*;
import DatabaseManager.CreateEmployee;
import DatabaseManager.DeleteEmployee;
import DatabaseManager.UpdateEmployee;
import Entities.Address;
import Entities.Employee;
import Entities.Phone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{
    private JPanel main;
    private JTextField tfName;
    private JTextField tfSurname;
    private JTextField tfSalary;
    private JButton addButton;
    private JButton deleteButton;
    private JTextField tfEID;
    private JButton updateButton;
    private JTextField tfNumber;
    private JComboBox cbCategory;
    private JTextField tfStreet;
    private JTextField tfCity;
    private JTextField tfPostCode;
    private final int width = 700;
    private final int height = 450;


    public MainWindow() {

        setSize(width,height);
        setContentPane(main);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cbCategory.setModel(new DefaultComboBoxModel(Category.values()));

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = tfName.getText();
                String surname = tfSurname.getText();
                int salary = Integer.parseInt(tfSalary.getText());
                String street = tfStreet.getText();
                String city = tfCity.getText();
                String postCode = tfPostCode.getText();
                String number = tfNumber.getText();
                String value = cbCategory.getSelectedItem().toString();

                CreateEmployee createEmployee = new CreateEmployee();
                createEmployee.addEmployee(new Employee(name, surname, salary, new Address(street, city, postCode), new Phone(number, value)));

                tfName.setText("");
                tfSurname.setText("");
                tfSalary.setText("");
                tfStreet.setText("");
                tfCity.setText("");
                tfPostCode.setText("");
                tfNumber.setText("");
                cbCategory.setSelectedIndex(0);

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tfEID.getText());

                DeleteEmployee deleteEmployee = new DeleteEmployee();
                deleteEmployee.deleteEmployee(id);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tfEID.getText());
                String name = tfName.getText();
                String surname = tfSurname.getText();
                int salary = Integer.parseInt((tfSalary.getText()));

                UpdateEmployee update = new UpdateEmployee();
                update.updateEmployee(id, name, surname, salary);
            }
        });
    }

    public static void main(String[] args) {

        MainWindow mw = new MainWindow();

    }
}