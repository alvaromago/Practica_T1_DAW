package es.studium.aplicacion;

import java.awt.TextArea;
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
    int totalPelis;

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
    		id=totalPelis;
    	}
    }
    
    public void siguiente() {
    	id++;
    	if (id==totalPelis+1)
    	{
    		id=1;
    	}
    }
    
    public void rellenarTitulo(TextField txtTitulo)
    {
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

    public void rellenarGenero(TextField txtGenero)
    {
        String sentencia = "select generoPelicula from peliculas where idPelicula=" + id + ";";
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
            // En resultado metemos todo lo que queremos almacenar en sentencia
            ResultSet resultado = statement.executeQuery(sentencia);
            while(resultado.next()) {
                txtGenero.setText(resultado.getString("generoPelicula")); 
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("Error 4-"+sqle.getMessage());
        }
    }
    
    public void rellenarFecha(TextField txtFecha)
    {
        String sentencia = "select anioPelicula from peliculas where idPelicula=" + id + ";";
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
            // En resultado metemos todo lo que queremos almacenar en sentencia
            ResultSet resultado = statement.executeQuery(sentencia);
            while(resultado.next()) {
                txtFecha.setText(resultado.getString("anioPelicula")); 
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("Error 5-"+sqle.getMessage());
        }
    }
    
    public void rellenarDirector(TextField txtDirector)
    {
        String sentencia = "select directorPelicula from peliculas where idPelicula=" + id + ";";
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
            // En resultado metemos todo lo que queremos almacenar en sentencia
            ResultSet resultado = statement.executeQuery(sentencia);
            while(resultado.next()) {
                txtDirector.setText(resultado.getString("directorPelicula")); 
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("Error 6-"+sqle.getMessage());
        }
    }
    
    public void rellenarReparto(TextArea txaReparto)
    {
        String sentencia = "select repartoPelicula from peliculas where idPelicula=" + id + ";";
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
            // En resultado metemos todo lo que queremos almacenar en sentencia
            ResultSet resultado = statement.executeQuery(sentencia);
            while(resultado.next()) {
                txaReparto.setText(resultado.getString("repartoPelicula")); 
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("Error 7-"+sqle.getMessage());
        }
    }
    
    public void rellenarArgumento(TextArea txaArgumento)
    {
        String sentencia = "select argumentoPelicula from peliculas where idPelicula=" + id + ";";
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
            // En resultado metemos todo lo que queremos almacenar en sentencia
            ResultSet resultado = statement.executeQuery(sentencia);
            while(resultado.next()) {
                txaArgumento.setText(resultado.getString("argumentoPelicula")); 
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("Error 8-"+sqle.getMessage());
        }
    }
    
    public String rellenarCaratula() {
    	String caratula = null;
    	String sentencia = "select caratulaPelicula from peliculas where idPelicula=" + id + ";";
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
            // En resultado metemos todo lo que queremos almacenar en sentencia
            ResultSet resultado = statement.executeQuery(sentencia);
            while(resultado.next()) {
                caratula = resultado.getString("caratulaPelicula"); 
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("Error 9-"+sqle.getMessage());
        }
        return caratula;
    }
    
    public int totalPelis() {
        String sentencia = "SELECT COUNT(*) AS totalPeliculas FROM peliculas;";
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultado = statement.executeQuery(sentencia);
            if (resultado.next()) {
                totalPelis = resultado.getInt("totalPeliculas");
            }
        } catch (SQLException sqle) {
            System.out.println("Error 10-" + sqle.getMessage());
        }
        return totalPelis;
    }
}
