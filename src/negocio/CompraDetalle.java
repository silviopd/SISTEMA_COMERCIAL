package negocio;

import datos.Conexion;
import java.sql.ResultSet;

public class CompraDetalle extends Conexion{
    
    public ResultSet configurarTablaDetalleCompra() throws Exception{
        String sql = "select * from" +
            "(" +
            "	select" +
            "		0 as codigo," +
            "		''::character varying(100) as articulo," +
            "		0 as cantidad," +
            "		0.00 as precio," +
            "		0.00 as descuento," +
            "		0.00 as importe" +
            ") as tb_temporal " +
            "where tb_temporal.codigo <> 0";
        
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
    }
    
}
