package airtraffic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Airplane {
    private String plate;
    private String owner;
    private String model;
    private int hoursOnFlight;

    public Airplane() {
        this.plate = "";
        this.owner = "";
        this.model = "";
        this.hoursOnFlight = 0;
    }

    public Airplane(String plate, String owner, String model, int hoursOnFlight) {
        this.plate = plate;
        this.owner = owner;
        this.model = model;
        this.hoursOnFlight = hoursOnFlight;
    }

    //Setters
    public void setPlate(String data) {
        this.plate = data;
    }

    public void setOwner(String data) {
        this.owner = data;
    }

    public void setModel(String data) {
        this.model = data;
    }

    public void setHoursOnFlight(int hoursOnFlight) {
        this.hoursOnFlight = hoursOnFlight;
    }


    //Getters
    public String getPlate() {
        return this.plate;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getModel() {
        return this.model;
    }

    public int getHoursOnFlight() {
        return hoursOnFlight;
    }

    @Override
    public String toString() {
        return this.plate + "_" + this.owner + "_" + this.model + "_" + this.hoursOnFlight + "\n";
    }
}	