package airtraffic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jacob on 22/03/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airport {
    private String airportCode;
    private String name;
    private String address;

    public Airport( ) {
        this.airportCode = "DEF";
        this.name = "DEFAULT";
        this.address = "DEFAULT";
    }

    public Airport(String airportCode, String name, String address) {

        this.airportCode = airportCode;
        this.name = name;
        this.address = address;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
