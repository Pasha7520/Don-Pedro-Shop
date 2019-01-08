import menu.UsersMenu;
import services.FillShopRandomProductsService;

public class main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        FillShopRandomProductsService.fillShop(shop);
        UsersMenu.menuShop(shop);

    }
}
