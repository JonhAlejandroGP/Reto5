package model;

public class Req2 {
    private int Estrato; 
    private String fechaInicio; 
    private int Financiable;   
    private double porcetaje; 
 
    public Req2(int Estrato, String fechaInicio, int Financiable, double porcetaje) 
    { 
       this.Estrato=Estrato;
       this.fechaInicio=fechaInicio;
       this.Financiable=Financiable;
       this.porcetaje=porcetaje;

    }

    @Override
    public String toString() {
        return "Req2 [Estrato=" + Estrato + ", fechaInicio=" + fechaInicio + ", financiable=" + Financiable
                + ", porcetaje=" + String.format("%.1f", porcetaje) + "]";
    } 
   
}
