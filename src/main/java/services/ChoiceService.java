package services;

import decorations.Decorator;
import enums.BoxType;
import enums.PotType;
import enums.WrapType;
import factories.ProductFactory;

public class ChoiceService {
    public static Decorator choicePotType(int number) {
        switch (number) {
            case 1:
                return ProductFactory.createDecorator(PotType.EARTHEN);
            case 2:
                return ProductFactory.createDecorator(PotType.IRON);
            case 3:
                return ProductFactory.createDecorator(PotType.PLASTIC);
            default:
                return null;
        }
    }

    public static Decorator choiceWrapType(int number){
        switch (number) {
            case 1:
                return ProductFactory.createDecorator(WrapType.PAPER);
            case 2:
                return ProductFactory.createDecorator(WrapType.CARDBOARD);
            case 3:
                return ProductFactory.createDecorator(WrapType.CELLOPHANE);
            default:
                return null;
        }
    }
    public static Decorator choiceBoxType(int number){
        switch (number) {
            case 1:
                return ProductFactory.createDecorator(BoxType.DECORATED);
            case 2:
                return ProductFactory.createDecorator(BoxType.HANDMADE);
            case 3:
                return ProductFactory.createDecorator(BoxType.USUAL);
            default:
                return null;
        }
    }
}
