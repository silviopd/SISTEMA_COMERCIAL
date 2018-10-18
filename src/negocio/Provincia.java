package negocio;

import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Provincia extends Conexion{
    private String codigoDepartamento;
    private String codigoProvincia;
    private String nombre;
    
    public static ArrayList<Provincia> listaProvincia 
            = new ArrayList<Provincia>();

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private void cargarLista(String codigoDepartamento) throws Exception{
        String sql = "select * from provincia where codigo_departamento = ? order by 3";
        PreparedStatement sentencia 
                = this.abrirConexion().prepareStatement(sql);
        sentencia.setString(1, codigoDepartamento);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        listaProvincia.clear();
        while (resultado.next()){
            Provincia objProv = new Provincia();
            objProv.setCodigoDepartamento(resultado.getString("codigo_departamento"));
            objProv.setCodigoProvincia(resultado.getString("codigo_provincia"));
            objProv.setNombre(resultado.getString("nombre"));
            listaProvincia.add(objProv);
        }
    }
    
    public void cargarCombo( JComboBox objCombo, String codigoDepartamento ) throws Exception{
        cargarLista(codigoDepartamento);
        objCombo.removeAllItems();
        for (int i = 0; i < listaProvincia.size(); i++) {
            objCombo.addItem(listaProvincia.get(i).nombre);
        }
    }
    
    
    
    
}
