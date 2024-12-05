package ASU.CIS.Project.Payment;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class card {
    private String Regex = "[0-9]+";
    private String CardNum;
    private String Cvv;
    private String ExpirationDate;
    private double MoneyAvailable;
    ArrayList<card> CardList = new ArrayList<>();
    YearMonth currentDate = YearMonth.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM");
    String formattedDate = currentDate.format(formatter);
    Scanner scanner = new Scanner(System.in);

    public String getCardNum() {
        return CardNum;
    }

    public void setCardNum(String CardNum) {
        this.CardNum = CardNum;
    }

    public String getCvv() {
        return Cvv;
    }

    public void setCvv(String Cvv) {
        this.Cvv = Cvv;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

    public double getMoneyAvailable() {
        return MoneyAvailable;
    }

    public void setMoneyAvailable(double MoneyAvailable) {
        this.MoneyAvailable = MoneyAvailable;
    }

    public void AddNewCard(card card) {
        System.out.print("Please enter your card number: ");
        while (true) {
            this.CardNum = scanner.nextLine();
            if (this.CardNum.length() >= 12 && this.CardNum.length() <= 16 && this.CardNum.matches(Regex)) {
                break;
            } else {
                System.out.println("Invalid number. Card number must be between 12 and 16 digits. Please try again:");
            }
        }

        System.out.print("Please enter your CVV number: ");
        while (true) {
            this.Cvv = scanner.nextLine();
            if (this.Cvv.length() >= 3 && this.Cvv.length() <= 4 && this.Cvv.matches(Regex)) {
                break;
            } else {
                System.out.println("Invalid number. CVV must be between 3 and 4 digits. Please try again:");
            }
        }

        System.out.print("Enter Expiration Date (YY/MM): ");
        while (true) {
            this.ExpirationDate = scanner.nextLine();
            if (formattedDate.compareTo(this.ExpirationDate) >= 0 && this.ExpirationDate.matches(Regex)) {
                System.out.println("please enter money available");
                this.MoneyAvailable = scanner.nextDouble();
                CardList.add(this);
                System.out.println("card is valid and has been saved ");
                break;
            } else {
                System.out.println("Invalid or expired date. Please try again:");
            }
        }
    }

    public void removeCard(card card) {
        for (int i = 0; i < CardList.size(); i++) {
            System.out.println("enter the number of the card");
            this.CardNum = scanner.nextLine();
            if (CardList.get(i).getCardNum().equals(this.CardNum)) {
                CardList.remove(i);
                break;
            }
        }
    }

    public card SelectCard() {
        System.out.println("Please enter the number of the card you wish to use: ");
        String inputCardNum = scanner.nextLine();
        for (card Card : CardList) {
            if (Card.getCardNum().equals(inputCardNum)) {
                System.out.println("Item found: " + inputCardNum);
                System.out.println("Please enter the CVV of the card you wish to use: ");
                String inputCvv = scanner.nextLine();
                if (Card.getCvv().equals(inputCvv)) {
                    System.out.println("CVV is correct.");
                    System.out.println("Please enter the expiration date of the card (YY/MM): ");
                    String inputExpDate = scanner.nextLine();
                    if (Card.getExpirationDate().equals(inputExpDate)) {
                        System.out.println("Expiration date is correct.");
                        return Card;
                    } else {
                        System.out.println("Wrong expiration date. Try again.");
                    }
                } else {
                    System.out.println("Incorrect CVV. Try again.");
                }
            }
        }
        System.out.println("Item not found or incorrect details entered.");
        return null;
    }
}
