package deliveries;

public class UkrPost implements Delivery {
    private final int pricePercent = 6;

    @Override
    public String getDeliveryInfo() {
        return "Ukr post deliveries";
    }

    @Override
    public int getDeliveryPrice() {
        return pricePercent;
    }
}
