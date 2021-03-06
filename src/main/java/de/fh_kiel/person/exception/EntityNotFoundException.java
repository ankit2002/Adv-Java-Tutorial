package de.fh_kiel.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception indicating that we could not lookup an entity.
 * @author Created by tom on 13.11.2016.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class EntityNotFoundException extends RuntimeException {
    EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
