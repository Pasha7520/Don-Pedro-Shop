package menu;

import decorations.BoxDecorator;
import decorations.PotDecorator;
import decorations.WrapDecorator;
import enums.BoxType;
import enums.FlowerType;
import enums.PotType;
import enums.WrapType;
import peyments.PaymentMethod;
import factories.PaymentMethodFactory;
import services.AuxiliaryService;
import services.BuyService;
import services.ChoiceService;
import services.PrintService;
import factories.DeliverFactory;
import products.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersMenu {
    public static void menuShop(Shop shop) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        System.out.println("Welcome to Don Pedro shop !!");
        int cont = 1;
        while (cont == 1 || cont == 2) {
            System.out.println("To buy some products press-1; Watch additional services press-2; Exit(pay off) press-Any other button");
            cont = scanner.nextInt();
            if (cont == 1) {
                choiceGoods(shop, order);
            } else if (cont == 2) {
                additionalServices(shop, order);
            }
        }
        if (!(order.getGoods().isEmpty())) {
            choiceDelivery(order);
            payForOrder(order);
        }
        System.out.println("Goodbye!!");
    }

    public static void choiceGoods(Shop shop, Order order) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listGoods = new ArrayList<Integer>();
        boolean loop = true;
        int pot = 0;
        int number = 0;
        int cont = 0;
        while (loop) {
            System.out.println("Flowers press-'1'; Cactuses press-'2'; Palms press-'3';");
            int choice = scanner.nextInt();
            if (choice == 1) {
                flowersChoiceLoop(order, shop, 0);
            } else if (choice == 2) {
                if (PrintService.printCactuses(shop)) {
                    System.out.println("press number of the cactus:");
                    number = scanner.nextInt();
                    Cactus cactus = BuyService.buyCactus(shop, number);
                    if (cactus != null) {
                        order.getGoods().add(cactus);
                        System.out.println("Do you want buy earthen pot for" + PotType.EARTHEN.getPrice() + "$ yes press -'1';" +
                                "Do you want buy iron pot for" + PotType.IRON.getPrice() + "$ yes press -'2';" +
                                "Do you want buy plastic pot for" + PotType.PLASTIC.getPrice() + "$ yes press -'3'; don't want pot -'any other button'");
                        pot = scanner.nextInt();
                        if (pot == 1 || pot == 2 || pot == 3) {
                            order.getGoods().add((PotDecorator) BuyService.buyDecoration(shop, ChoiceService.choicePotType(pot)));
                        }
                    }
                }
            } else if (choice == 3) {
                if (PrintService.printPalms(shop)) {
                    System.out.println("press number of the palm:");
                    number = scanner.nextInt();
                    Palm palm = BuyService.buyPalm(shop, number);
                    if (palm != null) order.getGoods().add(palm);
                }

            } else System.out.println("No such category!!");
            loop = AuxiliaryService.continueOrNot();
        }
    }

    public static void additionalServices(Shop shop, Order order) {
        Scanner scanner = new Scanner(System.in);
        int cont = 0;
        int choice = 0;
        boolean loop = true;
        while (loop) {
            System.out.println("Ready bouquet press-'1'; Make bouquet press-'2'; " +
                    "Design packaging of flowers press-'3'; Exit press-'any other button';");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    choiceReadyBouquet(shop, order);
                    break;
                case 2:
                    makeBouquet(shop, order);
                    break;
                case 3:
                    designPackaging(shop, order);
                    break;
                default:
                    return;
            }
            return;
        }
    }

    public static void choiceReadyBouquet(Shop shop, Order order) {
        Scanner scanner = new Scanner(System.in);
        int cont = 0;
        int number = 0;
        boolean loop = true;
        while (loop) {
            if (PrintService.printReadyBouquet(shop)) {
                System.out.println("press number of the bouquet");
                number = scanner.nextInt();
                Bouquet bouquet = BuyService.buyBouquet(shop, number);
                if (bouquet != null) {
                    order.getGoods().add(bouquet);
                }
            }
            loop = AuxiliaryService.continueOrNot();
        }
    }

    public static void makeBouquet(Shop shop, Order order) {
        Scanner scanner = new Scanner(System.in);
        List<Flower> flowers;
        int wrap = 0;
        System.out.println("You have to choose minimum five flowers");
        flowersChoiceLoop(order, shop, 5);
        System.out.println("Do you want paper wrap for " + WrapType.PAPER.getPrice() + "$ press-'1';" +
                " cardboard wrap for " + WrapType.CARDBOARD.getPrice() + "$ press-'2';" +
                " cellophane wrap for " + WrapType.CELLOPHANE.getPrice() + "$ free press-'any other button'");
        wrap = scanner.nextInt();
        order.getGoods().add((WrapDecorator) BuyService.buyDecoration(shop, ChoiceService.choiceWrapType(wrap)));
    }

    public static void designPackaging(Shop shop, Order order) {
        Scanner scanner = new Scanner(System.in);
        List<Flower> flowers;
        int box = 0;
        System.out.println("You have to choose minimum ten flowers");
        flowersChoiceLoop(order, shop, 10);
        System.out.println("Do you want decorated box for " + BoxType.DECORATED.getPrice() + "$ press -'1';" +
                " handmade box for " + BoxType.HANDMADE.getPrice() + "$ -'2';" +
                " usual box for " + BoxType.USUAL.getPrice() + "$ press-'any other button'");
        box = scanner.nextInt();
        order.getGoods().add((BoxDecorator) BuyService.buyDecoration(shop, ChoiceService.choiceBoxType(box)));
    }

    public static void flowersChoiceLoop(Order order, Shop shop, int minSize) {
        Scanner scanner = new Scanner(System.in);
        List<Flower> flowers;
        int number = 0;
        boolean loop = true;
        int minimum = 0;
        int cont = 0;
        if (shop.getFlowers().size() < minSize) {
            System.out.println("Unfortunately, there are not enough flowers to create a design packaging");
            return;
        }
        while (loop) {
            System.out.println("Tulip press-'1'; Rose press-'2'; Marigold-'3'; Snowdrops-'4';");
            int choice = scanner.nextInt();
            if (choice == 1) {
                flowers = AuxiliaryService.getSpecificTypeOfFlower(shop, FlowerType.TULIP);
                if (PrintService.printFlowers(flowers)) {
                    System.out.println("press number of the tulip :");
                    number = scanner.nextInt();
                    Flower flower = BuyService.buyFlower(shop, flowers, number);
                    if (flower != null) {
                        order.getGoods().add(flower);
                    }
                    minimum++;
                }
            } else if (choice == 2) {
                flowers = AuxiliaryService.getSpecificTypeOfFlower(shop, FlowerType.ROSE);
                if (PrintService.printFlowers(flowers)) {
                    System.out.println("press number of the rose :");
                    number = scanner.nextInt();
                    Flower flower = BuyService.buyFlower(shop, flowers, number);
                    if (flower != null) {
                        order.getGoods().add(flower);
                    }
                    minimum++;
                }
            } else if (choice == 3) {
                flowers = AuxiliaryService.getSpecificTypeOfFlower(shop, FlowerType.MARIGOLD);
                if (PrintService.printFlowers(flowers)) {
                    System.out.println("press number of the marigold :");
                    number = scanner.nextInt();
                    Flower flower = BuyService.buyFlower(shop, flowers, number);
                    if (flower != null) {
                        order.getGoods().add(flower);
                    }
                    minimum++;
                }
            } else if (choice == 4) {
                flowers = AuxiliaryService.getSpecificTypeOfFlower(shop, FlowerType.SNOWDROPS);
                if (PrintService.printFlowers(flowers)) {
                    System.out.println("press number of the snowdrops :");
                    number = scanner.nextInt();
                    Flower flower = BuyService.buyFlower(shop, flowers, number);
                    if (flower != null) {
                        order.getGoods().add(flower);
                    }
                    minimum++;
                }
            } else {
                System.out.println("No such category !!");
            }
            if (minimum >= minSize) {
                loop = AuxiliaryService.continueOrNot();
            }
        }
    }

    public static void payForOrder(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to pay: ");
        int payment = 0, index = 0, buqSum = 0, flSum = 0, cactSum = 0, palmSum = 0, decSum = 0, delSum = 0, sum = 0;
        for (Product product : order.getGoods()) {
            if (product instanceof Bouquet) {
                buqSum += product.getPrice();
                System.out.println(++index + ") for bouquet " + product.getName() + ", price = " + product.getPrice() + "$; ");
            } else if (product instanceof Flower) {
                flSum += product.getPrice();
                Flower flower = (Flower) product;
                System.out.println(++index + ") for flower " + flower.getFlowerType() + ", price = " + product.getPrice() + "$; ");
            } else if (product instanceof Cactus) {
                cactSum += product.getPrice();
                System.out.println(++index + ") for cactus " + product.getName() + ", price = " + product.getPrice() + "$; ");
            } else if (product instanceof Palm) {
                palmSum += product.getPrice();
                System.out.println(++index + ") for palm " + product.getName() + ", price = " + product.getPrice() + "$; ");
            } else {
                decSum += product.getPrice();
                System.out.println(++index + ") for additional services = " + product.getName() + ",price = " + product.getPrice() + "$; ");
            }
        }

        sum = flSum + cactSum + palmSum + buqSum + decSum;
        delSum = (int) ((double) sum * ((double) order.getDelivery().getDeliveryPrice() / (double) 100));
        sum += delSum;
        System.out.println(" for deliveries " + order.getDelivery().getDeliveryInfo() + " = " + delSum + "$");
        System.out.println(" all sum = " + sum + "$;");
        System.out.println("What kind of payment do you prefer to use Credit Card press-'1';" +
                " Debit Card press-'2'; Cash press-'any other button';");
        payment = scanner.nextInt();
        PaymentMethod paymentMethod;
        switch (payment) {
            case 1:
                paymentMethod = PaymentMethodFactory.getPaymentMethod("credit");
                break;
            case 2:
                paymentMethod = PaymentMethodFactory.getPaymentMethod("debit");
                break;
            default:
                paymentMethod = PaymentMethodFactory.getPaymentMethod("cash");
                break;
        }
        paymentMethod.pay(sum);
    }

    public static void choiceDelivery(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What kind of deliveries do you prefer? Courier press-'1';" +
                " New post press-'2'; Ukr post press-'3'; Self pickup press-'any other button';");
        switch (scanner.nextInt()) {
            case 1:
                order.setDelivery(DeliverFactory.getDelivery("Courier"));
                break;
            case 2:
                order.setDelivery(DeliverFactory.getDelivery("New Post"));
                break;
            case 3:
                order.setDelivery(DeliverFactory.getDelivery("Ukr Post"));
                break;
            default:
                order.setDelivery(DeliverFactory.getDelivery("Self"));
                break;
        }
    }
}
