import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminController extends JFrame {

    public JFrame frame;
    Graphics g;

    public adminController() {

        frame = new JFrame("Admin Controller");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setVisible(true);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\BalramShukla\\IdeaProjects\\Project\\src\\resize-17041228491128497078JPG.jpg"); // Replace with the actual path to your image

        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(50, 80, 200, 150);
        frame.add(imageLabel);





        JLabel welcomeLabel = new JLabel("Welcome to Admin Controller Window..!");
        welcomeLabel.setBounds(50, 35, 3560, 25);
        welcomeLabel.setFont(new Font("Book Antique", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(0x650529));
        frame.add(welcomeLabel);



        JButton manageUsersButton = new JButton("Manage Users");
        manageUsersButton.setBounds(275, 150, 150, 25);
        manageUsersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                JOptionPane.showMessageDialog(frame, "Manage Users functionality goes here!");
            }
        });
        frame.add(manageUsersButton);



        JButton showUsersButton = new JButton("Show Users");
        showUsersButton.setBounds(275, 120, 150, 25);

        showUsersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.setVisible(false);
                new showUsersControl();

            }
        });
        frame.add(showUsersButton);


        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(275, 180, 80, 25);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Login awt = new Login();
                awt.setVisible(true);
            }
        });
        frame.add(logoutButton);



        ImageIcon icon = new ImageIcon("C:\\Users\\BalramShukla\\IdeaProjects\\Project\\src\\picture.jpg");
        frame.setIconImage(icon.getImage());

    }
    public static void main(String[] args) {
                new adminController();
    }

}
