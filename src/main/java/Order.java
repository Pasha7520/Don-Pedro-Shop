import deliveries.Delivery;
import products.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Product> goods = new ArrayList<Product>();
    Delivery delivery ;

    public List<Product> getGoods() {
        return goods;
    }

    public void setGoods(List<Product> goods) {
        this.goods = goods;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
