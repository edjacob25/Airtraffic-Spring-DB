package airtraffic.controller;

import airtraffic.dao.AirlineDAO;
import airtraffic.dao.AirplaneDAO;
import airtraffic.dao.AirportDAO;
import airtraffic.dao.FlightDAO;
import airtraffic.model.Airline;
import airtraffic.model.Airplane;
import airtraffic.model.Airport;
import airtraffic.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;


/**
 * Created by Jacob Rivera on 21/03/2016.
 */
@RestController
public class MainController {

    private AirlineDAO airlineDAO;
    private AirplaneDAO airplaneDAO;
    private AirportDAO airportDAO;
    private FlightDAO flightDAO;

    @Autowired
    public void setDao(AirlineDAO airlineDAO, AirplaneDAO airplaneDAO, AirportDAO airportDAO, FlightDAO flightDAO) {
        this.airlineDAO = airlineDAO;
        this.airplaneDAO = airplaneDAO;
        this.airportDAO = airportDAO;
        this.flightDAO = flightDAO;
    }

    @RequestMapping(value = "/hello", method = GET)
    public Airplane hello(){
        return new Airplane();
    }


    //Airports

    @RequestMapping(value = "/airports", method = GET)
    public Collection<Airport> getAirports(){
        return airportDAO.getAllAirports();
    }

    @RequestMapping(value = "/airports/{airport}", method = GET)
    public Airport getAirportInfo(@PathVariable String airport){
        return (Airport) airportDAO.getItem(airport);
    }

    @RequestMapping(value = "/airports/{airport}/departures", method = GET)
    public Collection<Flight> getAirportDepartures(@PathVariable String airport){
        return airportDAO.getFlights("departures", airport);
    }

    @RequestMapping(value = "/airports/{airport}/arrivals", method = GET)
    public Collection<Flight> getAirportArrivals(@PathVariable String airport){
        return airportDAO.getFlights("arrivals", airport);
    }

    @RequestMapping(value = "/airports/add", method = POST)
    public boolean addAirport(@RequestBody Airport airport){
        return airportDAO.add(airport);
    }

    //Airlines

    @RequestMapping(value = "/airlines", method = GET)
    public Collection<Airline> getAirlines(){
        return airlineDAO.getAllAirlines();
    }

    @RequestMapping(value = "/airlines/{airline}", method = GET)
    public Airline getAirlineInfo(@PathVariable String airline){
        return (Airline) airlineDAO.getItem(airline);
    }

    @RequestMapping(value = "/airlines/{airline}/flights", method = GET)
    public Collection<Flight> getAirlineFlights(@PathVariable String airline){
        return airlineDAO.getFlights(airline);
    }

    @RequestMapping(value = "/airlines/add", method = POST)
    public boolean addAirline(@RequestBody Airline airline){
        System.out.println(airline.getBase());
        return airlineDAO.add(airline);
    }

    //Airplanes

    @RequestMapping(value = "/airplanes", method = GET)
    public Collection<Airplane> getAirplanes(){
        return airplaneDAO.getAllAirplanes();
    }

    @RequestMapping(value = "/airplanes/{airplane}", method = GET)
    public Airplane getAirplaneInfo(@PathVariable String airplane){
        return (Airplane) airplaneDAO.getItem(airplane);
    }


    @RequestMapping(value = "/airplanes/add", method = POST)
    public boolean addAirplane(@RequestBody Airplane airplane){
        return airplaneDAO.add(airplane);
    }

    //Flights

    @RequestMapping(value = "/flights", method = GET)
    public Collection<Flight> getFlights(){
        return flightDAO.getAllFlights();
    }

    @RequestMapping(value = "/flights/status/{status}", method = GET)
    public Collection<Flight> getFlights(@PathVariable String status){
        return flightDAO.getFlightsWithStatus(status);
    }

    @RequestMapping(value = "/flights/{flightNumber}", method = GET)
    public Flight getFlightInfo(@PathVariable String flightNumber){
        return (Flight) flightDAO.getItem(flightNumber);
    }

    @RequestMapping(value = "/flights/add", method = POST)
    public boolean addFlight(@RequestBody Flight flight){
        return flightDAO.add(flight);
    }
}
