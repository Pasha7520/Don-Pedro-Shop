package products;

public class Palm extends Product {
    private boolean fruit;

    public Palm(String name, int price, boolean fruit) {
        super(name, price);
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "Palm{" +
                "name=" + getName() +
                ", price=" + getPrice() + "$" +
                "}";
    }
}
