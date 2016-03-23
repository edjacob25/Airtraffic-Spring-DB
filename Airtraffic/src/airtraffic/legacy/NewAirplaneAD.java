package airtraffic.legacy;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;

public class NewAirplaneAD{

	private Connection conection;
	private Statement statement;

	public NewAirplaneAD()
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

	public String setNewAirplane(String plate, String owner, String model, int hours)
	{
		String query = "";
		String airline_code="";
		String response;
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			query = "SELECT airline_code FROM Airline WHERE name = '"+owner+"'";
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				airline_code = tr.getString("airline_code");
			}
			query = "INSERT INTO Airplane VALUES ('"+plate+"','"+airline_code+"','"+model+"','"+hours+"')";
			statement.executeUpdate(query);
			response = "Avion "+plate+" de la empresa "+owner+" registrado exitosamente";
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
			response = "Error:" +sqle;
		}

		return response;
	}
}