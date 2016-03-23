package airtraffic.legacy;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class NewAirlineAD
{
	private Connection conection;
	private Statement statement;
	public NewAirlineAD()
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

	public String[] getAirports()
	{
		String data[];
		String query = "";
		int i =0;
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			query = "SELECT name FROM Airport";
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				i++;
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
		}

		data = new String[i];
		i=0;
		try
		{
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				data[i] = tr.getString("name");
				i++;
			}
		}

		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
		}

		return data;

	}

	public String setNewAirline(String code, String name, String base)
	{
		String query = "";
		String airport_code="";
		String response;
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			query = "SELECT airport_code FROM Airport WHERE name = '"+base+"'";
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				airport_code = tr.getString("airport_code");
			}
			query = "INSERT INTO Airline VALUES ('"+code+"','"+name+"','"+airport_code+"')";
			statement.executeUpdate(query);
			response = "Aerolinea "+name+" con el codigo " +code+" y con base en "+base+" registrado exitosamente";
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
			response = "Error:" +sqle;
		}

		return response;
	}
}