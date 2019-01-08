package enums;

public enum PotType {
    EARTHEN(14), PLASTIC(9), IRON(12);

    private int price;

    PotType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
