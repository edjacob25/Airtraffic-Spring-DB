package airtraffic.dao;

import airtraffic.model.Airline;
import airtraffic.model.Flight;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 22/03/2016.
 */
@Repository
public class AirlineDAO extends AbstractAirTrafficDAO {
    @Override
    public boolean add(Object item) {
        Airline air = (Airline) item;
        String sql = "INSERT INTO Airline (airline_code, base, name) VALUES (?,?,?)";
        try {
            this.access.update(sql, air.getAirlineCode(), air.getBase(), air.getName());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(String id) {
        String sql = "DELETE FROM Airline WHERE airline_code = ? LIMIT 1";
        return executeDelete(id, sql);
    }

    @Override
    public boolean update(Object item) {
        Airline air = (Airline) item;
        String sql = "UPDATE Airline SET name = ?, base = ? WHERE airline_code = ?";
        try {
            this.access.update(sql, air.getName(), air.getBase(), air.getAirlineCode());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object getItem(String id) {
        String sql = "SELECT * FROM Airline WHERE airline_code = ?";
        try {
            return this.access.queryForObject(sql, new AirlineMapper(), id);
        } catch (Exception e) {

            return false;
        }
    }

    public List<Airline> getAllAirlines(){
        String sql = "SELECT * FROM Airline";
        try {
            return this.access.query(sql, new AirlineMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Flight> getFlights(String airline){
        String sql = "SELECT * FROM Flight JOIN Airplane ON (Flight.plane = Airplane.plate) WHERE Airplane.owner = ?";

        try {
            return this.access.query(sql, new FlightMapper(), airline);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
