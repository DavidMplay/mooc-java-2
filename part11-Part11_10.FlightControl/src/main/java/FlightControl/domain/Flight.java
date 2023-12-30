package FlightControl.domain;

import FlightControl.domain.Airplane;

public class Flight {

    private Airplane plane;
    private Place departure;
    private Place target;

    public Flight(Airplane plane, Place departure, Place target) {
        this.plane = plane;
        this.departure = departure;
        this.target = target;
    }

    public Airplane getAirplane() {
        return plane;
    }

    public Place getDeparture() {
        return departure;
    }

    public Place getTarget() {
        return target;
    }

    public String toString() {
        return this.plane.toString() + " (" + this.departure + "-" + this.target + ")";
    }
}
