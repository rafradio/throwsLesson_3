package Model;

import Model.Exceptions.NameValueException;
import Model.Exceptions.PhoneValueException;

public class PhoneModel extends Model {
    public PhoneModel(String value) {
        super(value);
    } 

    @Override
    public boolean makeValidation(String typeOfValue) throws PhoneValueException {
        if (!(this.getValue().chars().allMatch(Character::isDigit))) {
            throw new PhoneValueException("Телефон введен не правильно.", "Телефон");
        }
        return true;
    }


}
