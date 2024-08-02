import java.awt.*;
import java.awt.event.*;

public class User_Logged_IN extends Frame implements ActionListener, WindowListener,MouseListener {

    String U="User",iD;
    Button lgot,close,add,show;
    Label l,l1,rset;

  User_Logged_IN(String a,String id) {

      iD=id;
      setTitle("User LogIn Dashboard");
      setSize(500, 300);
      setLocationRelativeTo(null);
      setLayout(null);
      setVisible(true);
      setBackground(new Color(0xBCBCD5));
      setResizable(false);
      addWindowListener(this);

      l = new Label("User's Dashboard");
      l.setBounds(135, 50, 250, 35);
      l.setFont(new Font("Segoe UI", Font.BOLD, 25));
      l.setForeground(new Color(0x650529));
      add(l);

      l1 = new Label("Students Information");
      l1.setBounds(160, 90, 250, 30);
      l1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
      l1.setForeground(new Color(0x124593));
      add(l1);

      Label l2 =new Label("Add Student Detail :");
      l2.setBounds(130, 145, 130, 30);
      l2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
      l2.setForeground(new Color(0x650529));
      add(l2);
      add = new Button("Add");
      add.setBounds(300, 149, 60, 20);
      add.setFont(new Font("Segoe UI", Font.BOLD, 14));
      add.setForeground(new Color(0x67571F));
      add(add);
      add.addActionListener(this);

      Label l3 =new Label("Show Student Detail :");
      l3.setBounds(130, 175, 150, 30);
      l3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
      l3.setForeground(new Color(0x650529));
      add(l3);
      show = new Button("Show");
      show.setBounds(300, 179, 60, 20);
      show.setFont(new Font("Segoe UI", Font.BOLD, 14));
      show.setForeground(new Color(0x67571F));
      add(show);
      show.addActionListener(this);

      rset = new Label("Reset Password");
      rset.setBounds(363, 265, 250, 25);
      rset.setFont(new Font("Segoe UI", Font.BOLD, 13));
      rset.setForeground(new Color(0xF83939));
      add(rset);
      rset.addMouseListener(this);

      lgot = new Button("Logout");
      lgot.setBounds(300, 235, 80, 25);
      lgot.setFont(new Font("Segoe UI", Font.BOLD, 15));
      lgot.setForeground(new Color(0x1C4F07));
      add(lgot);
      lgot.addActionListener(this);

      close = new Button("Close");
      close.setBounds(385, 235, 80, 25);
      close.setFont(new Font("Segoe UI", Font.BOLD, 15));
      close.setForeground(new Color(0xB90A0A));
      add(close);
      close.addActionListener(this);


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
      if(e.getActionCommand().equals("Add")){
          setVisible(false);
          new InserData_ST(U,iD);
      }
      if(e.getActionCommand().equals("Show")){
          setVisible(false);
          new ShowData_ST(U,iD);
          System.out.println("Showing Student Data");
      }

    }


    public static void main(String[] args) {
        User_Logged_IN u=new User_Logged_IN("","");
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
        new resetPassword(iD,U);
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
