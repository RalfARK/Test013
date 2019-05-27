import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Basket {
    private Map<Item, Integer> orderedItems;


    public Basket() {
        orderedItems = new HashMap<>();
    }

    public void addToBasket(Item item, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Ilość nie może być mniejsza lub równa 0");
        }
        else{
            if (orderedItems.containsKey(item)) {
                int oldAmount = orderedItems.get(item);
                orderedItems.replace(item, (oldAmount+amount));
            }
            else {
                orderedItems.put(item, amount);
            }
        }
    }

    public void addToBasket(Item item){
        if (orderedItems.containsKey(item)) {
            int oldAmount = orderedItems.get(item);
            orderedItems.replace(item, (oldAmount+1));
        }
        else {
            orderedItems.put(item, 1);
        }
    }

    public void removeFromBasket(Item item, int amount){
        if (amount < 0) {
            throw new IllegalArgumentException("Warotść nie może być mniejsza niż 0");
        }
        else {
            if (orderedItems.containsKey(item)) {
                if (orderedItems.get(item) < amount) {
                    throw new IllegalArgumentException("Nie można usunąć z koszyka więcej niż w nim jest");
                }
                else if(orderedItems.get(item) == amount){
                    orderedItems.remove(item);
                }
                else {
                    int oldAmount = orderedItems.get(item);
                    orderedItems.replace(item, (oldAmount-amount));
                }
            }
            else throw new IllegalArgumentException("Nie ma takiego artykułu w koszyku");
        }
    }

    public void removeFromBasket(Item item) {
        if (orderedItems.containsKey(item)) {
            orderedItems.remove(item);
        }
        else throw new IllegalArgumentException("Nie ma takiego artykułu w koszyku");
    }

    public int totalAmount() {
        int totalAmount = 0;
        Object[] values = orderedItems.values().toArray();

        for (int i = 0; i < values.length; i++) {
            totalAmount += (int)values[i];
        }
        return totalAmount;
    }

    public void printBasket() {
        Set<Map.Entry<Item, Integer>> basket = orderedItems.entrySet();
        for(Map.Entry<Item, Integer> entry: basket) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        System.out.println("Zaczynamy!\n");

        Item it01 = new Item("it01", 1.1);
        Item it02 = new Item("it02", 2.2);
        Item it03 = new Item("it03", 3.3);
        Item it04 = new Item("it04", 4.4);
        //it04.setPrice();

        Basket b1 = new Basket();
        b1.addToBasket(it01);
        b1.addToBasket(it01, 4);
        b1.addToBasket(it02, 2);
        b1.addToBasket(it03, 3);
        b1.addToBasket(it04, 44);
        b1.addToBasket(it04);
        System.out.println("total: " + b1.totalAmount());
        b1.printBasket();

        b1.removeFromBasket(it01);
        b1.removeFromBasket(it04, 44);

        System.out.println("--------------");
        b1.printBasket();
        System.out.println("total: " + b1.totalAmount());

    }
}
