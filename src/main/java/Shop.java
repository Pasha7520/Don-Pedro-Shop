import decorations.Decorator;
import products.Bouquet;
import products.Cactus;
import products.Flower;
import products.Palm;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Bouquet> bouquetList = new ArrayList<Bouquet>();
    private List<Flower> flowers = new ArrayList<Flower>();
    private List<Cactus> cactusList = new ArrayList<Cactus>();
    private List<Palm> palmList = new ArrayList<Palm>();
    private List<Decorator> decorators = new ArrayList<Decorator>();

    public Shop() {

    }

    public List<Bouquet> getBouquetList() {
        return bouquetList;
    }

    public void setBouquetList(List<Bouquet> bouquetList) {
        this.bouquetList = bouquetList;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public List<Cactus> getCactusList() {
        return cactusList;
    }

    public void setCactusList(List<Cactus> cactusList) {
        this.cactusList = cactusList;
    }

    public List<Palm> getPalmList() {
        return palmList;
    }

    public void setPalmList(List<Palm> palmList) {
        this.palmList = palmList;
    }

    public List<Decorator> getDecorators() {
        return decorators;
    }

    public void setDecorators(List<Decorator> decorators) {
        this.decorators = decorators;
    }
}
