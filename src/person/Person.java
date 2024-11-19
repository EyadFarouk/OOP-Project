package person;

import java.util.Scanner;

abstract public class Person {
    String name;
    String password;
    String email;
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
        System.out.println("Please enter your name : ");
        this.name=scanner.next();
        System.out.println("Please enter your email : ");
        this.email=scanner.next();
        System.out.println("Please enter your password : ");
        this.password=scanner.next();
    }



}
