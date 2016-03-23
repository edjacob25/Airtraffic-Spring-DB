package airtraffic.legacy;

import airtraffic.model.Flight;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.Calendar;
import javax.swing.*;

public class FlightAD
{/*
	private Connection conection;
	private Statement statement;

	public FlightAD(){
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

	public String checkAllFlights(){
		
		String data="";
		String query = "";
		boolean pass = false;

		Flight flight = new Flight();
		ResultSet tr = null;
			try
			{
				statement = conection.createStatement();
				query = "SELECT * FROM Flight";
				tr = statement.executeQuery(query);
	
				while(tr.next())
				{
					pass = true;
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
				data = "Error "+ sqle;
			}
			if (!pass) {
				data="No hay vuelos";
			}
		return data;
	}

	public String search(String status, Date date){
		
		String data="";
		String query = "";
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE,1);
		Date tomorrow = new Date(c.getTimeInMillis());

		boolean pass = false;

		Flight flight = new Flight();
		ResultSet tr = null;
			try
			{
				statement = conection.createStatement();
				query = "SELECT * FROM Flight WHERE status = '"+status+"' AND departure > '"+date+"' AND departure < '"+tomorrow+"'";
				JOptionPane.showMessageDialog(null,query);
				tr = statement.executeQuery(query);
	
				while(tr.next())
				{
					pass=true;
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
				data = "Error "+ sqle;
			}
			if (!pass) {
				data="No hay vuelos";
			}
		return data;
	}*/
}