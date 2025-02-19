package dev.sandeep.Splitwise.exception;

public class GroupNotFoundException extends RuntimeException{
    public GroupNotFoundException() {
    }

    public GroupNotFoundException(String message) {
        super(message);
    }

    public GroupNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
