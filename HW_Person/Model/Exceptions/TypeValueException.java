package Model.Exceptions;

public class TypeValueException extends Exception {
    private final String value;

    

    public TypeValueException(String message, String value) {
        super(message);
        this.value = value;
    }



    public String getName() {
        return value;
    }

    
}
