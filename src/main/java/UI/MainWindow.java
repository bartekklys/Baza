package UI;

import databaseManager.ReadEmployee;
import entities.*;
import databaseManager.CreateEmployee;
import databaseManager.DeleteEmployee;

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
    private JTextField tfNumber;
    private JComboBox cbCategory;
    private JTextField tfStreet;
    private JTextField tfCity;
    private JTextField tfPostCode;
    private JButton exitButton;
    private JButton refreshButton;
    private JTextArea textArea;


    public MainWindow() {

        int width = 1400;
        int height = 950;
        setSize(width, height);
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
                String category = cbCategory.getSelectedItem().toString();

                CreateEmployee createEmployee = new CreateEmployee();
                createEmployee.addEmployee(new Employee(name, surname, salary, new Address(street, city, postCode), new Phone(number, category)));

                ReadEmployee readEmployee = new ReadEmployee();
                readEmployee.readEmployee(textArea);

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

                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete record with ID: " + id + " ?");

                if(result == JOptionPane.OK_OPTION){
                    DeleteEmployee deleteEmployee = new DeleteEmployee();
                    deleteEmployee.deleteEmployee(id);
                }
                ReadEmployee readEmployee = new ReadEmployee();
                readEmployee.readEmployee(textArea);

                tfEID.setText("");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReadEmployee readEmployee = new ReadEmployee();
                readEmployee.readEmployee(textArea);
            }
        });
    }

    public static void main(String[] args) {

        MainWindow mainWindow = new MainWindow();

    }
}
