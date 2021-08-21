package views;

import javax.swing.JFrame;
import controller.Controller;
import java.util.ArrayList;
import java.awt.BorderLayout;


public class Interfaz extends JFrame {
    
    private panelBotones i;
    private Controller controlador;
    private PanelLista panelLista;

    public Interfaz()
    {
        super();
        controlador =new Controller("jdbc:mysql://localhost:3306/proyectosconstruccion");
        setSize(600,450);
       
        setLayout(new BorderLayout());      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Reto 5");
        i = new panelBotones(this);
        panelLista = new PanelLista(this);    
        add(i,BorderLayout.SOUTH);
        add(panelLista, BorderLayout.CENTER);
    }
    public void updateLista1(int req){
        if(req==1)
        {
        controlador.req1();
        req1(controlador.getReq1s());
        }else if(req==2)
        {
         controlador.req2();
         req1(controlador.getReq2s());   
        }else if(req==3)
        {
         controlador.req3();
         req1(controlador.getReq3s());
        }
    }

    public void req1(ArrayList<String> listaReq1) {
        String[] listado = new String[listaReq1.size()];
        for (int i = 0; i < listado.length; i++) {
            listado[i] = listaReq1.get(i);
        }
        panelLista.updateLista(listado);
    }

    public static void main (String[] args)    
    {
        Interfaz interfazppal =new Interfaz();
        interfazppal.setVisible(true);
    }
}
