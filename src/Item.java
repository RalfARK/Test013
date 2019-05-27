public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        if (price <= 0) {
            throw new IllegalArgumentException("Cena nie może być niższa lub równa 0");
        }
        else this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Cena nie może być niższa lub równa 0");
        }
        else this.price = price;
    }

    @Override
    public boolean equals(Object otherItem) {
        if (otherItem == null || !(otherItem instanceof Item)) {
            return false;
        }
        else {
            Item it = (Item) otherItem;
            if (this.name.equals(it.getName()) && this.price == it.getPrice()) {
                return true;
            }
            else return false;
        }
    }
}
