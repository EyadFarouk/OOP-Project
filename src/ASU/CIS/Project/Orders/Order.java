package ASU.CIS.Project.Orders;

import resturants.Menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private Date orderDate;
    private List<Food> foodItems;
    private double totalPrice;
    private String orderLocation;
    private String orderState; // state of the order (Pending, Completed, Canceled)
    private Menu menu;

    public Order(String orderLocation, String orderState, Menu menu) {
        this.orderId = generateRandomOrderId();
        this.orderDate = new Date();
        this.foodItems = new ArrayList<>();
        this.totalPrice = 0.0;
        this.orderLocation = orderLocation;
        this.orderState = orderState;
        this.menu = menu;
    }

    // Generate a random order ID using UUID
    private String generateRandomOrderId() {
        return UUID.randomUUID().toString();
    }

    // For adding one Food Instance
    public void addFoodItem(Food food) {
        foodItems.add(food);
        totalPrice += food.getPrice(); // update total price
    }

    // For adding a List of Food I
    public void addFoodItems(List<Food> foods) {
        for (Food food : foods)
            addFoodItem(food);
    }

    /* === Getters === */
    public String getOrderId() { return orderId; }
    public Date getOrderDate() { return orderDate; }
    public double getOrderPrice() { return totalPrice; }
    public String getOrderLocation() { return orderLocation; }
    public String getOrderState() { return orderState; }

    /* === Setters === */
    public void setOrderState(String orderState) { this.orderState = orderState; }

    // override the toString() method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Id: ").append(orderId)
                .append("\nOrder Date: ").append(orderDate);

        // Loop throw the food list to print each food item separately
        for (Food food : foodItems)
            sb.append("\n- ").append(food.toString());

        // The rest of the properties
        sb.append("\nTotal Order Price: ").append(totalPrice)
                .append("\nOrder Location: ").append(orderLocation)
                .append("\nOrder State: ").append(orderState)
                .append("\nResturant Name: ").append(menu.name);
        return sb.toString();
    }
}