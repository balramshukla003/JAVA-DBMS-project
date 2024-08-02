import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

public class ShowData_UR extends JFrame{

    public JButton btnRetrieve, btnDelete, btnBack;
    public JTable dataTable;
    public DefaultTableModel tableModel;
    String ID;
    public ShowData_UR(String id) {

        ID=id;
        setTitle("Student Data Showing");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnRetrieve = new JButton("Show Data");
        btnDelete = new JButton("Delete Data");
        btnBack = new JButton("Back");

        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retrieveDataFromDatabase();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Admin_Logged_IN Ad = new Admin_Logged_IN(ID);
                Ad.setVisible(true);
            }});

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Invoke delete");
                setVisible(false);
                DeleteData_UR awtFrame = new DeleteData_UR(ID);
                awtFrame.setVisible(true);
                System.out.println("DeInvoke delete");
            }
        });

        tableModel = new DefaultTableModel(
                new Object[][]{},
                new Object[]{"Name", "User_ID", "Password",}   // Column names
        );
        dataTable = new JTable(tableModel);
        dataTable.setFont(new Font("Book Antica",Font.PLAIN,15));

        JPanel buttonPanel = new JPanel();
        btnRetrieve.setBounds(200,300,65,35);
        buttonPanel.add(btnRetrieve);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnBack);

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(dataTable), BorderLayout.CENTER);

        setVisible(true);
    }

    public void retrieveDataFromDatabase() {

        String url = "jdbc:mysql://localhost:3306/login";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM logindetail";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                tableModel.setRowCount(0);

                while (resultSet.next()) {
                    Object[] rowData = {

                            resultSet.getString("Name"),
                            resultSet.getString("User_ID"),
                            resultSet.getString("Password"),


                    };
                    tableModel.addRow(rowData);
                }
                tableModel.fireTableDataChanged();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving data from the database.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShowData_UR("");
            }
        });
    }
}
