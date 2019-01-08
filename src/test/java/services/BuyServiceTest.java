package services;

import decorations.Decorator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import products.Bouquet;
import products.Cactus;
import products.Flower;
import products.Palm;

import java.util.ArrayList;
import java.util.List;

public class BuyServiceTest {
    private Shop shop;
    private List<Flower> flowerList = new ArrayList<Flower>();

    @Before
    public void setUp() {
        shop = new Shop();
        FillShopRandomProductsService.fillBouquets(shop.getBouquetList(), 1);
        FillShopRandomProductsService.fillFlowers(shop.getFlowers(), 1);
        FillShopRandomProductsService.fillCactuses(shop.getCactusList(), 1);
        FillShopRandomProductsService.fillPalms(shop.getPalmList(), 1);
        FillShopRandomProductsService.fillWrapsPotsBoxes(shop.getDecorators(),1);
    }

    @Test
    public void testBuyFlower() {
        Flower flower = shop.getFlowers().get(0);
        flowerList.add(shop.getFlowers().get(0));
        Assert.assertEquals(flower, BuyService.buyFlower(shop, flowerList, 1));
    }

    @Test
    public void testBuyCactus() {
        Cactus cactus = shop.getCactusList().get(0);
        Assert.assertEquals(cactus, BuyService.buyCactus(shop, 1));
    }

    @Test
    public void testBuyPalm() {
        Palm palm = shop.getPalmList().get(0);
        Assert.assertEquals(palm, BuyService.buyPalm(shop, 1));
    }

    @Test
    public void testBuyBouquet() {
        Bouquet bouquet = shop.getBouquetList().get(0);
        Assert.assertEquals(bouquet, BuyService.buyBouquet(shop, 1));
    }

    @Test
    public void testBuyDecoration(){
        Decorator decorator = shop.getDecorators().get(0);
        Assert.assertEquals(decorator,BuyService.buyDecoration(shop,shop.getDecorators().get(0)));
    }
}
