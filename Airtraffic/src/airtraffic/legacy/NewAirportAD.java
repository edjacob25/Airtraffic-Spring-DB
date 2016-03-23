package airtraffic.legacy;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class NewAirportAD
{
	private Connection conection;
	private Statement statement;
	public NewAirportAD()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conection = DriverManager.getConnection("jdbc:mysql://localhost/AirTraffic","myself","myself");
			System.out.println("conection exitosa a la BD en MySQL, JDBC Tipo 4");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Error: " + cnfe);
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);	
		}
		catch(InstantiationException ie)
		{
			System.out.println("Error: " + ie);	
		}
		catch(IllegalAccessException iae)
		{			
			System.out.println("Error: " + iae);	
		}
	}

	

	public String setNewAirport(String code, String name, String address)
	{
		String query = "";
		String response;
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			query = "INSERT INTO Airport VALUES ('"+code+"','"+name+"','"+address+"')";
			statement.executeUpdate(query);
			response = "Aeropuerto "+name+" con el codigo" +code+" y con dirección en "+address+" registrado exitosamente";
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
			response = "Error:" +sqle;
		}

		return response;
	}
}