import Booking;
import Driver;
import PaymentReceipt;
import Rider;

public interface IBookingService {

    Booking book(Rider rider);
    boolean acceptBooking(Booking booking, Driver driver);
    void cancel(Booking booking);
    PaymentReceipt makePayment(Booking booking);

}
