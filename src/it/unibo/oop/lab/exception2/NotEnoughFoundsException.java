package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException {

    /**
     * 
     */
    private static final long serialVersionUID = -1159808475879283028L;
    private double balance;
    private double amount;

    public NotEnoughFoundsException(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }
    
    @Override
    public String getMessage() {
        return "Not Enough Money" + this.balance + " is less than " + this.amount;
    }
    
}
