package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Model.Exceptions.DateValueException;

public class DateModel extends Model {
    public DateModel(String value) {
        super(value);
    } 

    @Override
    public boolean makeValidation(String typeOfValue) throws DateValueException {
        DateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(this.getValue());
        } catch (ParseException e) {
            throw new DateValueException("Дата рождения введена не правильно.", "Дата");
        }

        
        return true;
    }
}
