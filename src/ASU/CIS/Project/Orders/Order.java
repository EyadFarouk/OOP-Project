package ASU.CIS.Project.Orders;

import ASU.CIS.Project.Payment.Payment;

public class Order {
    String deliveryAddress;
    String deliveryTime;
    Payment payment;

    public void setOrder(String address,String time,String transaction,boolean cart){
        this.deliveryAddress=address;
        this.deliveryTime=time;
        this.payment.cart=cart;
        if (cart){
            this.payment.transictionId=transaction;
        }
        else {
            this.payment.paymentStatus=transaction;
        }

    }
}
