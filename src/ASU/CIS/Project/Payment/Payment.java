package ASU.CIS.Project.Payment;

public class Payment {
    private String TransactionId;
    private String PaymentStatus;

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.PaymentStatus = paymentStatus;
    }

    /*public String CheckOut(card cardManager) {
        card selectedCard = cardManager.SelectCard();
        if (selectedCard == null) {
            setPaymentStatus("Failed");
            return "Payment Failed";
        }

        if (selectedCard.getMoneyAvailable() >= totalPrice) {
            selectedCard.setMoneyAvailable(selectedCard.getMoneyAvailable() - totalPrice);
            setPaymentStatus("Success");
            return "Payment Successful";
        } else {
            setPaymentStatus("Failed");
            return "Payment Failed";
        }
    }*/
}

