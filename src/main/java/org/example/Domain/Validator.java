package org.example.Domain;

/**
 * @param <Id>
 * @param <E> o enitate de tipul E
 */
public interface Validator<Id, E extends Entity<Id>> {
    void validate(E Entity) throws ValidationException;

}