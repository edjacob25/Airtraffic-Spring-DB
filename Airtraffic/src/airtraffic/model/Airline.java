package airtraffic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jacob on 22/03/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airline {
    private String airlineCode;
    private String name;
    private String base;

    public Airline() {
    }

    public Airline(String airlineCode, String name, String base) {
        this.airlineCode = airlineCode;
        this.name = name;
        this.base = base;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
