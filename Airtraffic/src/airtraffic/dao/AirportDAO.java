package airtraffic.dao;

import airtraffic.model.Airport;
import airtraffic.model.Flight;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 21/03/2016.
 */
@Repository
public class AirportDAO extends AbstractAirTrafficDAO {

    @Override
    public boolean add(Object item) {
        Airport air = (Airport) item;
        String sql = "INSERT INTO Airport (airport_code, name, address) VALUES (?,?,?)";
        try {
            this.access.update(sql, air.getAirportCode(), air.getName(), air.getAddress());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(String id) {
        String sql = "DELETE FROM Airport WHERE airport_code = ? LIMIT 1";
        return executeDelete(id,sql);
    }

    @Override
    public boolean update(Object item) {
        Airport air = (Airport) item;
        String sql = "UPDATE Airport SET name = ?, address = ? WHERE airport_code = ?";
        try {
            this.access.update(sql, air.getName(), air.getAddress(), air.getAirportCode());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object getItem(String id) {
        String sql = "SELECT * FROM Airport WHERE airport_code = ?";
        try {
            return this.access.queryForObject(sql, new AirportMapper(), id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Airport();
        }
    }

    public List<Airport> getAllAirports(){
        String sql = "SELECT * FROM Airport";
        try {
            return this.access.query(sql, new AirportMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Flight> getFlights(String type, String airport){
        String sql;
        if (type.equals("departures"))
            sql = "SELECT * FROM Flight WHERE origin = ?";
        else
            sql = "SELECT * FROM Flight WHERE destination = ?";

        try {
            return this.access.query(sql, new FlightMapper(), airport);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}



