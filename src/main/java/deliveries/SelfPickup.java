package deliveries;

public class SelfPickup implements Delivery {
    private static int pricePercent = 0;

    @Override
    public String getDeliveryInfo() {
        return "Self pickup";
    }

    @Override
    public int getDeliveryPrice() {
        return pricePercent;
    }
}
