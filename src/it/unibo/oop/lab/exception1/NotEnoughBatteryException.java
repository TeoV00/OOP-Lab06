package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException{
    /*
     * I decided to extends IllegalStateException because is more expressive, javadoc says "Java environment 
     * or Java application is not in an appropriate state for the requested operation." In this case 
     * robot enviroment is not in a state that allow the robot to move
     * */
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
        return "NotEnoughBatteryException [batteryLevel=" + batteryLevel + "] NOT ENOUGH";
    }
    
    @Override
    public String getMessage() {
        return this.toString();
    }

}
