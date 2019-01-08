package services;

import enums.FlowerType;
import products.Flower;
import Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuxiliaryService {
    public static List<Flower> getSpecificTypeOfFlower(Shop shop, FlowerType flowerType) {
        List<Flower> flowers = new ArrayList<Flower>();
        for (Flower flower : shop.getFlowers()) {
            if (flower.getFlowerType() == flowerType) {
                flowers.add(flower);
            }
        }
        return flowers;
    }

    public static boolean continueOrNot() {
        Scanner scanner = new Scanner(System.in);
        int cont = 0;
        System.out.println("Do you want to continue buy ? 'Yes' press-'1'; 'No' press-'any button';");
        cont = scanner.nextInt();
        return cont == 1;
    }

    public static int getPriceBouquete(List<Flower> flowers) {
        int sum = 0;
        for (Flower p : flowers) {
            sum += p.getPrice();
        }
        return sum;
    }


}
