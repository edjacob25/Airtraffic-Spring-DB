package airtraffic.legacy;

import airtraffic.model.Flight;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class AirportAD
{/*
	private Connection conection;
	private Statement statement;

	public AirportAD()
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

	public String[] returnAirports()
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

	public String getAddress(String airport)
	{
		String data ="";
		String query = "";
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			query = "SELECT address FROM Airport WHERE name = '"+airport+"'";
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				data = data + tr.getString("address");
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
		}
		return data;
	}

	public String getFlights(String airport)
	{
		Flight flight = new Flight();
		String data ="";
		String query = "";
		ResultSet tr = null;
		try
		{
			statement = conection.createStatement();
			query = "SELECT * FROM Flight JOIN Airport ON Flight.origin = Airport.airport_code WHERE Airport.name = '"+airport+"'";
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				flight.setFlightNumber(tr.getInt("flight_number"));
				flight.setStatus(tr.getString("status"));
				flight.setPlane(tr.getString("plane"));
				flight.setOrigin(tr.getString("origin"));
				flight.setDestination(tr.getString("destination"));
				flight.setDeparture(tr.getDate("departure")+" "+tr.getTime("departure"));
				flight.setArrival(tr.getDate("arrival")+" "+tr.getTime("arrival"));
				data = data + flight.toString() +"\n";
			}

		
			query = "SELECT * FROM Flight JOIN Airport ON Flight.destination = Airport.airport_code WHERE Airport.name = '"+airport+"'";
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				flight.setFlightNumber(tr.getInt("flight_number"));
				flight.setStatus(tr.getString("status"));
				flight.setPlane(tr.getString("plane"));
				flight.setOrigin(tr.getString("origin"));
				flight.setDestination(tr.getString("destination"));
				flight.setDeparture(tr.getDate("departure")+" "+tr.getTime("departure"));
				flight.setArrival(tr.getDate("arrival")+" "+tr.getTime("arrival"));
				data = data + flight.toString() +"\n";
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
		}
		//System.out.println(data);
		return data;
	}*/
}