import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class addedDialogueBox extends Frame implements WindowListener {

    String b,ID;
    Label l;
    addedDialogueBox(String a,String id){

        b = a;
        ID=id;


        setTitle("Dialogue Box");
        setSize(330, 150);
        setVisible(true);
        setLayout(null);
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        addWindowListener(this);

        l = new Label("-- Data Saved Successfully --");
        l.setBounds(40, 68, 350, 35);
        l.setFont(new Font("Segue UI", Font.BOLD, 17));
        l.setForeground(new Color(0x650529));
        add(l);


    }


    public static void main(String[] args) {
        addedDialogueBox d=new addedDialogueBox("","");
    }











    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(b=="Admin"){
            setVisible(false);
        }
        if(b=="User"){
            setVisible(false);
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
