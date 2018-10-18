
package negocio;

import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Configuracion extends Conexion{
    public String obtenerValorConfiguracion( int codigo ) throws Exception{
        String sql = "select valor from configuracion where codigo = ?";
        PreparedStatement sentencia = this.abrirConexion().prepareCall(sql);
        sentencia.setInt(1, codigo);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        if (resultado.next()){
            return resultado.getString("valor");
        }
        
        return "Valor no encontrado";
        
    }
}
