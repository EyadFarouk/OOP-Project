package ASU.CIS.Project.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {
    String deliveryAddress;
    public void displayUserInfo(){
        System.out.println("Name of user is : "+Fname+" "+Lname);
        System.out.println("Email of user is : "+email);
        System.out.println("Password of user is : "+password);
    }

    @Override
    public void login() {
        // hard code to test
        List<Customer>userList=new ArrayList<>();
        Customer customer1=new Customer();
        customer1.email="mohamedtalat";
        customer1.password="1234567";
        Customer customer=new Customer();
        customer.email="talat saber";
        customer.password="1234578";
        userList.add(customer);
        userList.add(customer1);
        // end hard code
        System.out.println("Welcome in Log in page");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your email : ");
        this.email=scanner.next();
        System.out.println("Please enter your password : ");
        this.password=scanner.next();
        for (int i=0;i<userList.size();i++){
            if (this.email.equals(userList.get(i).email)){
                if (this.password.equals(userList.get(i).password)){
                    System.out.println("log in success");
                }
                else if (i==userList.size()-1){
                    System.out.println("the email or password is not correct");
                    login();
                }
            }
            else if (i==userList.size()-1){
                System.out.println("the email or password is not correct");
                login();
            }
        }
    }

    @Override
    public void signup() {
        // hard code to test
        List<Customer>userList=new ArrayList<>();
        Customer customer1=new Customer();
        customer1.email="mohamedtalat";
        customer1.password="1234567";
        Customer customer=new Customer();
        customer.email="talat saber";
        customer.password="1234578";
        userList.add(customer);
        userList.add(customer1);
        // end hard code
        System.out.println("Welcome in sign up page");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your first name : ");
        this.Fname=scanner.next();
        System.out.println("Please enter your last name : ");
        this.Lname=scanner.next();
        System.out.println("Please enter your email : ");
        this.email=scanner.next();
        System.out.println("Please enter your phone number : ");
        this.Phone=scanner.nextInt();
        System.out.println("Please enter your age : ");
        this.age=scanner.nextInt();
        System.out.println("Please enter your gender : ");
        this.gender=scanner.next();
        System.out.println("Please enter your address : ");
        this.address=scanner.next();
        System.out.println("Please enter your password : ");
        this.password=scanner.next();
        for (int i=0;i<userList.size();i++){
            if (this.email.equals(userList.get(i).email)){
                System.out.println("im sorry email must be unique");
                signup();
            }
        }
        System.out.println("sign up succeful");
    }
}
