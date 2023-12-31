package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {

    private boolean state;

    public TemperatureSensor() {
        this.state = false;
    }

    @Override
    public boolean isOn() {
        return this.state;
    }

    @Override
    public void setOn() {
        this.state = true;
    }

    @Override
    public void setOff() {
        this.state = false;
    }

    @Override
    public int read() {
        if (this.state == true) {
            return new Random().nextInt(61) - 30;
        } else {
            throw new IllegalStateException("Illegal state!");
        }
    }

}
