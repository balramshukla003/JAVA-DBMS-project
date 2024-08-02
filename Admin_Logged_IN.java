import java.awt.*;
import java.awt.event.*;

public class Admin_Logged_IN extends Frame implements ActionListener, WindowListener, MouseListener {

    String A="Admin",id;
    Button b1,b2,b3,b4,lgot,close;
   Admin_Logged_IN(String a) {
       id=a;

       setTitle("Admin LoggedIn Dashboard");
       setVisible(true);
       setLayout(null);
       setSize(600, 400);
       setLocationRelativeTo(null);
       setResizable(false);
       addWindowListener(this);
       setBackground(new Color(0xC1B1D2));

       Label l = new Label("Administrator Controlling Dashboard Panel");
       l.setBounds(55, 60, 550, 35);
       l.setFont(new Font("", Font.BOLD, 25));
       l.setForeground(new Color(0x4F1006));
       add(l);

       Label st = new Label("Students Information");
       st.setBounds(105, 135, 200, 30);
       st.setFont(new Font("", Font.PLAIN, 20));
       st.setForeground(new Color(0x650529));
       add(st);

       b1 = new Button("Add");
       b1.setBounds(145, 200, 80, 25);
       b1.setFont(new Font("Book Antiqua", Font.BOLD, 15));
       b1.setForeground(new Color(0x0C3A80));
       add(b1);
       b1.addActionListener(this);

       b2 = new Button("Show");
       b2.setBounds(145, 250, 80, 25);
       b2.setFont(new Font("Book Antiqua", Font.BOLD, 15));
       b2.setForeground(new Color(0x0C3A80));
       add(b2);
       b2.addActionListener(this);


       Label ur = new Label("Users Information");
       ur.setBounds(340, 135, 200, 30);
       ur.setFont(new Font("", Font.PLAIN, 20));
       ur.setForeground(new Color(0x650529));
       add(ur);

       b3 = new Button("Add");
       b3.setBounds(375, 200, 80, 25);
       b3.setFont(new Font("Book Antiqua", Font.BOLD, 15));
       b3.setForeground(new Color(0x531279));
       add(b3);
       b3.addActionListener(this);

       b4 = new Button("Show");
       b4.setBounds(375, 250, 80, 25);
       b4.setFont(new Font("Book Antiqua", Font.BOLD, 15));
       b4.setForeground(new Color(0x531279));
       add(b4);
       b4.addActionListener(this);

       lgot = new Button("Logout");
       lgot.setBounds(395, 330, 80, 25);
       lgot.setFont(new Font("Book Antiqua", Font.BOLD, 15));
       lgot.setForeground(new Color(0x1C4F07));
       add(lgot);
       lgot.addActionListener(this);

       close = new Button("Close");
       close.setBounds(480, 330, 80, 25);
       close.setFont(new Font("Book Antiqua", Font.BOLD, 15));
       close.setForeground(new Color(0xB90A0A));
       add(close);
       close.addActionListener(this);

       Label rset = new Label("Reset Password");
       rset.setBounds(459, 357, 250, 25);
       rset.setFont(new Font("Segoe UI", Font.BOLD, 13));
       rset.setForeground(new Color(0xF83939));
       add(rset);
       rset.addMouseListener(this);

   }


    public static void main(String[] args) {
        Admin_Logged_IN a=new Admin_Logged_IN("");
    }























    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Logout")){
            setVisible(false);
            new Login();
        }
        if(e.getActionCommand().equals("Close")){
            System.exit(0);
        }
        if(e.getSource()==b1){
            setVisible(false);
            new InserData_ST(A,id);
        }
        if(e.getSource()==b2){
            setVisible(false);
            new ShowData_ST(A,id);
        }

        if(e.getSource()==b3){
            setVisible(false);
            new UserRegi(A,id);
        }

        if(e.getSource()==b4){
            setVisible(false);
            new ShowData_UR(id);
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
    public void mouseClicked(MouseEvent e) {
       setVisible(false);
       new resetPassword(id,A);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
