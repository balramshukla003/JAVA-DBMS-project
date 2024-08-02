import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;


public class DeleteData_UR extends Frame implements ActionListener {
    TextField searchField, paasField;

    Label search, error, pass;
    Button deleteButton, closeButton, clearButton, backButton;
    String ID;

    DeleteData_UR(String id) {

        ID=id;

        setTitle("Deleting Data Of User");
        setSize(500, 250);
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        setLayout(null);

        search = new Label("Enter User_ID :");
        search.setFont(new Font("Book Antiqua", Font.BOLD, 17));
        search.setForeground(new Color(0x650529));
        search.setBounds(45, 80, 230, 25);
        add(search);

        pass = new Label("Enter User Password :");
        pass.setFont(new Font("Book Antiqua", Font.BOLD, 17));
        pass.setForeground(new Color(0x650529));
        pass.setBounds(45, 120, 230, 25);
        add(pass);

        searchField = new TextField();
        searchField.setBounds(280, 80, 150, 25);
        searchField.setFont(new Font("arial", Font.BOLD, 14));
        add(searchField);

        paasField = new TextField();
        paasField.setBounds(280, 120, 150, 25);
        paasField.setFont(new Font("arial", Font.BOLD, 14));
        add(paasField);

        clearButton = new Button("Clear");
        clearButton.setBounds(325, 170, 65, 25);
        clearButton.setForeground(new Color(0x628328));
        clearButton.setFont(new Font("arial", Font.BOLD, 14));
        add(clearButton);
        clearButton.addActionListener(this);

        backButton = new Button("Back");
        backButton.setBounds(325, 200, 65, 25);
        backButton.setForeground(new Color(0x1C020B));
        backButton.setFont(new Font("arial", Font.BOLD, 14));
        add(backButton);
        backButton.addActionListener(this);

        deleteButton = new Button("Delete");
        deleteButton.setBounds(395, 170, 65, 25);
        deleteButton.setForeground(new Color(0xE83232));
        deleteButton.setFont(new Font("arial", Font.BOLD, 14));
        add(deleteButton);
        deleteButton.addActionListener(this);

        closeButton = new Button("Close");
        closeButton.setBounds(395, 200, 65, 25);
        closeButton.setFont(new Font("arial", Font.BOLD, 14));
        closeButton.setForeground(new Color(0x0C2A48));
        add(closeButton);
        closeButton.addActionListener(this);

        error = new Label("");
        error.setFont(new Font("arial", Font.ITALIC, 12));
        error.setForeground(new Color(0xF12121));
        error.setBounds(280, 140, 800, 25);
        add(error);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("Close")) {
            System.exit(0);
        }

        if (ae.getActionCommand().equals("Back")) {
            setVisible(false);
            new ShowData_UR(ID);
        }

        if (ae.getActionCommand().equals("Clear")) {
            searchField.setText("");
            paasField.setText("");
            error.setText("");
        }


        if (ae.getSource() == deleteButton) {

            String idToDelete = searchField.getText();
            String Password = paasField.getText();

            if (Objects.equals(Password, "") || Objects.equals(idToDelete, "")) {
                error.setText("No Field Should Empty");
            } else {
                deleteData(idToDelete, Password);
                searchField.setText("");
                paasField.setText("");
            }
        }
    }

    public void deleteData(String idToDelete, String Password) {
        try {
            String url = "jdbc:mysql://localhost:3306/login";
            String username = "root"; // MySQL credentials
            String dbPassword = "";

            try (Connection connection = DriverManager.getConnection(url, username, dbPassword)) {

                String selectSql = "SELECT Name FROM logindetail WHERE User_ID = ? AND Password = ?";

                try (PreparedStatement selectStatement = connection.prepareStatement(selectSql)) {
                    selectStatement.setString(1, idToDelete);
                    selectStatement.setString(2, Password);

                    try (ResultSet rs = selectStatement.executeQuery()) {

                        if (rs.next()) {

                            String nam = rs.getString("Name");
                            if(Objects.equals(nam, "---")) {

                                String deleteSql = "DELETE FROM logindetail WHERE User_ID = ? AND Password = ?";
                                try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
                                    deleteStatement.setString(1, idToDelete);
                                    deleteStatement.setString(2, Password);
                                    int rowsAffected = deleteStatement.executeUpdate();
                                   // error.setText("Deleted Successfully");
                                    searchField.setText("");
                                    paasField.setText("");
                                    error.setText("");
                                    new deleteDialogueBox("User",ID,"");
                                }
                            }
                            else{
                                error.setText("!..Can't Delete it is an Admin Id");
                            }
                        }
                        else{
                            error.setText("Invalid user or password.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
           error.setText("No Connection With DB");
        }
    }


    public static void main(String[] args) {
        DeleteData_UR deleteExample = new DeleteData_UR("");
        deleteExample.setVisible(true);
    }
}


