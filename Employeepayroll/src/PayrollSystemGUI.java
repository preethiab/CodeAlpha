import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayrollSystemGUI extends JFrame {
    private PayrollSystem payrollSystem;
    private JTextArea employeeListArea;
    private JTextField idField, nameField, positionField, hourlyRateField, hoursWorkedField;

    public PayrollSystemGUI() {
        super("Employee Payroll System");
        this.payrollSystem = new PayrollSystem();

        // Initialize GUI components
        idField = new JTextField(10);
        nameField = new JTextField(20);
        positionField = new JTextField(15);
        hourlyRateField = new JTextField(10);
        hoursWorkedField = new JTextField(10);
        employeeListArea = new JTextArea(10, 30);
        employeeListArea.setEditable(false);

        JButton addButton = new JButton("Add Employee");
        JButton calculateButton = new JButton("Calculate Salary");

        // Layout
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        inputPanel.add(new JLabel("Employee ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Position:"));
        inputPanel.add(positionField);
        inputPanel.add(new JLabel("Hourly Rate:"));
        inputPanel.add(hourlyRateField);
        inputPanel.add(new JLabel("Hours Worked:"));
        inputPanel.add(hoursWorkedField);
        inputPanel.add(addButton);
        inputPanel.add(calculateButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(employeeListArea), BorderLayout.CENTER);

        // Event listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String position = positionField.getText();
                double hourlyRate = Double.parseDouble(hourlyRateField.getText());

                Employee1 employee = new Employee1(id, name, position, hourlyRate);
                payrollSystem.addEmployee(employee);
                updateEmployeeListArea();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
                StringBuilder result = new StringBuilder();

                for (Employee1 emp : payrollSystem.getEmployees()) {
                    double salary = payrollSystem.calculateSalary(emp, hoursWorked);
                    result.append(emp.getName()).append(" - Salary: $").append(salary).append("\n");
                }

                JOptionPane.showMessageDialog(null, result.toString(), "Payroll Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateEmployeeListArea() {
        employeeListArea.setText("");
        for (Employee1 emp : payrollSystem.getEmployees()) {
            employeeListArea.append(emp.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PayrollSystemGUI();
            }
        });
    }
}
