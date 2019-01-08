package peyments;

public class DebitCard extends Card {

    public DebitCard(String nameCard, String number, String cvv, String endDate) {
        super(nameCard, number, cvv, endDate);
    }

    public String getType() {
        return "debit";
    }
}
