package hu.voga.space.controller.response;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to create validation error messages.
 */
public class ValidationErrorMessage extends ErrorMessage {
  private final Map<String, String> errorsInFields = new HashMap<>();

  public ValidationErrorMessage() {
    setMessageMessage("ValidationError");
  }

  public Map<String, String> getErrorsInFields() {
    return errorsInFields;
  }

  public static ValidationErrorMessage createValidationErrorMessage(
    BindingResult bindingResult) {
    if (!bindingResult.hasErrors()) {
      throw new IllegalArgumentException("Binding result has to have errors.");
    }
    ValidationErrorMessage validationErrorMessage = new ValidationErrorMessage();
    for (FieldError fieldError : bindingResult.getFieldErrors()) {
      Map<String, String> errorsInFields = validationErrorMessage.getErrorsInFields();
      errorsInFields.put(fieldError.getField(), fieldError.getDefaultMessage());
    }
    return validationErrorMessage;
  }

}
