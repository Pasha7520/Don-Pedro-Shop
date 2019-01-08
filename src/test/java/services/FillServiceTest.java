package services;

import Shop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FillServiceTest {
    private Shop shop;

    @Before
    public void setUp() {
        shop = new Shop();
    }

    @Test
    public void fillServiceTest(){
        FillShopRandomProductsService.fillShop(shop);
        Assert.assertEquals(shop.getBouquetList().isEmpty(),false);
        Assert.assertEquals(shop.getFlowers().isEmpty(),false);
        Assert.assertEquals(shop.getCactusList().isEmpty(),false);
        Assert.assertEquals(shop.getPalmList().isEmpty(),false);
        Assert.assertEquals(shop.getDecorators().isEmpty(),false);
    }
}
