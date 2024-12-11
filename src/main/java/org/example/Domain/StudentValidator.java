package org.example.Domain;

public class StudentValidator implements Validator<Long,Student> {
    @Override
    public void validate(Student Entity) throws ValidationException {
        String nume=Entity.getNume();
        String regexName = "^[A-Za-z0-9 -]*$";
        if(!nume.matches(regexName))throw (new ValidationException("numele nu poate contine cifre!"));
    }
}
