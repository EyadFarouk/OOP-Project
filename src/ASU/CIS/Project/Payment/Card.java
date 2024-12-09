package ASU.CIS.Project.Payment;

import ASU.CIS.Project.Interfaces.saveAndLoad;
import ASU.CIS.Project.Person.Customer;

import java.io.*;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Card implements saveAndLoad {
    private String Regex = "[0-9]+";
    private String CardNum;
    private String Cvv;
    private String ExpirationDate;
    private double MoneyAvailable;
    static ArrayList<Card> cardList = new ArrayList<>();
    YearMonth currentDate = YearMonth.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM");
    String formattedDate = currentDate.format(formatter);
    Scanner scanner = new Scanner(System.in);

    public static void instance(){
        Card card=new Card();
        card.CardNum="Eyjkhjad";
        card.Cvv="Eyad";
        card.ExpirationDate="sad";
        card.MoneyAvailable=0.01;
        cardList.add(card);
        Card card2=new Card();
        card2.CardNum="Eysdacxad";
        card2.Cvv="Eyad";
        card2.ExpirationDate="sad";
        card2.MoneyAvailable=0.01;
        cardList.add(card2);
        Card card3=new Card();
        card3.CardNum="Ewqeyad";
        card3.Cvv="Eyad";
        card3.ExpirationDate="sad";
        card3.MoneyAvailable=0.01;
        cardList.add(card3);
//        for (int i = 0; i < 10; i++) {
//            Customer customer=new Customer();
//            customer.Fname="Fname"+i;
//            customer.Lname="Lname"+i;
//            customer.email="email"+i+"@email.com";
//            customer.phone="phone"+i;
//            customer.age=1;
//            customer.gender="male";
//            customer.address="address"+i;
//            customer.password="password"+i;
//            customer.deliveryAddress="address"+i;
//            userList.add(customer);
//            customer.displayUserInfo();
//            userList.get(i).displayUserInfo();
//        }
    }

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

    public void AddNewCard(Card card) {
        System.out.print("Please enter your Card number: ");
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
                cardList.add(this);
                System.out.println("Card is valid and has been saved ");
                break;
            } else {
                System.out.println("Invalid or expired date. Please try again:");
            }
        }
    }

    public void removeCard(Card card) {
        for (int i = 0; i < cardList.size(); i++) {
            System.out.println("enter the number of the Card");
            this.CardNum = scanner.nextLine();
            if (cardList.get(i).getCardNum().equals(this.CardNum)) {
                cardList.remove(i);
                break;
            }
        }
    }

    public Card SelectCard() {
        System.out.println("Please enter the number of the Card you wish to use: ");
        String inputCardNum = scanner.nextLine();
        for (ASU.CIS.Project.Payment.Card Card : cardList) {
            if (Card.getCardNum().equals(inputCardNum)) {
                System.out.println("Item found: " + inputCardNum);
                System.out.println("Please enter the CVV of the Card you wish to use: ");
                String inputCvv = scanner.nextLine();
                if (Card.getCvv().equals(inputCvv)) {
                    System.out.println("CVV is correct.");
                    System.out.println("Please enter the expiration date of the Card (YY/MM): ");
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

    /**
     * this method is used to save the data
     */
    @Override
    public void saveData() {
        FileWriter fw;
        while(true) {
            try {
                fw = new FileWriter("Data/CardData.csv");
                fw.write("Card Number,CVV,Expiration date,Money available\n");
                for (Card card : cardList) {
                    fw.append(card.toString());
                }
                fw.close();
                break;
            } catch (FileNotFoundException e) {
                File file = new File("Data/");
                if (!file.exists()) {file.mkdir();}
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Something went wrong with saving the data");
                break;
            }
        }
    }

    /**
     * this method is used to load the data
     */
    @Override
    public void loadData() {
        try {
            FileReader fr = new FileReader("Data/CardData.csv");
            BufferedReader br = new BufferedReader(fr);
//            int i=0;
            br.readLine();
            String line;
            while((line = br.readLine()) != null) {
//                System.out.println(line);
                Card card= new Card();
                card.CardNum=line.split(",")[0];
                card.Cvv=line.split(",")[1];
                card.ExpirationDate=line.split(",")[2];
                card.MoneyAvailable=Double.parseDouble(line.split(",")[3]);
                cardList.add(card);
//                System.out.println(userList.get(i).toString());
//                i++;
            }
            fr.close();
        }catch (FileNotFoundException e) {
            File file = new File("Data/");
            if (!file.exists()) {file.mkdir();}
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * This method is used to turn the class values into a string
     * @return A string consisting of the data of the card
     */
    public String toString() {
        return this.CardNum+','+this.Cvv+','+this.ExpirationDate+','+this.MoneyAvailable+'\n';
    }
}
