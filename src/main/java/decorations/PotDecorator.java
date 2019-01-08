package decorations;

import enums.PotType;
import products.Product;

public class PotDecorator extends Product implements Decorator {
    PotType potType;

    public PotDecorator(String name, int price, PotType potType) {
        super(name, price);
        this.potType = potType;
    }

    public String getDecorationInfo() {
        return "Pot from " + potType + " price = " + potType.getPrice();
    }

    public int getPriceDecoration() {
        return potType.getPrice();
    }
}
