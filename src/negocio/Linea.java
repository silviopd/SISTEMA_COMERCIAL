package negocio;

import datos.Conexion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Linea extends Conexion{
    
    private int codigoLinea;
    private String descripcion;
    
    public static ArrayList<Linea> listaLineas = new ArrayList<Linea>();

    public int getCodigoLinea() {
        return codigoLinea;
    }

    public void setCodigoLinea(int codigoLinea) {
        this.codigoLinea = codigoLinea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    private void cargarLista() throws Exception{
        String sql = "select codigo_linea, descripcion from linea order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaLineas.clear(); //limpiar la lista
        while(resultado.next()){
            Linea objLinea = new Linea();
            objLinea.setCodigoLinea( resultado.getInt("codigo_linea")  );
            objLinea.setDescripcion( resultado.getString("descripcion") );
            listaLineas.add( objLinea );
        }
        
    }
    
    public void cargarCombo( JComboBox objCombo ) throws Exception{
        this.cargarLista();
        objCombo.removeAllItems();
        for (int i=0; i < listaLineas.size(); i++){
            objCombo.addItem( listaLineas.get(i).descripcion   );
        }
    }
    
    
    
    
    public ResultSet listar() throws Exception{
        ResultSet resultado = null;
        String sql = "select * from linea order by descripcion";
        resultado = this.ejecutarSQLSelect(sql);
        return resultado;
        
        //return this.ejecutarSQLSelect("select * from linea");
        
    }
    
    
    
}
