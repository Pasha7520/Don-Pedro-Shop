package services;

import decorations.Decorator;
import products.Bouquet;
import products.Cactus;
import products.Flower;
import products.Palm;

import java.util.List;

public class BuyService {
    //якщо вибрано існуючий номер квітки - видаляємо її !!
    public static Flower buyFlower(Shop shop, List<Flower> flowers, int number) {
        Flower flower = null;
        for (int i = 0; i < flowers.size(); i++) {
            if (i == number - 1) {
                flower = flowers.get(number - 1);
            }
        }
        for (int i = 0; i < shop.getFlowers().size(); i++) {
            if (shop.getFlowers().get(i).equals(flower)) {
                shop.getFlowers().remove(i);
                return flower;
            }
        }
        System.out.println("No such number of flower!!");
        return null;
    }

    //якщо вибрано існуючий номер кактусу - видаляємо його !!
    public static Cactus buyCactus(Shop shop, int number) {
        for (int i = 0; i < shop.getCactusList().size(); i++) {
            if (i == number - 1) {
                Cactus cactus = shop.getCactusList().get(number - 1);
                shop.getCactusList().remove(number - 1);
                return cactus;
            }
        }
        System.out.println("No such number of cactus!!");
        return null;

    }

    //якщо вибрано ыснуючий номер пальми - видаляємо її !!
    public static Palm buyPalm(Shop shop, int number) {
        for (int i = 0; i < shop.getPalmList().size(); i++) {
            if (i == number - 1) {
                Palm palm = shop.getPalmList().get(number - 1);
                shop.getPalmList().remove(number - 1);
                return palm;
            }
        }
        System.out.println("No such number of palm!!");
        return null;
    }

    public static Bouquet buyBouquet(Shop shop, int number) {
        for (int i = 0; i < shop.getBouquetList().size(); i++) {
            if (i == number - 1) {
                Bouquet bouquet = shop.getBouquetList().get(number - 1);
                shop.getBouquetList().remove(number - 1);
                return bouquet;
            }
        }
        System.out.println("No such number of bouquet");
        return null;
    }
    public static Decorator buyDecoration(Shop shop, Decorator decorator){
        for (Decorator d : shop.getDecorators()) {
            if(d.getDecorationInfo().equals(decorator.getDecorationInfo())){
                Decorator decorator1 = d;
                shop.getDecorators().remove(d);
                return decorator1;
            }
        }
        System.out.println("Temporarily absent in shop!");
        return null;
    }

}
