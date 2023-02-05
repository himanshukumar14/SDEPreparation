package FoodKart.src.Exceptions;

public class UserAlreadyPresent extends  RuntimeException {
    public UserAlreadyPresent(String message) {
        super(message);
    }
}
