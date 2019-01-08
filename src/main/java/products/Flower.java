package products;

import enums.Color;
import enums.FlowerType;

public class Flower extends Product {
    private boolean imported;
    private FlowerType flowerType;
    private Color color;

    public Flower(String name, int price, boolean imported, Color color, FlowerType flowerType) {
        super(name, price);
        this.imported = imported;
        this.color = color;
        this.flowerType = flowerType;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public FlowerType getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name= " + getName() +
                ", price= " + getPrice() +
                ", imported= " + imported +
                ", flowerType= " + flowerType +
                ", color= " + color +
                "}";
    }
}
