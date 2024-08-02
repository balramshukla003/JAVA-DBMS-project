import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class showUsersControl extends JFrame {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public showUsersControl() {
        initialize();
        loadDataFromDatabase();
    }

    private void initialize() {

        frame = new JFrame("JTable with Database Data");
        frame.setSize(600, 350);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new adminController();
            }
        });
        frame.add(backButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new  ControlDelete();
            }
        });
        frame.add(deleteButton);

        tableModel = new DefaultTableModel( new Object[][]{},
                new Object[]{"Name", "User_Id", "Password"}
        );

        table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.BOLD, 15));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(580, 350));
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);


        ImageIcon icon = new ImageIcon("C:\\Users\\BalramShukla\\IdeaProjects\\Project\\src\\picture.jpg");
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
    }

    private void loadDataFromDatabase() {

        String url = "jdbc:mysql://localhost:3306/login";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM logindetail";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                tableModel.setRowCount(0);
                while (resultSet.next()) {
                    Object[] row = {
                            resultSet.getString("Name"),
                            resultSet.getString("User_ID"),
                            resultSet.getString("Password"),
                    };
                    tableModel.addRow(row);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new showUsersControl();
            }
        });
    }
}
