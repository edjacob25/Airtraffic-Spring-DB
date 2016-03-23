package airtraffic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.StringTokenizer;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flight {
    private int flightNumber;
    private String status;
    private String plane;
    private String origin;
    private String destination;
    private Date departure;
    private Date arrival;

    public Flight() {
        this.flightNumber = 0;
        this.status = "DEFAULT";
        this.plane = "DEFAULT";
        this.origin = "DEFAULT";
        this.destination = "DEFAULT";
    }

    public Flight(String data) {
        StringTokenizer st = new StringTokenizer(data, "_");
        this.flightNumber = Integer.parseInt(st.nextToken());
        this.status = st.nextToken();
        this.plane = st.nextToken();
        this.origin = st.nextToken();
        this.destination = st.nextToken();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            departure = format.parse(st.nextToken());
            arrival = format.parse(st.nextToken());
        } catch (ParseException pe) {
            System.out.println(pe);
        }
    }

    //Setters
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    //Getters
    public int getFlightNumber() {
        return flightNumber;
    }

    public String getStatus() {
        return this.status;
    }

    public String getPlane() {
        return this.plane;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public Date getDeparture() {
        return this.departure;
    }

    public Date getArrival() {
        return this.departure;
    }


    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return flightNumber + "_" + status + "_" + plane + "_" + origin + "_" + destination + "_" + format.format(departure) + "_" + format.format(arrival);
    }

    public String toStringNoCalendar() {
        return flightNumber + "_" + status + "_" + plane + "_" + origin + "_" + destination + "\n";
    }
}