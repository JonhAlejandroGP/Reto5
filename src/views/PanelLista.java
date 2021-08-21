package views;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.*;
public class PanelLista extends JPanel {
    
    private JList<String> listaRequerimientos;

    private Interfaz interfaz;

    public PanelLista(Interfaz i) {
        super();
        setLayout(new GridLayout());
        interfaz = i;

        listaRequerimientos = new JList<>();

        add(listaRequerimientos);
    }

    public void updateLista(String[] listado) {
        listaRequerimientos.setListData(listado);
    }
    
}
