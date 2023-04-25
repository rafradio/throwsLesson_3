package Model.Exceptions;

public class NameValueException extends TypeValueException {
    
    public NameValueException(String message, String value) {
        super(message, value);
    }
}
