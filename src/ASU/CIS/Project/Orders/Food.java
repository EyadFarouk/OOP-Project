package ASU.CIS.Project.Orders;

public class Food {
    private String name;
    private double price;
    private String type;

    public Food(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    /* === Getters === */
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getType() { return type; }


    @Override
    public String toString() {
        return  "- Name: " + name + ", Price: " + price + ", Type: " + type;
    }
}