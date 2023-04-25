package Model;

import Model.Exceptions.NameValueException;

public class FIOModel extends Model {
    public FIOModel(String value) {
        super(value);
    }

    @Override
    public boolean makeValidation(String typeOfValue) throws NameValueException {

        // if ((this.getValue().chars().mapToObj(Character.UnicodeBlock::of).allMatch(Character.UnicodeBlock.CYRILLIC::equals))) {
        //     if ((this.getValue().chars().anyMatch(Character::isDigit)))
        //         throw new NameValueException("ФИО русское введено не правильно.", "ФИО");
        // }
        
        String message = typeOfValue + " введено не правильно.";
        if (!(this.getValue().chars().allMatch(Character::isLetter))) {
            throw new NameValueException(message, "ФИО");
        }

        // if (!(this.getValue().matches("[а-яА-Я]+"))) 
        //     throw new NameValueException("ФИО русское введено не правильно.", "ФИО");

        

        // if (!(this.getValue().chars().allMatch(Character::isLetter))) {
        //     if ((this.getValue().chars().mapToObj(Character.UnicodeBlock::of).allMatch(Character.UnicodeBlock.CYRILLIC::equals))) {
        //         throw new NameValueException("ФИО введено не правильно.", "ФИО");
        //     }
            
        // }
        return true;
    }
}
