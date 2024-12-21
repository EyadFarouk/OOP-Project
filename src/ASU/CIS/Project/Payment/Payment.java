package ASU.CIS.Project.Payment;

import ASU.CIS.Project.Interfaces.checkNumberValid;
import ASU.CIS.Project.Interfaces.saveAndLoad;
import ASU.CIS.Project.Orders.Order;

public class Payment implements checkNumberValid, saveAndLoad {
    /**
     * Total price of the order
     */
    private double TotalPrice;
    /**
     * Constructs a Payment object with the specified order.
     *
     * @param order The order for which payment will be processed.
     */
    public Payment(Order order) {
        this.TotalPrice = order.getOrderPrice();  // Used to get the price
    }
    /**
     * Saves payment data to persistent storage (not implemented).
     */
    @Override
    public void saveData() {
    }

    /**
     * Loads payment data from persistent storage (not implemented).
     */
    @Override
    public void loadData() {
    }
}
