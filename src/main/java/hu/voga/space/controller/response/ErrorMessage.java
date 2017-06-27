package hu.voga.space.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Used to create error responses.
 */
public class ErrorMessage {

  private String messageMessage;
  private String userReadableMessage;
  @JsonProperty("class")
  private String clazz;
  private String causeMessage;
  private String causeClass;

  public ErrorMessage() {
  }

  public ErrorMessage(String messageMessage, String userReadableMessage,
                      String clazz, String causeMessage, String causeClass) {
    this.messageMessage = messageMessage;
    this.userReadableMessage = userReadableMessage;
    this.clazz = clazz;
    this.causeMessage = causeMessage;
    this.causeClass = causeClass;
  }

  public ErrorMessage(String messageMessage, String userReadableMessage, String clazz) {
    this.messageMessage = messageMessage;
    this.userReadableMessage = userReadableMessage;
    this.clazz = clazz;
  }

  public String getCauseClass() {
    return causeClass;
  }

  public void setCauseClass(String causeClass) {
    this.causeClass = causeClass;
  }

  public String getMessageMessage() {
    return messageMessage;
  }

  public void setMessageMessage(String messageMessage) {
    this.messageMessage = messageMessage;
  }

  public String getUserReadableMessage() {
    return userReadableMessage;
  }

  public void setUserReadableMessage(String userReadableMessage) {
    this.userReadableMessage = userReadableMessage;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  public String getCauseMessage() {
    return causeMessage;
  }

  public void setCauseMessage(String causeMessage) {
    this.causeMessage = causeMessage;
  }
}
