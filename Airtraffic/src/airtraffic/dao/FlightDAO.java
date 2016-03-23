package airtraffic.dao;

import airtraffic.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 21/03/2016.
 */
@Repository
public class FlightDAO extends AbstractAirTrafficDAO {

    @Override
    public boolean add(Object item) {
        Flight flight = (Flight) item;
        String sql = "INSERT INTO Flight (flight_number, plane,  origin, destination, status, departure, arrival) " +
                "VALUES (?,?,?,?,?,?,?)";
        try {
            this.access.update(sql, flight.getFlightNumber(), flight.getPlane(), flight.getOrigin(),
                    flight.getDestination(), flight.getStatus(), flight.getDeparture(), flight.getArrival());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(String id) {
        String sql = "DELETE FROM Flight WHERE flight_number = ? LIMIT 1";
        return executeDelete(id,sql);
    }

    @Override
    public boolean update(Object item) {
        Flight flight = (Flight) item;
        String sql = "UPDATE Flight SET plane = ?, origin = ?, destination = ?, " +
                "departure = ?, arrival = ?, status = ? WHERE flight_number = ?";
        try {
            this.access.update(sql, flight.getPlane(), flight.getOrigin(), flight.getDestination(),
                    flight.getDeparture(), flight.getArrival(), flight.getStatus(), flight.getFlightNumber());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object getItem(String id) {
        String sql = "SELECT * FROM Flight WHERE flight_number = ?";
        try {
            return this.access.queryForObject(sql, new FlightMapper(), id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Flight> getAllFlights(){
        String sql = "SELECT * FROM Flight";
        try {
            return this.access.query(sql, new FlightMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Flight> getFlightsWithStatus(String status){
        String sql = "SELECT * FROM Flight WHERE status = ?";
        try {
            return this.access.query(sql, new FlightMapper(), status);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}



