package airtraffic.dao;

import airtraffic.model.Airline;
import airtraffic.model.Airplane;
import airtraffic.model.Airport;
import airtraffic.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jacob on 22/03/2016.
 */
public abstract class AbstractAirTrafficDAO {
    protected JdbcTemplate access;

    @Autowired
    public void setAccess(DataSource dataSource){
        this.access = new JdbcTemplate(dataSource);
    }

    public abstract boolean add(Object item);

    public abstract boolean remove(String id);

    public abstract boolean update(Object item);

    public abstract Object getItem(String id);

    protected static final class AirlineMapper implements RowMapper<Airline> {
        public Airline mapRow(ResultSet rs, int rowNum) throws SQLException {
            Airline air = new Airline();
            air.setAirlineCode(rs.getString("airline_code"));
            air.setBase(rs.getString("base"));
            air.setName(rs.getString("name"));
            return air;
        }
    }

    protected static final class AirportMapper implements RowMapper<Airport> {
        public Airport mapRow(ResultSet rs, int rowNum) throws SQLException {
            Airport air = new Airport();
            air.setAirportCode(rs.getString("airport_code"));
            air.setAddress(rs.getString("address"));
            air.setName(rs.getString("name"));
            return air;
        }
    }

    protected static final class AirplaneMapper implements RowMapper<Airplane> {
        public Airplane mapRow(ResultSet rs, int rowNum) throws SQLException {
            Airplane air = new Airplane();
            air.setPlate(rs.getString("plate"));
            air.setOwner(rs.getString("owner"));
            air.setModel(rs.getString("model"));
            air.setHoursOnFlight(rs.getInt("hours_on_flight"));
            return air;
        }
    }

    protected static final class FlightMapper implements RowMapper<Flight> {
        public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
            Flight flight = new Flight();
            flight.setFlightNumber(rs.getInt("flight_number"));
            flight.setPlane(rs.getString("plane"));
            flight.setOrigin(rs.getString("origin"));
            flight.setDestination(rs.getString("destination"));
            flight.setStatus(rs.getString("status"));
            flight.setDeparture(rs.getDate("departure"));
            flight.setArrival(rs.getDate("arrival"));
            return flight;
        }
    }

    protected boolean executeDelete(String id, String sql){
        try {
            this.access.update(sql, id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
