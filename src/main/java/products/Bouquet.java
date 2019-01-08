package products;

import decorations.Decorator;

import java.util.ArrayList;
import java.util.List;

public class Bouquet extends Product {
    private List<Flower> flowers = new ArrayList<Flower>();
    private Decorator decorator;

    public Bouquet(String name, int price, List<Flower> flowers, Decorator decorator) {
        super(name, price);
        this.flowers = flowers;
        this.decorator = decorator;
    }

    public Bouquet(String name, int price) {
        super(name, price);
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public Decorator getDecorator() {
        return decorator;
    }

    public void setDecorator(Decorator decorator) {
        this.decorator = decorator;
    }


}
