import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class ToDoApp extends JFrame {

    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInputField;

    public ToDoApp() {
        setTitle("To-Do List App");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));


        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);


        JPanel inputPanel = new JPanel(new BorderLayout());

        taskInputField = new JTextField();
        taskInputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputPanel.add(taskInputField, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Task");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(addButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);


        JButton deleteButton = new JButton("Delete Selected");
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(deleteButton, BorderLayout.SOUTH);


        addButton.addActionListener(e -> {
            String task = taskInputField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInputField.setText(""); // Clear input
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a task.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });


        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a task to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoApp().setVisible(true);
        });
    }
}