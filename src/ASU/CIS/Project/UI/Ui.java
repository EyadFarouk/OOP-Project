package ASU.CIS.Project.UI;

import ASU.CIS.Project.Orders.*;
import ASU.CIS.Project.Person.*;
import ASU.CIS.Project.Resturants.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Ui {
    Scanner scanner=new Scanner(System.in);


    public  int firstPage(){
        System.out.println("welcome to the restaurant ");
        System.out.println("please enter the number of the action you want to operate");
        System.out.println("1- if you want to continue as a customer : ");
        System.out.println("2- if you want to continue as an Admin : ");
        System.out.println("3- if you want to continue as a Delivery Staff Member : ");
        return scanner.nextInt();
    }
    public  int loginOrSignup(){
        System.out.println("welcome to the restaurant ");
        System.out.println("Please enter the number of the action you want to operate");
        System.out.println("1- if you want to log in : ");
        System.out.println("2- if you want to sign up : ");
        return scanner.nextInt();
    }
    public  int homePage(){

        System.out.println("Hello in home page please enter the number of the action you want to operate");
        System.out.println("1- if you want to display the restaurants : ");
        System.out.println("2- if you want to display the restaurants with the menu : ");
        System.out.println("3- if you want to display the menu : ");
        System.out.println("4- if you want to make an order : ");
        System.out.println("5- if you want to check your order : ");
        System.out.println("6- if you want to make a review for the restaurant : ");
        System.out.println("7- if you want to review the Delivery staff member : ");
        System.out.println("8- if you want to log out : ");
        return scanner.nextInt();
    }
    public  int doYouWantAnotherAction(){

        int choose;
        do {
            System.out.println("If you want another action please enter 1 : ");
            System.out.println("If you want to exit please enter 2 : ");
            choose =scanner.nextInt();
            if (choose==1){
                return choose;
            }
            else if (choose==2){
                return choose;
            }
        }while(true);

    }
    public  int homePageAdmin(){

        System.out.println("Hello in home page please enter the number of the action you want to operate");
        System.out.println("1- if you want to add a restaurant : ");
        System.out.println("2- if you want to delete a restaurant : ");
        System.out.println("3- if you want to add a menu : ");
        System.out.println("4- if you want to delete a menu : ");
        System.out.println("5- if you want to display restaurant with a menu : ");
        System.out.println("6- if you want to log out");

        return scanner.nextInt();
    }
    public void exitProgram(){

        exit(0);
    }

}
