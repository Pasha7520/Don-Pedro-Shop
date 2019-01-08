package services;

import enums.Color;
import enums.FlowerType;
import products.Flower;
import Shop;
import factories.ProductFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AuxiliaryServiceTest {
    private Shop shop;
    private List<Flower> flowers = new ArrayList<Flower>();
    int bouquetPrice;

    @Before
    public void setUp() {
        shop = new Shop();
        for (int i = 1; i < 40; i++) {
            int res = (int) (Math.random() * 10);
            if (res <= 2) {
                Flower flower = ProductFactory.createFlower(FlowerType.TULIP,10 + (int) (Math.random() * 3),true,Color.BLACK);
                shop.getFlowers().add(flower);
                flowers.add(flower);
                bouquetPrice += flower.getPrice();
            } else if (res <= 5) {
                shop.getFlowers().add(ProductFactory.createFlower(FlowerType.MARIGOLD,10 + (int) (Math.random() * 3),true,Color.BLUE));
            } else if (res <= 7) {
                shop.getFlowers().add(ProductFactory.createFlower(FlowerType.SNOWDROPS,10 + (int) (Math.random() * 3),true,Color.BLUE));
            } else {
                shop.getFlowers().add(ProductFactory.createFlower(FlowerType.ROSE,10 + (int) (Math.random() * 3),true,Color.RED));
            }
        }
    }


    @Test
    public void testGetSpecificTypeOfFlower() {
        Assert.assertEquals(flowers, AuxiliaryService.getSpecificTypeOfFlower(shop, FlowerType.TULIP));
    }

    @Test
    public void testGetPriceBouquet() {
        Assert.assertEquals(bouquetPrice, AuxiliaryService.getPriceBouquete(flowers));
    }
}
