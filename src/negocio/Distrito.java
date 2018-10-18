package negocio;

import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class Distrito extends Conexion{
    private String codigoDepartamento;
    private String codigoProvincia;
    private String codigoDistrito;
    private String nombre;
    
    public static ArrayList<Distrito> listaDistrito
            = new ArrayList<Distrito>();

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private void cargarLista
        (String codigoDepartamento, String codigoProvincia) 
                throws Exception{
        String sql = "select * from distrito where codigo_departamento = ? and codigo_provincia = ? order by 4";
        PreparedStatement sentencia 
                = this.abrirConexion().prepareStatement(sql);
        sentencia.setString(1, codigoDepartamento);
        sentencia.setString(2, codigoProvincia);
        
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        listaDistrito.clear();
        
        while (resultado.next()){
            Distrito objDis = new Distrito();
            objDis.setCodigoDepartamento(resultado.getString("codigo_departamento"));
            objDis.setCodigoProvincia(resultado.getString("codigo_provincia"));
            objDis.setCodigoDistrito(resultado.getString("codigo_distrito"));
            objDis.setNombre(resultado.getString("nombre"));
            listaDistrito.add(objDis);
        }
            
    }
        
    public void cargarCombo( JComboBox objCombo, String codigoDepartamento, String codigoProvincia ) throws Exception{
        cargarLista(codigoDepartamento, codigoProvincia);
        objCombo.removeAllItems();
        for (int i = 0; i < listaDistrito.size(); i++) {
            objCombo.addItem( listaDistrito.get(i).getNombre() );
        }
    }
    
    
    
}
