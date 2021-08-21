package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Req1;
import model.Req2;
import model.Req3;
import services.Conexion;

public class Controller {
    private ArrayList<String> req1s; 
    private ArrayList<String> req2s; 
    private ArrayList<String> req3s; 
 
    private Conexion conectorDB; 
 
    public Controller(String url) { 
        super(); 
      
        conectorDB = new Conexion(url); 
    } 
 
    public ArrayList<String> getReq1s() {
        return req1s;
    }

    public void setReq1s(ArrayList<String> req1s) {
        this.req1s = req1s;
    }

    public ArrayList<String> getReq2s() {
        return req2s;
    }

    public void setReq2s(ArrayList<String> req2s) {
        this.req2s = req2s;
    }

    public ArrayList<String> getReq3s() {
        return req3s;
    }

    public void setReq3s(ArrayList<String> req3s) {
        this.req3s = req3s;
    }

    public void req1() { 
        String sql = "select sum(c.Cantidad) as total,p.ID_Proyecto,c.Pagado,c.Proveedor FROM "+
         "Proyecto p inner join Compra c on p.ID_Proyecto =c.ID_Proyecto WHERE pagado ='No' "+
        "GROUP BY p.ID_Proyecto "+
        "HAVING SUM(c.Cantidad) >50";
        req1s=new ArrayList<String>();
        ResultSet rs = conectorDB.executeQuery(sql);
        try {
            while(rs.next())
            {
                Req1 r= new Req1(rs.getInt("total"),rs.getInt("ID_Proyecto"),rs.getString("Pagado"),rs.getString("Proveedor"));
                req1s.add(r.toString());
            }
        } catch (SQLException e) {           
            e.printStackTrace();
        }

    } 
 
    public void req2() { 
        
        String sql = "select t.Estrato,DATE_FORMAT(p.Fecha_Inicio, '%Y-%m-%d') AS fechaInicio, t.Financiable,(p.Porcentaje_Cuota_Inicial*100) as porcetaje "+
        "FROM  Proyecto p  INNER join Tipo t on t.ID_Tipo =p.ID_Tipo "+
        "WHERE  t.Financiable =0 and t.Estrato >=5 and (p.Porcentaje_Cuota_Inicial*100) =30 order by Fecha_Inicio ASC";
       req2s=new ArrayList<String>();
       ResultSet rs = conectorDB.executeQuery(sql);
       try {
           while(rs.next())
           {
               Req2 r= new Req2(rs.getInt("Estrato"),rs.getString("fechaInicio"),rs.getInt("Financiable"),rs.getDouble("porcetaje"));
               req2s.add(r.toString());
           }
       } catch (SQLException e) {           
           e.printStackTrace();
       }
    } 
 
    public void req3() { 
        String sql = "select DISTINCT p.ID_Proyecto, c.Pagado,p.Clasificacion FROM  Proyecto p inner join Compra c "+
        "on p.ID_Proyecto =c.ID_Proyecto INNER JOIN MaterialConstruccion mc on mc.ID_MaterialConstruccion =c.ID_MaterialConstruccion "+
       "where (c.Pagado in('Parcialmente','No') and p.Clasificacion in('Apartaestudio','Apartamento')) and mc.Importado ='Si'and p.Acabados ='No' "+
       "group by p.ID_Proyecto";
       req3s=new ArrayList<String>();
       ResultSet rs = conectorDB.executeQuery(sql);
       try {
           while(rs.next())
           {
               Req3 r= new Req3(rs.getInt("ID_Proyecto"),rs.getString("Pagado"),rs.getString("Clasificacion"));
               req3s.add(r.toString());
           }
       } catch (SQLException e) {           
           e.printStackTrace();
       }
 
    } 
 
 
}
