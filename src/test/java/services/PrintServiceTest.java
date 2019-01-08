package services;

import products.Flower;
import Shop;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintServiceTest {
    private List<Flower> flowerList = new ArrayList<Flower>();
    private Shop shop = new Shop();

    @Test
    public void testPrintFlowers() {
        Assert.assertEquals(false, PrintService.printFlowers(flowerList));
    }

    @Test
    public void testPrintCactuses() {
        Assert.assertEquals(false, PrintService.printCactuses(shop));
    }

    @Test
    public void testPrintPalms() {
        Assert.assertEquals(false, PrintService.printPalms(shop));
    }

    @Test
    public void testPrintBouquets() {
        Assert.assertEquals(false, PrintService.printReadyBouquet(shop));
    }

    @Test
    public void testPrintSet() {
        Assert.assertEquals(false, PrintService.printSet(shop.getFlowers()));
    }

}
