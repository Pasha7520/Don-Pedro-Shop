package products;

import enums.CactusType;

import java.util.Comparator;

public class Cactus extends Product {
    private CactusType cactusType;

    public Cactus(String name, int price, CactusType cactusType) {
        super(name, price);
        this.cactusType = cactusType;
    }

    public CactusType getCactusType() {
        return cactusType;
    }

    public void setCactusType(CactusType cactusType) {
        this.cactusType = cactusType;
    }

    @Override
    public String toString() {
        return "Cactus{" +
                "name= " + getName() +
                ", price= " + getPrice() + "$" +
                ", cactusType=" + cactusType +
                '}';
    }

    public static Comparator<Cactus> cactusComparator = new Comparator<Cactus>() {
        public int compare(Cactus c1, Cactus c2) {
            return c1.getCactusType().compareTo(c2.cactusType);
        }
    };
}
