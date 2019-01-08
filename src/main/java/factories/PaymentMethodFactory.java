package factories;

import peyments.Cash;
import peyments.CreditCard;
import peyments.DebitCard;
import peyments.PaymentMethod;

public class PaymentMethodFactory {
    public static PaymentMethod getPaymentMethod(String type){
        switch (type) {
            case "credit":
                return createCreditCard();
            case "debit":
                return createDebitCard();
            case "cash":
                return createCash();
        }
        throw new IllegalArgumentException();
    }
    public static CreditCard createCreditCard() {
        return new CreditCard("Test Testovich", "1111111111111111", "111", "01/21");
    }
    public static DebitCard createDebitCard() {
        return new DebitCard("Test Testovich", "1111111111111111", "111", "01/21");
    }
    public static Cash createCash() {
        return new Cash();
    }
}
