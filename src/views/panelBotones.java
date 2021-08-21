package views;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
public class panelBotones extends JPanel implements ActionListener {

    public final static String BTN_REQ1 = "Requerimiento 1";
    public final static String BTN_REQ2 = "Requerimiento 2";
    public final static String BTN_REQ3 = "Requerimiento 3";
   
    private JButton btnreq1;
    private JButton btnreq2;
    private JButton btnreq3;
    private Interfaz interfaz;

    public panelBotones(Interfaz inter)
    {
        super();
        interfaz =inter;
        setLayout(new GridLayout(1,4));
        setBorder(new TitledBorder("Requerimientos"));
        btnreq1=new JButton(BTN_REQ1); 
        btnreq2=new JButton(BTN_REQ2);
        btnreq3=new JButton(BTN_REQ3);
        btnreq1.setActionCommand(BTN_REQ1);
        btnreq2.setActionCommand(BTN_REQ2);
        btnreq3.setActionCommand(BTN_REQ3);
        btnreq1.addActionListener(this);
        btnreq2.addActionListener(this);
        btnreq3.addActionListener(this);
        add(btnreq1);
        add(btnreq2);
        add(btnreq3);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals(BTN_REQ1))
        {
            interfaz.updateLista1(1);
        }else if(e.getActionCommand().equals(BTN_REQ2))
        {
          interfaz.updateLista1(2);
        }else if((e.getActionCommand().equals(BTN_REQ3)))
        {
         interfaz.updateLista1(3);
        }
    }
}
