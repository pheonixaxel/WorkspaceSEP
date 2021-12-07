package utils;

public class IllegalClockException extends RuntimeException{

    public IllegalClockException()
    {
        super("Invalid time");
    }

}
