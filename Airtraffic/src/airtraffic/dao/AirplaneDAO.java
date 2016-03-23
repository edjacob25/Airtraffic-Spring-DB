package airtraffic.dao;

import airtraffic.model.Airplane;
import airtraffic.model.Airport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 21/03/2016.
 */
@Repository
public class AirplaneDAO extends AbstractAirTrafficDAO {

    @Override
    public boolean add(Object item) {
        Airplane air = (Airplane) item;
        String sql = "INSERT INTO Airplane (plate, owner, model, hours_on_flight) VALUES (?,?,?,?)";
        try {
            this.access.update(sql, air.getPlate(), air.getOwner(), air.getModel(), air.getHoursOnFlight());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(String id) {
        String sql = "DELETE FROM Airplane WHERE plate = ? LIMIT 1";
        return executeDelete(id, sql);
    }

    @Override
    public boolean update(Object item) {
        Airplane air = (Airplane) item;
        String sql = "UPDATE Airplane SET owner = ?, model = ?, hours_on_flight = ? WHERE plate = ?";
        try {
            this.access.update(sql, air.getOwner(), air.getModel(), air.getHoursOnFlight(), air.getPlate());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object getItem(String id) {
        String sql = "SELECT * FROM Airplane WHERE plate = ?";
        try {
            return this.access.queryForObject(sql, new AirplaneMapper(), id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Airplane> getAllAirplanes(){
        String sql = "SELECT * FROM Airplane";
        try {
            return this.access.query(sql, new AirplaneMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}



