package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private double batteryLevel;
    
    public NotEnoughBatteryException(double batteryLevel) {
        super();
        this.batteryLevel = batteryLevel;
    }

    @Override
    public String toString() {
        return "NotEnoughBatteryException [batteryLevel=" + batteryLevel + "]" + "NOT ENOUGH";
    }
    
    @Override
    public String getMessage() {
        return this.toString();
    }

}
