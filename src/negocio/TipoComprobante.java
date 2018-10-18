
package negocio;

import datos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoComprobante extends Conexion{
    private String codigoTipoComprobante;
    private String descripcion;
    
    public static ArrayList<TipoComprobante> listaTC = new ArrayList<TipoComprobante>();

    public String getCodigoTipoComprobante() {
        return codigoTipoComprobante;
    }

    public void setCodigoTipoComprobante(String codigoTipoComprobante) {
        this.codigoTipoComprobante = codigoTipoComprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    private void cargarTablaTC() throws Exception{
        String sql = "select * from tipo_comprobante";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaTC.clear();
        while(resultado.next()){
            TipoComprobante objTC = new TipoComprobante();
            objTC.setCodigoTipoComprobante( resultado.getString("codigo_tipo_comprobante") );
            objTC.setDescripcion( resultado.getString("descripcion"));
            listaTC.add(objTC);
        }
    }
    
    public void llenarComboTC(JComboBox objCombo) throws Exception{
        objCombo.removeAllItems();
        this.cargarTablaTC();
        for (int i = 0; i < listaTC.size(); i++) {
            objCombo.addItem(listaTC.get(i).getDescripcion());
        }
    }
    
}
