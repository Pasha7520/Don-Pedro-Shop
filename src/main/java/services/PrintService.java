package services;

import products.Bouquet;
import products.Cactus;
import products.Flower;
import products.Palm;

import java.util.Collections;
import java.util.List;

public class PrintService {
    //виводить квіти
    public static boolean printFlowers(List<Flower> flowers) {
        String type = "";
        if (!(flowers.isEmpty())) {
            type = flowers.get(0).getFlowerType().toString();
        } else {
            System.out.println("There no this kind of flowers in this shop!");
            return false;
        }
        System.out.println(type + "!");
        int i = 1;
        for (Flower flower : flowers) {
            System.out.println(i + ":" + flower);
            i++;
        }
        System.out.println();
        return true;
    }

    //виводить кактуси
    public static boolean printCactuses(Shop shop) {
        List<Cactus> cactusList = shop.getCactusList();
        Collections.sort(cactusList, Cactus.cactusComparator);
        System.out.println("Cactus !!");
        int i = 1;
        if (shop.getCactusList().isEmpty()) {
            System.out.println("There no cactus in this shop");
            return false;
        }
        for (Cactus cactus : shop.getCactusList()) {
            System.out.println(i + ":" + cactus);
            i++;
        }
        System.out.println();
        return true;
    }

    //виводить пальми
    public static boolean printPalms(Shop shop) {
        System.out.println("Palms");
        int i = 1;
        if (shop.getPalmList().isEmpty()) {
            System.out.println("There no palms in this shop");
            return false;
        }
        for (Palm palm : shop.getPalmList()) {
            System.out.println(i + ":" + palm);
            i++;
        }
        System.out.println();
        return true;
    }

    public static boolean printSet(List<Flower> flowers) {
        System.out.println("Your set constructed from:");
        if(flowers.isEmpty()){
            return false;
        }
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
        return true;
    }

    public static boolean printReadyBouquet(Shop shop) {
        System.out.println("Bouquets");
        int i = 1;
        if (shop.getBouquetList().isEmpty()) {
            System.out.println("There no ready bouquets in this shop");
            return false;
        }
        for (Bouquet bouquet : shop.getBouquetList()) {
            int j = 0;
            System.out.println(i + ") Bouquet price = "+bouquet.getPrice()+"$ ; consist from: ");
                for(Flower flower : bouquet.getFlowers()){
                    j++;
                    System.out.println("     flower "+j+": "+flower.getFlowerType()+", color: "+flower.getColor()+" ;");
                }
            i++;
        }
        return true;
    }
}
