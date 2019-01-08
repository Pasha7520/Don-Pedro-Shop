package enums;

public enum WrapType {
    PAPER(2), CARDBOARD(3), CELLOPHANE(0);

    private int price;

    WrapType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
