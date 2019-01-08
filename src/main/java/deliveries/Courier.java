package deliveries;

public class Courier implements Delivery {
    private final int pricePercent = 15;

    @Override
    public String getDeliveryInfo() {
        return "Courier deliveries";
    }

    @Override
    public int getDeliveryPrice() {
        return pricePercent;
    }
}
