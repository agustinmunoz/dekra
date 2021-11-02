package es.agustin.munoz.dekra.exception;

public class CustomExceptionNotFound extends RuntimeException{

    public CustomExceptionNotFound(String message) {
        super(message);
    }
    public CustomExceptionNotFound(Throwable cause) {
        super(cause);
    }
}
