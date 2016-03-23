package airtraffic.legacy;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;

public class NewFlightAD
{
	private Connection conection;
	private Statement statement;

	public NewFlightAD()
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

	public String[] getAirplanes(String search)
	{
		String data[];
		String query = "";
		int i =0;
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			query = "SELECT plate FROM Airplane";
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
				data[i] = tr.getString("plate");
				i++;
			}
		}

		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
		}

		return data;
	}

	public String[] getAirports(String search)
	{
		String data[];
		String query = "";
		int i =0;
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			query = "SELECT name FROM Airport";
			if(search != "")
			{
				query = query + " WHERE name != '"+search+"'";
				//JOptionPane.showMessageDialog(null, "Query: "+ query);
			}
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

	public String getShortName(String name)
	{
		String shortName = "";
		String query = "";
		ResultSet tr = null;

		try
		{
			statement = conection.createStatement();
			query = "SELECT airport_code FROM Airport WHERE name = '"+name+"'";
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				shortName = tr.getString("airport_code");
			}

		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
			//response = "Error:" +sqle;
		}
		return shortName;
	}

	public String newRegister(String data)
	{
		String response;
		String query = "";
		ResultSet tr = null;	
		
		try
		{
			statement = conection.createStatement();
			query = "INSERT INTO Flight VALUES ("+data+")";
			statement.executeUpdate(query);
			response = "...Registrado exitosamente...\n";
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
			response = "Error:" +sqle;
		}

		return response;	
	}
}