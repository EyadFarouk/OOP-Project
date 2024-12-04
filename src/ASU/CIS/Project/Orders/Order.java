package ASU.CIS.Project.Orders;

import ASU.CIS.Project.Resturants.Dish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private Date orderDate;
    private List<Dish> foodItems;
    private double totalPrice;
    private String orderLocation;
    private String orderState; // state of the order (Pending, Completed, Canceled)

    public Order(String orderLocation, String orderState) {
        this.orderId = generateRandomOrderId();
        this.orderDate = new Date();
        this.foodItems = new ArrayList<>();
        this.totalPrice = 0.0;
        this.orderLocation = orderLocation;
        this.orderState = orderState;
    }

    // Generate a random order ID using UUID
    private String generateRandomOrderId() {
        return UUID.randomUUID().toString();
    }

    // For adding one Food Instance
    public void addFoodItem(Dish dish) {
        foodItems.add(dish);
        totalPrice += dish.price; // update total price
    }

    // For adding a List of Food I
    public void addFoodItems(List<Dish> foods) {
        for (Dish food : foods)
            addFoodItem(food);
    }

    /* === Getters === */
    public String getOrderId() { return orderId; }
    public Date getOrderDate() { return orderDate; }
    public double getOrderPrice() { return totalPrice; }
    public String getOrderLocation() { return orderLocation; }
    public String getOrderState() { return orderState; }

    /* === Setters ===*/
    public void setOrderState(String orderState) { this.orderState = orderState; }

    // override the toString() method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Id: ").append(orderId)
                .append("\nOrder Date: ").append(orderDate);

        // Loop throw the food list to print each food item separately
        for (Dish food : foodItems)
            sb.append("\n- ").append(food.toString());

        // The rest of the properties
        sb.append("\nTotal Order Price: ").append(totalPrice)
                .append("\nOrder Location: ").append(orderLocation)
                .append("\nOrder State: ").append(orderState);
        return sb.toString();
    }
}