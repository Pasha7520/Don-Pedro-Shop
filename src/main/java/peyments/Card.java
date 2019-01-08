package peyments;

import java.text.MessageFormat;

public abstract class Card implements PaymentMethod {
    private final String nameCard;
    private final String number;
    private final String cvv;
    private final String endDate;

    public Card(String nameCard, String number, String cvv, String endDate) {
        this.nameCard = nameCard;
        this.number = number;
        this.cvv = cvv;
        this.endDate = endDate;
    }

    public void pay(int dollars){
        System.out.println("Payed " + dollars + " dollars using " + toString());
    }
    public abstract String getType();

    @Override
    public String toString() {
        return MessageFormat.format("{0} card[name = {1}, number = {2}, CVV = {3}, expiration = {4}]", getType(), nameCard, number, cvv, endDate);
    }
}
