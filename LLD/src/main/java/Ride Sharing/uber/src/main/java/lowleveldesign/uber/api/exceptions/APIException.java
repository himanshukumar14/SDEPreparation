public class APIException extends RuntimeException {
    public APIException(final String errorMessage) {
        super(errorMessage);
    }
}
