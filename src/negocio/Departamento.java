package negocio;

import datos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Departamento extends Conexion{
    private String codigoDepartamento;
    private String nombre;
    
    public static ArrayList<Departamento> listaDpto 
            = new ArrayList<Departamento>();

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private void cargarLista() throws Exception{
        String sql = "select codigo_departamento, nombre from departamento order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaDpto.clear();
        while(resultado.next()){
            Departamento objDpto = new Departamento();
            objDpto.setCodigoDepartamento( resultado.getString("codigo_departamento") );
            objDpto.setNombre(resultado.getString("nombre"));
            listaDpto.add(objDpto);
        }
        
    }
    
    public void cargarCombo( JComboBox objCombo ) throws Exception{
        cargarLista();
        objCombo.removeAllItems();
        for (int i = 0; i < listaDpto.size(); i++) {
            objCombo.addItem( listaDpto.get(i).getNombre() );
        }
    }
    
    
}
