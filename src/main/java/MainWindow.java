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
    private final int width = 700;
    private final int height = 450;


    public MainWindow() {

        setSize(width,height);
        setContentPane(main);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = tfName.getText();
                String surname = tfSurname.getText();
                int salary = Integer.parseInt(tfSalary.getText());

                CreateEmployee employee = new CreateEmployee();
                employee.addEmployee(new Employee(name, surname, salary));

                tfName.setText("");
                tfSurname.setText("");
                tfSalary.setText("");

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
