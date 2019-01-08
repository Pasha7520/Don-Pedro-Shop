package decorations;

import enums.BoxType;
import products.Product;

public class BoxDecorator extends Product implements Decorator {
    BoxType boxType;

    public BoxDecorator(String name, int price, BoxType boxType) {
        super(name, price);
        this.boxType = boxType;
    }

    public String getDecorationInfo() {
        return "Box type : " + boxType + " price = " + boxType.getPrice();
    }

    public int getPriceDecoration() {
        return boxType.getPrice();
    }
}
