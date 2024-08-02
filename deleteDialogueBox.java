import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;

public class deleteDialogueBox extends Frame implements WindowListener {
    String b,ID,k;
    Label l;
    deleteDialogueBox(String a,String id,String i){

        b = a;
        ID=id;
        k=i;

        setTitle("Dialogue Box");
        setSize(330, 150);
        setVisible(true);
        setLayout(null);
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        addWindowListener(this);

        l = new Label("-- Deleted Data Successfully --");
        l.setBounds(40, 68, 350, 35);
        l.setFont(new Font("Segue UI", Font.BOLD, 17));
        l.setForeground(new Color(0x650529));
        add(l);
    }


    public static void main(String[] args) {
        deleteDialogueBox d=new deleteDialogueBox("","","");
    }








    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        if(Objects.equals(b, "Student")){
            setVisible(false);
        }
        else if(Objects.equals(b, "User")){

            setVisible(false);
        }
        else{
            System.exit(0);
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
