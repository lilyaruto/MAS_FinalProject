package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.exception;
/**
 * Unchecked exception that is thrown if something that is checked is null or empty
 */
public class DataValidationException extends RuntimeException {
    /**
     * Constructor
     * @param message will be shown
     */
    public DataValidationException(String message) {
        super(message);
    }
}
