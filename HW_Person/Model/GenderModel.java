package Model;

import Model.Exceptions.NameValueException;

public class GenderModel extends Model {
    public GenderModel(String value) {
        super(value);
    } 

    @Override
    public boolean makeValidation(String typeOfValue) throws NameValueException {
        // if (!(this.getValue().chars().allMatch(Character::isDigit))) {
        if (!(this.getValue().compareTo("m") == 0 || this.getValue().compareTo("f") == 0)) {
            throw new NameValueException("Пол введен не правильно.", "Пол");
        }
        return true;
    }
}
