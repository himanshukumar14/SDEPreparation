package ParkingLot;

public class Payment {
    private String id;
    private String amount;
    private String payee;
    private String payer;
    private String timestamp;
    private PaymentStatus paymentStatus;

    public Payment(String id, String amount, String payee, String payer, String timestamp, PaymentStatus paymentStatus) {
        this.id = id;
        this.amount = amount;
        this.payee = payee;
        this.payer = payer;
        this.timestamp = timestamp;
        this.paymentStatus = paymentStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
