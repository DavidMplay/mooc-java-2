package FlightControl.domain;

public class Airplane {

    public String id;
    public int capacity;

    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    public String getId(){
        return this.id;
    }
    public int getCapacity(){
        return this.capacity;
    }
    
    public String toString(){
        return this.id + " ("+ this.capacity + " capacity)";
    }
}
