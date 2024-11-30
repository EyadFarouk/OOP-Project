package person;

import java.util.Scanner;

abstract public class Person {
    String Fname;
    String Lname;
    String email;
    int Phone;
    int age;
    String gender;
    String address;
    String password;
    public void login(){
        System.out.println("Welcome in Log in page");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your email : ");
        this.email=scanner.next();
        System.out.println("Please enter your password : ");
        this.password=scanner.next();

    }
    public void signup(){
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
    }



}
