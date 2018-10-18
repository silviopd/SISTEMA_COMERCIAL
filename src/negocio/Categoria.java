
package negocio;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Categoria extends Conexion{
    private int codigoCategoria;
    private String descripcion;
    private int codigoLinea;

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigoLinea() {
        return codigoLinea;
    }

    public void setCodigoLinea(int codigoLinea) {
        this.codigoLinea = codigoLinea;
    }
    
    public ResultSet listar() throws Exception{
        String sql = 
            "select" +
            "	c.codigo_categoria," +
            "	c.descripcion as categoria," +
            "	l.descripcion as linea " +
            "from" +
            "	categoria c " +
            "	inner join linea l on ( c.codigo_linea = l.codigo_linea ) " +
            "order by" +
            "	2";
        
        PreparedStatement sentencia 
                = this.abrirConexion().prepareStatement
                    (
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                    );
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        return resultado;
    }
    
    public String[] obtenerCamposBusqueda(){
        String campos[] =  {"codigo_categoria", "categoria", "linea"};
        return campos;
    }
    
    
    public boolean agregar() throws Exception{
        String sql 
            = "select * from f_generar_correlativo ('categoria') as numero";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        if (resultado.next()){
            int nuevoCodigo = resultado.getInt("numero");
            this.setCodigoCategoria( nuevoCodigo );
            
            //Iniciar la transacción
            Connection transaccion = this.abrirConexion();
            transaccion.setAutoCommit(false);
            
            
            /*Inicio: 1. Insertar en la tabla categoria*/
            sql = "insert into categoria"
                + "(codigo_categoria, descripcion, codigo_linea)"
                + "values(?,?,?)";
            PreparedStatement sentencia =
                    transaccion.prepareStatement(sql);
            sentencia.setInt(1, this.getCodigoCategoria());
            sentencia.setString(2, this.getDescripcion());
            sentencia.setInt(3, this.getCodigoLinea());
            this.ejecutarSQL(sentencia, transaccion);
            /*Fin: 1. Insertar en la tabla categoria*/
            
            
            /*Inicio: 2. Actualizar en la tabla correlativo*/
            sql = "update correlativo set numero = numero + 1 where tabla = ?";
            PreparedStatement sentencia2 =
                    transaccion.prepareStatement(sql);
            sentencia2.setString(1, "categoria");
            this.ejecutarSQL(sentencia2, transaccion);
            /*Fin: 2. Actualizar en la tabla correlativo*/
            
            transaccion.commit();
            transaccion.close();
                    
            
        }else{
            throw new Exception("No existe un correlativo registrado para la tabla categoria");
        }
        
        return true;
    }
    
    
    public ResultSet leerDatos( int codigoCategoria ) throws Exception{
        String sql = "select" +
        "	c.codigo_categoria," +
        "	c.descripcion as categoria," +
        "	l.descripcion as linea" +
        " from" +
        "	categoria c " +
        "	inner join linea l " +
        "	on ( c.codigo_linea = l.codigo_linea )" +
        " where" +
        "	c.codigo_categoria = ?";
        
        PreparedStatement sentencia 
                = this.abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, codigoCategoria);
        return this.ejecutarSQLSelectSP(sentencia);
                
    }
    
    
    public boolean editar() throws Exception{
        //Iniciar la transacción
        Connection transaccion = this.abrirConexion();
        transaccion.setAutoCommit(false);
        
        String sql = "update categoria "
                + "set descripcion = ?, "
                + "codigo_linea = ? "
                + "where codigo_categoria = ?";
        
        PreparedStatement sentencia = transaccion.prepareStatement(sql);
        sentencia.setString(1, this.getDescripcion());
        sentencia.setInt(2, this.getCodigoLinea());
        sentencia.setInt(3, this.getCodigoCategoria());
        this.ejecutarSQL(sentencia, transaccion);
        
        transaccion.commit();
        transaccion.close();
        
        return true;
        
        
    }
    
    
    public boolean eliminar() throws Exception{
        //Iniciar la transacción
        Connection transaccion = this.abrirConexion();
        transaccion.setAutoCommit(false);
        
        String sql = "delete from categoria "
                + "where codigo_categoria = ?";
        
        PreparedStatement sentencia = transaccion.prepareStatement(sql);
        sentencia.setInt(1, this.getCodigoCategoria());
        this.ejecutarSQL(sentencia, transaccion);
        
        transaccion.commit();
        transaccion.close();
        
        return true;
        
        
    }
    
}
