package peyments;

public class Cash implements PaymentMethod {
    public void pay(int dollars) {
        System.out.println("Payed " + dollars + " dollars using cash");
    }
}
