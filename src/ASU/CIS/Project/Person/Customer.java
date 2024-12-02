package ASU.CIS.Project.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {
    String deliveryAddress;
    static List<Customer> userList=new ArrayList<>();
    public void displayUserInfo(){
        super.displayUserInfo();
        System.out.println("delivery address of user is : "+this.deliveryAddress);
    }

    public static void instance(){
        Customer Eyad=new Customer();
        Eyad.email="Eyad";
        Eyad.password="Eyad";
        userList.add(Eyad);
        for (int i = 0; i < 10; i++) {
            Customer customer=new Customer();
            customer.Fname="Fname"+i;
            customer.Lname="Lname"+i;
            customer.email="email"+i+"@email.com";
            customer.phone="phone"+i;
            customer.age=1;
            customer.gender="male";
            customer.address="address"+i;
            customer.password="password"+i;
            customer.deliveryAddress="address"+i;
            userList.add(customer);
            customer.displayUserInfo();
            userList.get(i).displayUserInfo();
        }
    }

    @Override
    public Customer login() {
        do {
            System.out.println("Welcome in Log in page");
            Scanner scanner=new Scanner(System.in);
            System.out.println("Please enter your email : ");
            this.email=scanner.next();
            System.out.println("Please enter your password : ");
            this.password=scanner.next();
            for (int i = 0; i < userList.size(); i++) {
                if (this.email.equals(userList.get(i).email)) {
                    if (this.password.equals(userList.get(i).password)) {
                        System.out.println("log in success");
                        return userList.get(i);
                    } else if (i == userList.size() - 1) {
                        System.out.println("the email or password is not correct");
                    }
                } else if (i == userList.size() - 1) {
                    System.out.println("The email could not be found");
                }
            }
        }while (true);
    }

    @Override
    public void signup() {
        System.out.println("Welcome in sign up page");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your first name : ");
        this.Fname=scanner.next();
        System.out.println("Please enter your last name : ");
        this.Lname=scanner.next();
        System.out.println("Please enter your email : ");
        this.email=scanner.next();
        System.out.println("Please enter your phone number : ");
        this.phone=scanner.next();
        System.out.println("Please enter your age : ");
        this.age=scanner.nextInt();
        System.out.println("Please enter your gender : ");
        this.gender=scanner.next();
        System.out.println("Please enter your address : ");
        this.address=scanner.next();
        System.out.println("Please enter your password : ");
        this.password=scanner.next();
        for (Customer customer : userList) {
            if (this.email.equals(customer.email)) {
                System.out.println("im sorry email must be unique");
                signup();
            }
        }
        System.out.println("Please enter your Delivery Address : ");
        this.deliveryAddress=scanner.next();
        System.out.println("sign up succeful");
        userList.add(this);
    }

    @Override
    public void saveData() {
        FileWriter fw;
        try {
            fw = new FileWriter("Data/CustomerData.csv");
            fw.write("FName,LName,Email,Phone,Age,Gender,Address,Password,Delivery Address\n");
            for (Customer customer:userList) {
                fw.append(customer.toString());}
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String toString() {
        return this.Fname + ',' + this.Lname + ',' + this.email + ',' + this.phone + ',' + this.age + ',' + this.gender + ',' + this.address + ',' + this.password + ',' + this.deliveryAddress+'\n';
    }
}
