package airtraffic.legacy;

import airtraffic.model.Airplane;
import airtraffic.model.Flight;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class AirlineAD{

	private Connection conection;
	private Statement statement;

	public AirlineAD()
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

	public String[] obtainAirlines()
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

	public String obtainAirplanes(String owner)
	{
		//JOptionPane.showMessageDialog(null, "Owner"+ owner);
		String data ="";
		String query = "";
		ResultSet tr = null;
		Airplane airplane = new Airplane();
		try
		{
			statement = conection.createStatement();
			query = "SELECT Airplane.plate, Airplane.model FROM Airline JOIN Airplane ON(Airline.airline_code = Airplane.owner) WHERE Airline.name = '"+owner+"'";
			tr = statement.executeQuery(query);
			while(tr.next())
			{
				airplane.setPlate(tr.getString("plate"));
				airplane.setModel(tr.getString("model"));
				data = data + airplane.toString();

			}
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
		}

		return data;
	}

	public String obtainFlights(String owner)
	{
		//JOptionPane.showMessageDialog(null, "Owner"+ owner);
		String data ="";
		String query = "";
		ResultSet tr = null;
		Flight flight = new Flight();
		try
		{
			statement = conection.createStatement();
			query = "SELECT Flight.* FROM Flight JOIN (Airline JOIN Airplane ON Airline.airline_code = Airplane.owner) ON Flight.plane = Airplane.plate WHERE Airline.name = '"+owner+"'";
			 							
			tr = statement.executeQuery(query); 
			//System.out.println(owner);
			while(tr.next())
			{
				flight.setFlightNumber(tr.getInt("flight_number"));
				flight.setPlane(tr.getString("plane"));
				flight.setOrigin(tr.getString("origin"));
				flight.setStatus(tr.getString("status"));
				flight.setDestination(tr.getString("destination"));
				data = data + flight.toStringNoCalendar();

				//System.out.println("pase por aqui");
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: " + sqle);
		}

		return data;
	}

}