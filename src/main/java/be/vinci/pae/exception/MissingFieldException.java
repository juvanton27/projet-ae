package be.vinci.pae.exception;

public class MissingFieldException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public MissingFieldException() {
    super();
  }

  public MissingFieldException(String message) {
    super(message);
  }
}
