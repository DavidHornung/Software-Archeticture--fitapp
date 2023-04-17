package ch.unil.doplab.gadswebsite.exceptions;

import ch.unil.doplab.gadswebsite.models.Trainingprogram;
import java.util.List;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
public class DoesNotExistException extends Exception {

    private String message;

    public DoesNotExistException(String message) {
        this.message = message;
    }

    public DoesNotExistException(List<Trainingprogram> testtext) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMessage() {
        return message;
    }

}
