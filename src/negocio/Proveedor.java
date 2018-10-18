package negocio;

import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Proveedor extends Conexion{
    
    public ResultSet listar() throws Exception{
        String sql = "select "
                + "ruc_proveedor as ruc, "
                + "razon_social, "
                + "direccion, "
                + "telefono "
                + "from proveedor "
                + "order by razon_social";
        
        //ResultSet resultado = this.ejecutarSQLSelect(sql);
        
        PreparedStatement sentencia =
                this.abrirConexion().prepareStatement(
                            sql,
                            ResultSet.FETCH_FORWARD,
                            ResultSet.TYPE_FORWARD_ONLY
                        );
        
        ResultSet resultado 
                = this.ejecutarSQLSelectSP(sentencia);
        
        return resultado;
    }
    
    
    
}
