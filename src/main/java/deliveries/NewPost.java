package deliveries;

public class NewPost implements Delivery {
    private final int pricePercent = 8;

    @Override
    public String getDeliveryInfo() {
        return "New post deliveries";
    }

    @Override
    public int getDeliveryPrice() {
        return pricePercent;
    }
}
