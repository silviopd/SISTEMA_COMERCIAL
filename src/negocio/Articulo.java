package negocio;

import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Articulo extends Conexion{
    private int codigoArticulo;
    private String nombre;
    private double precioVenta;
    private int codigoCategoria;
    private int codigoMarca;
    private int stock;

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public int getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(int codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public ResultSet listar() throws Exception{
        String sql = "SELECT " +
                    "  articulo.codigo_articulo, " +
                    "  articulo.nombre, " +
                    "  articulo.stock, " +
                    "  linea.descripcion as linea, " +
                    "  categoria.descripcion as categoria, " +
                    "  marca.descripcion as marca" +
                    " FROM " +
                    "  public.linea, " +
                    "  public.categoria, " +
                    "  public.marca, " +
                    "  public.articulo " +
                    " WHERE " +
                    "  linea.codigo_linea = categoria.codigo_linea AND" +
                    "  categoria.codigo_categoria = articulo.codigo_categoria AND" +
                    "  marca.codigo_marca = articulo.codigo_marca " +
                    " ORDER BY" +
                    "  articulo.nombre ASC;";
        
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
    
    
    
    
}
