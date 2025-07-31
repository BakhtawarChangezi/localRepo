package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyException  extends RuntimeException {

    private String message;

    public EmailAlreadyException(String message) {
        super(message);
    }
}
