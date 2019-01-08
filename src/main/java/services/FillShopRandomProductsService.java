package services;

import decorations.Decorator;
import enums.*;
import factories.ProductFactory;
import products.Bouquet;
import products.Cactus;
import products.Flower;
import products.Palm;

import java.util.List;

public class FillShopRandomProductsService {

    public static void fillShop(Shop shop){
        fillBouquets(shop.getBouquetList(),8);
        fillFlowers(shop.getFlowers(),40);
        fillCactuses(shop.getCactusList(),10);
        fillPalms(shop.getPalmList(),7);
        fillWrapsPotsBoxes(shop.getDecorators(),10);
    }

    public static void fillBouquets(List<Bouquet> bouquets, int count) {
        for (int i = 1; i <= count; i++) {
            Bouquet bouquet = ProductFactory.createBouquet();
            int length = (int) (Math.random() * 30);
            if (length < 10) {
                bouquet.setDecorator(ProductFactory.createDecorator(WrapType.PAPER));
            } else if (length < 20) {
                bouquet.setDecorator(ProductFactory.createDecorator(WrapType.CARDBOARD));
            } else {
                bouquet.setDecorator(ProductFactory.createDecorator(WrapType.CELLOPHANE));
            }
            if (length < 5) length = 5;
            if (length % 2 == 0) length += 1;
            fillFlowers(bouquet.getFlowers(),length);
            bouquet.setPrice(AuxiliaryService.getPriceBouquete(bouquet.getFlowers()));
            bouquets.add(bouquet);
        }
    }
    public static void fillFlowers(List<Flower> flowerList, int count){
        for (int i = 1; i <= count; i++) {
            int res = (int) (Math.random() * 10);
            if (res <= 2) {
                flowerList.add(ProductFactory.createFlower(FlowerType.TULIP,
                        10 + (int) (Math.random() * 3),true,Color.RED));
            } else if (res <= 5) {
                flowerList.add(ProductFactory.createFlower(FlowerType.MARIGOLD,
                        10 + (int) (Math.random() * 3), true, Color.BLUE));
            } else if (res <= 7) {
                flowerList.add(ProductFactory.createFlower(FlowerType.SNOWDROPS,
                        10 + (int) (Math.random() * 3), true, Color.YELLOW));
            } else {
                flowerList.add(ProductFactory.createFlower(FlowerType.ROSE,
                        10 + (int) (Math.random() * 3), true, Color.RED));
            }
        }
    }
    public static void fillCactuses(List<Cactus> cactusList, int count){
        for (int i = 1; i <= count; i++) {
            int res = (int) (Math.random() * 10);
            if (res <= 5) {
                cactusList.add(ProductFactory.createCactus(CactusType.FLOWERING,30 + (int) (Math.random() * 3)));
            } else {
                cactusList.add(ProductFactory.createCactus(CactusType.GARDENING,30 + (int) (Math.random() * 3)));
            }
        }
    }
    public static void fillPalms(List<Palm> palmList, int count){
        for (int i = 1; i <= count; i++) {
            palmList.add(ProductFactory.createPalm(true,90 + (int) (Math.random() * 3)));
        }
    }
    public static void fillWrapsPotsBoxes(List<Decorator> decoratorList,int count){
        for (int i = 1; i <= count; i++) {
            decoratorList.add(ProductFactory.createDecorator(WrapType.PAPER));
            decoratorList.add(ProductFactory.createDecorator(WrapType.CARDBOARD));
            decoratorList.add(ProductFactory.createDecorator(WrapType.CELLOPHANE));
            decoratorList.add(ProductFactory.createDecorator(BoxType.USUAL));
            decoratorList.add(ProductFactory.createDecorator(BoxType.HANDMADE));
            decoratorList.add(ProductFactory.createDecorator(BoxType.DECORATED));
            decoratorList.add(ProductFactory.createDecorator(PotType.EARTHEN));
            decoratorList.add(ProductFactory.createDecorator(PotType.IRON));
            decoratorList.add(ProductFactory.createDecorator(PotType.PLASTIC));
        }
    }
}
