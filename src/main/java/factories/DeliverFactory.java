package factories;

import deliveries.*;

public class DeliverFactory {

    public static Delivery getDelivery(String typeDelivery){
        switch (typeDelivery){
            case "Courier":
                return new Courier();
            case "New Post":
                return new NewPost();
            case "Ukr Post":
                return new UkrPost();
            default:
                return new SelfPickup();
        }
    }
}
