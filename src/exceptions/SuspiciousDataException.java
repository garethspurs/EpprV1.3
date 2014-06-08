package exceptions;

public class SuspiciousDataException extends Exception {
    public SuspiciousDataException(){
        super();
        System.err.print("SuspiciousDataException");
    }
}
