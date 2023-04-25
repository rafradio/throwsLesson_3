package Model;

import Model.Exceptions.TypeValueException;

public abstract class Model {
    private String value;

    public Model(String value) {
        this.value = value;
    }

    public abstract boolean makeValidation(String value) throws TypeValueException;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    

    
}