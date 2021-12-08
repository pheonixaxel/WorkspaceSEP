package util;

public class IllegalClockException extends RuntimeException{

    public IllegalClockException()
    {
        super("Invalid time");
    }

}
