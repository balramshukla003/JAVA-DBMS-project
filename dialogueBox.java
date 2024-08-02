import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class dialogueBox extends Frame implements WindowListener {

    String b,Id,k;
    Label l;
    dialogueBox(String a,String id,String g){

        k=g;
        Id=id;
        b=a;

        setTitle("Dialogue Box");
        setSize(330,150);
        setVisible(true);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        addWindowListener(this);

        l=new Label("-- You're Registered Successfully --");
        l.setBounds(20,68,350,35);
        l.setFont(new Font("Segue UI", Font.BOLD, 17));
        l.setForeground(new Color(0x650529));
        add(l);


    }


    public static void main(String[] args) {
        dialogueBox b=new dialogueBox("","","");
    }





    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        if(Objects.equals(b, "User")){
            setVisible(false);
        }
        else if(Objects.equals(b, "Admin")){
            setVisible(false);
        }
        else{
        }


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
}
