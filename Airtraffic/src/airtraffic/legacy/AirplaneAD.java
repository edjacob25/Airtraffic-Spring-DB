package airtraffic.legacy;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class AirplaneAD
{
	private Connection conection;
	private Statement statement;

	public AirplaneAD()
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

	public String[] getAirlines()
	{
		String data[];
		String query = "";
		int i =0;
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			query = "SELECT name FROM Airline";
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
	public String searchAll()
	{
		/*Removí String airline, String model de los parámetros del metodo*/

		String data = "";
		String query = "";
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			/*query = "SELECT Airplane.plate FROM "; 
			query = query +"Airline JOIN Airplane ON Airline.airline_code = Airplane.owner WHERE Airline.name ='"+ airline+"' AND Airplane.model ='"+model+"'";*/
			query = "Select * FROM Airplane";
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				data = data + tr.getString("plate")+"_";
				data = data + tr.getString("owner")+"_";
				data = data + tr.getString("model")+"_";
				data = data + tr.getInt("hours_on_flight")+"\n";
			}
		}

		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
		}

		return data;
	}

	public String searchFlying(String airline, String model)
	{
		String data = "";
		String query = "";
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			query = "SELECT Airplane.plate FROM "; 
			query = query +"Flight JOIN (Airline JOIN Airplane ON Airline.airline_code = Airplane.owner) ON Flight.plane = Airplane.plate WHERE Airline.name ='"+ airline+"' AND Airplane.model ='"+model+"' AND Flight.status ='FLYING'";
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				data = data + tr.getString("plate")+"\n";
			}
		}

		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
		}

		return data;
	}
}