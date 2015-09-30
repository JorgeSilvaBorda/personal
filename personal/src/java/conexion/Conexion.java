package conexion;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Jorge Silva Borda
 */
public class Conexion {
    private String server, bd, user, pass, ruta;
    private Connection c;
    public Conexion(String servidor, String baseDato, String usuario, String password){
        this.server = servidor;
        this.bd = baseDato;
        this.user = usuario;
        this.pass = password;
        configurar();
    }
    
    private void configurar(){
        this.ruta = "jdbc:mysql://" + this.server + "/" + this.bd;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(this.ruta, this.user, this.pass);
        }catch(ClassNotFoundException e){
            
        } catch (SQLException e) {
            
        }
    }

    public void ejecutar(String query){
        
    }
    
    public String[][] obtenerTabla(String query){
        ResultSet rs;
        String[][] datos;
        try{
            Statement s = (Statement) c.createStatement();
            rs = s.executeQuery(query);
            ResultSet resultado = rs;
            
            rs.last();
            datos = new String[rs.getMetaData().getColumnCount()][rs.getRow()];
        }catch(Exception e){
            
        }
        
        return null;
    }
}
