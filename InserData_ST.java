import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Objects;

public class InserData_ST extends Frame implements ActionListener, WindowListener, ItemListener,TextListener,KeyListener {
    Label lblTitle, lblName, lblFather, lblStudentId, lblAge, lblGender, lblCourse, lblCity, lblAddress, l,d;
    TextField txtName, txtFather, txtStudentId, txtAge, txtCity;
    TextArea txtAddress;
    Checkbox checkMale, checkFemale;
    CheckboxGroup cbg;
    Choice Course;
    Button btnSave, btnClear, back, close;
    String name = "", FName = "", adds = "", gen = "", cou = "", age = "", stid = "", city = "", b,Id;
    Frame r=new Frame();
    InserData_ST(String a,String id) {

        b = a;
        Id=id;

        setTitle("Student Form");
        setVisible(true);
        setLayout(null);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setBackground(new Color(0xEADFC1));
        addWindowListener(this);

        Font labelFont = new Font("arial", Font.PLAIN, 18);
        Font textFont = new Font("arial", Font.PLAIN, 15);

        lblTitle = new Label("Student Registration Form");
        lblTitle.setBounds(300, 70, 350, 45);
        lblTitle.setFont(new Font("arial", Font.BOLD, 25));
        lblTitle.setForeground(new Color(0x44041C));
        add(lblTitle);

        lblName = new Label("Name :");
        lblName.setBounds(150, 150, 100, 30);
        lblName.setFont(new Font("Arial", Font.PLAIN, 20));
        lblName.setForeground(new Color(0x650529));
        add(lblName);
        txtName = new TextField();
        txtName.setBounds(300, 150, 400, 25);
        txtName.setFont(textFont);
        add(txtName);


        lblFather = new Label("Father Name :");
        lblFather.setBounds(150, 190, 120, 30);
        lblFather.setForeground(new Color(0x650529));
        lblFather.setFont(labelFont);
        add(lblFather);
        txtFather = new TextField();
        txtFather.setBounds(300, 190, 400, 25);
        txtFather.setFont(textFont);
        add(txtFather);

        lblStudentId = new Label("Student ID:");
        lblStudentId.setBounds(150, 230, 150, 30);
        lblStudentId.setFont(labelFont);
        add(lblStudentId);
        txtStudentId = new TextField();
        txtStudentId.setBounds(300, 230, 400, 25);
        txtStudentId.setFont(textFont);
        add(txtStudentId);

        lblAge = new Label("Age :");
        lblAge.setBounds(150, 270, 150, 30);
        lblAge.setFont(labelFont);
        add(lblAge);
        txtAge = new TextField();
        txtAge.setBounds(300, 270, 400, 25);
        txtAge.setFont(textFont);
        add(txtAge);
        txtAge.addTextListener(this);
        txtAge.addKeyListener(this);

        lblGender = new Label("Gender :");
        lblGender.setBounds(150, 310, 150, 30);
        lblGender.setFont(labelFont);
        add(lblGender);

        cbg = new CheckboxGroup();

        checkMale = new Checkbox("Male", cbg, false);
        checkMale.setBounds(300, 310, 100, 25);
        checkMale.setFont(labelFont);
        add(checkMale);
        checkMale.addItemListener(this);

        checkFemale = new Checkbox("Female", cbg, false);
        checkFemale.setBounds(400, 310, 100, 25);
        checkFemale.setFont(labelFont);
        add(checkFemale);
        checkFemale.addItemListener(this);

        lblCourse = new Label("Course");
        lblCourse.setBounds(150, 350, 150, 30);
        lblCourse.setFont(new Font("arial", Font.PLAIN, 15));
        add(lblCourse);

        Course = new Choice();
        Course.setFont(new Font("arial", Font.PLAIN, 15));
        Course.setBounds(300, 350, 400, 50);
        Course.add("Select");
        Course.add("BCA");
        Course.add("BBA");
        Course.add("CCC");
        Course.add("O'Level");
        Course.add("B'Level");
        add(Course);
        Course.addItemListener(this);

        lblCity = new Label("City");
        lblCity.setBounds(150, 390, 150, 30);
        lblCity.setFont(labelFont);
        add(lblCity);
        txtCity = new TextField();
        txtCity.setBounds(300, 390, 400, 25);
        txtCity.setFont(textFont);
        add(txtCity);
        txtCity.addTextListener(this);

        lblAddress = new Label("Address");
        lblAddress.setBounds(150, 430, 150, 30);
        lblAddress.setFont(labelFont);
        add(lblAddress);
        txtAddress = new TextArea(10, 30);
        txtAddress.setBounds(300, 430, 400, 70);
        txtAddress.setFont(new Font("arial", Font.PLAIN, 15));
        add(txtAddress);

        btnSave = new Button("Save Data");
        btnSave.setBounds(150, 570, 100, 30);
        btnSave.setFont(new Font("Arial", Font.BOLD, 15));
        btnSave.setForeground(new Color(0x0F12A6));
        add(btnSave);
        btnSave.addActionListener(this);

        btnClear = new Button("Clear All");
        btnClear.setBounds(295, 570, 100, 30);
        btnClear.setFont(new Font("Arial", Font.BOLD, 15));
        btnClear.setForeground(new Color(0x10B60B));
        add(btnClear);
        btnClear.addActionListener(this);

        back = new Button("Back");
        back.setBounds(455, 570, 100, 30);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.setForeground(new Color(0xA6210F));
        add(back);
        back.addActionListener(this);

        close = new Button("Close");
        close.setBounds(600, 570, 100, 30);
        close.setFont(new Font("Arial", Font.BOLD, 15));
        close.setForeground(new Color(0xA6210F));
        add(close);
        close.addActionListener(this);

        l = new Label("");
        l.setFont(new Font("Arial", Font.ITALIC, 15));
        l.setForeground(Color.RED);
        l.setBounds(300, 520, 250, 20);
        add(l);
    }


