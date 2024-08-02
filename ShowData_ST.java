import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

public class ShowData_ST extends JFrame{

    public JButton btnRetrieve, btnDelete, btnBack;
    public JTable dataTable;
    public DefaultTableModel tableModel;
    String b,ID;
    public ShowData_ST(String a,String id) {

        ID=id;
        b=a;

        setTitle("Student Data Showing");
        setSize(1000, 300);
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

                if(Objects.equals(b, "Admin")){
                    setVisible(false);
                    Admin_Logged_IN Ad=new Admin_Logged_IN(ID);
                    Ad.setVisible(true);
                }
                if(Objects.equals(b, "User")){
                    setVisible(false);
                    User_Logged_IN Ad=new User_Logged_IN("User",ID);
                    Ad.setVisible(true);
                }

            }});

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Invoke delete");
                setVisible(false);
                DeleteData_ST awtFrame = new DeleteData_ST(b,ID);
                awtFrame.setVisible(true);
                System.out.println("DeInvoke delete");
            }
        });

        tableModel = new DefaultTableModel(
                new Object[][]{},
                new Object[]{"Name", "FName", "Student_ID", "Age", "Gender", "Course", "City", "Address"}
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

        String url = "jdbc:mysql://localhost:3306/balramshukla";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM studentinfo";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                tableModel.setRowCount(0);

                while (resultSet.next()) {
                    Object[] rowData = {

                            resultSet.getString("Name"),
                            resultSet.getString("FName"),
                            resultSet.getString("Student_ID"),
                            resultSet.getString("Age"),
                            resultSet.getString("Gender"),
                            resultSet.getString("Course"),
                            resultSet.getString("City"),
                            resultSet.getString("Address"),


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
                new ShowData_ST("","");
            }
        });
    }
}
