package hu.voga.space.controller.response;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;

/**
 * Used to create responses.
 */
public class Response {
  private Object payload;
  private ResponseType type;

  public Response() {
  }

  public Response(Object payload, ResponseType type) {
    this.payload = payload;
    this.type = type;
  }

  public static Response createErrorResponse(ErrorMessage e) {
    return new Response(e, ResponseType.ERROR);
  }

  public static Response createErrorResponse(Exception e) {
    if (e == null) {
      throw new NullPointerException("Exception cannot be null.");
    }

    if (e.getCause() != null) {
      return createErrorResponse(
              new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), e.getClass().getName(),
                      e.getCause().getMessage(), e.getCause().getClass().getName())
      );
    }
    return createErrorResponse(
            new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), e.getClass().getName()));
  }

  public static Response createErrorResponse(Exception e, String userReadableMessage) {
    if (e == null) {
      throw new NullPointerException("Exception cannot be null.");
    }
    if (userReadableMessage == null) {
      throw new NullPointerException("UserReadableMessage cannot be null.");
    }

    if (e.getCause() != null) {
      return createErrorResponse(
              new ErrorMessage(e.getMessage(), userReadableMessage, e.getClass().getName(),
                      e.getCause().getMessage(), e.getCause().getClass().getName())
      );
    }
    return createErrorResponse(
            new ErrorMessage(e.getMessage(), userReadableMessage, e.getClass().getName()));
  }

  public static Response createOKResponse(Object payload) {
    return new Response(payload, ResponseType.OK);
  }

  public static Response createValidationErrorResponse(BindingResult bindingResult) {
    if (!bindingResult.hasErrors()) {
      throw new IllegalArgumentException("Binding result has to have errors.");
    }
    ValidationErrorMessage validationErrorMessage = new ValidationErrorMessage();
    for (FieldError fieldError : bindingResult.getFieldErrors()) {
      Map<String, String> errorsInFields = validationErrorMessage.getErrorsInFields();
      errorsInFields.put(fieldError.getField(), fieldError.getDefaultMessage());
    }
    return new Response(validationErrorMessage, ResponseType.VALIDATION_ERROR);
  }

  public static Response createNoDataResponse() {
    return createNoDataResponse("");
  }

  public static Response createNoDataResponse(Object payload) {
    return new Response(payload, ResponseType.NO_DATA);
  }

  public Object getPayload() {
    return payload;
  }

  public void setPayload(Object payload) {
    this.payload = payload;
  }

  public ResponseType getType() {
    return type;
  }

  public void setType(ResponseType type) {
    this.type = type;
  }

}
