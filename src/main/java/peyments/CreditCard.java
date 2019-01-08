package peyments;

public class CreditCard extends Card {

    public CreditCard(String nameOnCard, String number, String cvv, String expirationDate) {
        super(nameOnCard, number, cvv, expirationDate);
    }

    public String getType() {
        return "credit";
    }

}
