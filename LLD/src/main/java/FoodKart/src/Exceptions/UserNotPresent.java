package FoodKart.src.Exceptions;

public class UserNotPresent  extends  RuntimeException{
    public UserNotPresent(String message) {
        super(message);
    }
}
