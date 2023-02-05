package FoodKart.src.Exceptions;

public class RestaurantNotPresent extends RuntimeException {
    public RestaurantNotPresent(String message) {
        super(message);
    }
}
