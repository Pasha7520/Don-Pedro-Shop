package factories;

import decorations.BoxDecorator;
import decorations.Decorator;
import decorations.PotDecorator;
import decorations.WrapDecorator;
import products.Bouquet;
import products.Cactus;
import enums.*;
import products.Flower;
import products.Palm;

public class ProductFactory {
    private static int index = 1;

    public static Bouquet createBouquet(){
        return new Bouquet("bq-"+index++,0);
    }

    public static Cactus createCactus(CactusType cactusType, int price) {
        switch (cactusType) {
            case FLOWERING:
                return new Cactus("c-" + index++, price, CactusType.FLOWERING);
            case GARDENING:
                return new Cactus("c-" + index++, price, CactusType.GARDENING);
        }
        return null;
    }

    public static Flower createFlower(FlowerType flowerType, int price, boolean imported, Color color) {
        switch (flowerType) {
            case ROSE:
                return new Flower("f-" + index++, 10 + (int) (Math.random() * 3), true, Color.RED, FlowerType.ROSE);
            case TULIP:
                return new Flower("f-" + index++, 10 + (int) (Math.random() * 3), true, Color.BLACK, FlowerType.TULIP);
            case MARIGOLD:
                return new Flower("f-" + index++, 10 + (int) (Math.random() * 3), true, Color.BLUE, FlowerType.MARIGOLD);
            case SNOWDROPS:
                return new Flower("f-" + index++, 10 + (int) (Math.random() * 3), true, Color.YELLOW, FlowerType.SNOWDROPS);
        }
        return null;
    }

    public static Palm createPalm(boolean fruit, int price) {
        if (fruit) {
            return new Palm("pf-" + index++, price, true);
        } else {
            return new Palm("pnf-" + index++, 90 + (int) (Math.random() * 3), false);
        }
    }

    public static Decorator createDecorator(BoxType boxType) {
        switch (boxType) {
            case USUAL:
                return new BoxDecorator("box-" + index++, BoxType.USUAL.getPrice(), BoxType.USUAL);
            case DECORATED:
                return new BoxDecorator("box-" + index++, BoxType.DECORATED.getPrice(), BoxType.DECORATED);
            case HANDMADE:
                return new BoxDecorator("box-" + index++, BoxType.HANDMADE.getPrice(), BoxType.HANDMADE);
        }
        return null;
    }

    public static Decorator createDecorator(WrapType wrapType) {
        switch (wrapType) {
            case PAPER:
                return new WrapDecorator("w-" + index++, WrapType.PAPER.getPrice(), WrapType.PAPER);
            case CARDBOARD:
                return new WrapDecorator("w-" + index++, WrapType.CARDBOARD.getPrice(), WrapType.CARDBOARD);
            case CELLOPHANE:
                return new WrapDecorator("w-" + index++, WrapType.CELLOPHANE.getPrice(), WrapType.CELLOPHANE);
        }
        return null;
    }

    public static Decorator createDecorator(PotType potType) {
        switch (potType) {
            case IRON:
                return new PotDecorator("pot-" + index++, PotType.IRON.getPrice(), PotType.IRON);
            case EARTHEN:
                return new PotDecorator("pot-" + index++, PotType.EARTHEN.getPrice(), PotType.EARTHEN);
            case PLASTIC:
                return new PotDecorator("pot-" + index++, PotType.PLASTIC.getPrice(), PotType.PLASTIC);
        }
        return null;
    }
}
