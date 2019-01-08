package enums;

public enum BoxType {
    USUAL(8),DECORATED(12),HANDMADE(20);

    private int price;

    BoxType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
