package decorations;


import enums.WrapType;
import products.Product;

public class WrapDecorator extends Product implements Decorator {
    WrapType wrapType;

    public WrapDecorator(String name, int price, WrapType wrapType) {
        super(name, price);
        this.wrapType = wrapType;
    }

    public String getDecorationInfo() {
        return "Wrap from " + wrapType + " price = " + wrapType.getPrice();
    }

    public int getPriceDecoration() {
        return wrapType.getPrice();
    }
}