    public static void main(String[] args) {
        InserData_ST s=new InserData_ST("","");
    }








    @Override
    public void itemStateChanged(ItemEvent e) {

        cou = (String) e.getItem();
        System.out.println(cou);

        if (e.getItem().equals("Male")) {
            gen = "Male";
        } else if (e.getItem().equals("Female")) gen = "Female";

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Clear All")) {
            txtName.setText("");
            txtAge.setText("");
            txtAddress.setText("");
            txtFather.setText("");
            txtStudentId.setText("");
            txtCity.setText("");
            checkFemale.setState(false);
            checkMale.setState(false);
            Course.select("Select");
            l.setText("");
        }

        if (e.getActionCommand().equals("Back")) {

            if (Objects.equals(b, "Admin")) {
                setVisible(false);
                new Admin_Logged_IN(Id);
            } else if (Objects.equals(b, "User")) {
                setVisible(false);
                new User_Logged_IN("User",Id);
            } else {
                setVisible(false);
                new Login();
            }

        }

        if (e.getActionCommand().equals("Close")) {
            System.exit(0);
        }

        if (e.getActionCommand().equals("Save Data")) {

            name = txtName.getText();
            FName = txtFather.getText();
            age = txtAge.getText();
            adds = txtAddress.getText();
            stid = txtStudentId.getText();
            city = txtCity.getText();


            r.setTitle("Dialogue Box");
            r.setSize(330, 150);
            r.setLayout(null);
            r.setBackground(Color.LIGHT_GRAY);
            r.setLocationRelativeTo(null);
            r.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    r.setVisible(false);
                }
            });
            d = new Label("");
            d.setBounds(60, 68, 350, 35);
            d.setFont(new Font("Segue UI", Font.BOLD, 17));
            d.setForeground(new Color(0x980F0F));
            r.add(d);


            if ((Objects.equals(name, "")) || (Objects.equals(FName, "")) || (Objects.equals(age, "")) || (Objects.equals(adds, "")) || (Objects.equals(cou, "")) || (Objects.equals(gen, "")) || (Objects.equals(stid, "")) || (Objects.equals(city, ""))) {

                d.setText("Data Added Successfully");
                r.setVisible(true);

            }
            else {
                int intValue = Integer.parseInt(age);

                if (intValue == 0) {

                    l.setText("Age Should Be Greater than 0....!");

                }
                else {
                    System.out.println("Connection");
                    try {

                        String url = "jdbc:mysql://localhost:3306/balramshukla";
                        String username = "root";
                        String dbPassword = "";

                        try (Connection connection = DriverManager.getConnection(url, username, dbPassword)) {

                            String sqlQuery = "SELECT Name FROM studentinfo WHERE Student_ID = ?";

                            try (PreparedStatement selectStatement = connection.prepareStatement(sqlQuery)) {
                                selectStatement.setString(1, stid);


                                try (ResultSet rs = selectStatement.executeQuery()) {
                                    if (rs.next()) {
                                        d.setText("Student Data Exists With Same ID");
                                        r.setVisible(true);
                                    }
                                    else {

                                        sqlQuery = "insert into studentinfo(Name, Fname, Student_ID, Age, Gender, Course, City, Address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                                        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                                        preparedStatement.setString(1, name);
                                        preparedStatement.setString(2, FName);
                                        preparedStatement.setString(3, stid);
                                        preparedStatement.setString(4, String.valueOf(age));
                                        preparedStatement.setString(5, gen);
                                        preparedStatement.setString(6, cou);
                                        preparedStatement.setString(7, city);
                                        preparedStatement.setString(8, adds);

                                        System.out.println(name + " " + FName + " " + stid + " " + age + " " + gen + " " + cou + " " + city + " " + adds);

                                        int rowsAffected = preparedStatement.executeUpdate();

                                        if (rowsAffected > 0) {

                                          //  l.setText("Data Added Successfully");
                                            txtName.setText("");
                                            txtAge.setText("");
                                            txtAddress.setText("");
                                            txtFather.setText("");
                                            txtStudentId.setText("");
                                            txtCity.setText("");
                                            checkFemale.setState(false);
                                            checkMale.setState(false);
                                            Course.select("Select");
                                            l.setText("");

                                            new addedDialogueBox(b,Id);
                                            connection.close();

                                        }
                                        else {
                                            d.setText("Data not added");
                                            r.setVisible(true);
                                            connection.close();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception te) {
                        d.setText("Not Connected To Database");
                        r.setVisible(true);
                    }
                }
            }
        }
    }




    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void textValueChanged(TextEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

        char input = e.getKeyChar();

            if (!Character.isDigit(input)) {
                e.consume();
                l.setText("Age Shoud be a Number...!");
            } else l.setText("");
        }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
