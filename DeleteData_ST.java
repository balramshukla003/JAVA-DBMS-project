import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class DeleteData_ST extends Frame implements ActionListener {
    TextField searchField;

    Label search,error;
    Button deleteButton,closeButton,clearButton,backButton;
    String b,id;
    DeleteData_ST(String a,String Id) {

        id=Id;
        b=a;


        setTitle("Deleting Data Of Student");
        setSize(500, 250);
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        setLayout(null);

        search=new Label("Enter Student_ID to Delete");
        search.setFont(new Font("Book Antiqua",Font.BOLD,18));
        search.setForeground(new Color(0x650529));
        search.setBounds(115,80,300,25);
        add(search);

        searchField = new TextField();
        searchField.setBounds(199,115,150,25);
        searchField.setFont(new Font("arial",Font.BOLD,14));
        add(searchField);

        clearButton = new Button("Clear");
        clearButton.setBounds(325,170,65,25);
        clearButton.setForeground(new Color(0x628328));
        clearButton.setFont(new Font("arial",Font.BOLD,14));
        add(clearButton);
        clearButton.addActionListener(this);

        backButton = new Button("Back");
        backButton.setBounds(325,200,65,25);
        backButton.setForeground(new Color(0x1C020B));
        backButton.setFont(new Font("arial",Font.BOLD,14));
        add(backButton);
        backButton.addActionListener(this);

        deleteButton = new Button("Delete");
        deleteButton.setBounds(395,170,65,25);
        deleteButton.setForeground(new Color(0xE83232));
        deleteButton.setFont(new Font("arial",Font.BOLD,14));
        add(deleteButton);
        deleteButton.addActionListener(this);

        closeButton = new Button("Close");
        closeButton.setBounds(395,200,65,25);
        closeButton.setFont(new Font("arial",Font.BOLD,14));
        closeButton.setForeground(new Color(0x0C2A48));
        add(closeButton);
        closeButton.addActionListener(this);

        error=new Label("");
        error.setFont(new Font("arial",Font.ITALIC,12));
        error.setForeground(new Color(0xF12121));
        error.setBounds(197,139,800,25);
        add(error);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getActionCommand().equals("Close")){
            System.exit(0);
        }

        if(ae.getActionCommand().equals("Back")){
            setVisible(false);
            new ShowData_ST(b,id);
        }

        if(ae.getActionCommand().equals("Clear")){
            searchField.setText("");
            error.setText("");
        }


        if (ae.getSource() == deleteButton) {
            String idToDelete = searchField.getText();
            deleteData(idToDelete);
        }
    }

    public void deleteData(String idToDelete) {

        String url = "jdbc:mysql://localhost:3306/balramshukla";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            String deleteQuery = "DELETE FROM studentinfo WHERE Student_ID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setString(1, idToDelete);

                int rowsAffected = preparedStatement.executeUpdate();

                if(searchField.getText().equals("")) {

                    error.setText("Please Enter valid ID");
                }else
                {
                    if (rowsAffected > 0) {
                       // error.setText("Deleted Successfully");
                        searchField.setText("");
                        error.setText("");
                        new deleteDialogueBox("Student",id,b);
                    } else {
                        error.setText("Data Not Found ");
                        searchField.setText("");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DeleteData_ST deleteExample = new DeleteData_ST("","");
        deleteExample.setVisible(true);
    }
}
