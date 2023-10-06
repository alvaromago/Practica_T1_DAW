package es.studium.aplicacion;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo {
	String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/practicat1daw";
    String login = "adminPelis"; // Usuario MySQL
    String password = "Studium2020;"; // Clave correspondiente
    String sentencia = "";
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    int id = 1;

    Modelo()
    {
        connection = this.conectar();
    }

    public Connection conectar()
    {
        try
        {
            // Cargar los controladores para el acceso a la BD
            Class.forName(driver); 
            // Establecer la conexión con la BD incidencias
            return(DriverManager.getConnection(url, login, password)); // Devuelve un objeto de la clase Connection
        }

        catch (ClassNotFoundException cnfe)
        {
            System.out.println("Error 1-"+cnfe.getMessage());
        }
        catch (SQLException sqle)
        {
            System.out.println("Error 2-"+sqle.getMessage());
        }
        return null;

    }
    
    public void anterior() {
    	id--;
    	if (id==0)
    	{
    		id=3;
    	}
    }
    
    public void siguiente() {
    	id++;
    	if (id==4)
    	{
    		id=1;
    	}
    }
    
    public void rellenarTitulo(TextField txtTitulo)
    {
    	System.out.println(id);
        String sentencia = "select tituloPelicula from peliculas where idPelicula=" + id + ";";
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
            // En resultado metemos todo lo que queremos almacenar en sentencia
            ResultSet resultado = statement.executeQuery(sentencia);
            while(resultado.next()) {
                txtTitulo.setText(resultado.getString("tituloPelicula")); 
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("Error 3-"+sqle.getMessage());
        }

    }

}
