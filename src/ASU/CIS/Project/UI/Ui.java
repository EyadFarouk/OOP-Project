package ASU.CIS.Project.UI;

import ASU.CIS.Project.Interfaces.checkNumberValid;

import static java.lang.System.exit;

public class Ui implements checkNumberValid {

    public  int firstPage(){
        System.out.println("welcome to the restaurant ");
        System.out.println("please enter the number of the action you want to operate");
        System.out.println("[1] if you want to continue as a customer ");
        System.out.println("[2] if you want to continue as an Admin ");
        System.out.println("[3] if you want to continue as a Delivery Staff Member ");
        System.out.print("choice No. : ");
        return checkNumber(1,"Please enter a valid number: ");
    }
    public  int loginOrSignup(){
        System.out.println("welcome to the restaurant ");
        System.out.println("Please enter the number of the action you want to operate");
        System.out.println("[1] if you want to log in");
        System.out.println("[2] if you want to sign up");
        System.out.print("choice No. : ");
        return checkNumber(1,"Please enter a valid number: ");
    }
    public  int homePage(){

        System.out.println("Hello in home page please enter the number of the action you want to operate");
        System.out.println("[1] if you want to display the restaurants");
        System.out.println("[2] if you want to display the restaurants with the menu");
        System.out.println("[3] if you want to display the menu");
        System.out.println("[4] if you want to make an order");
        System.out.println("[5] if you want to check your order");
        System.out.println("[6] if you want to make a review for the restaurant");
        System.out.println("[7] if you want to review the Delivery staff member");
        System.out.println("[8] if you want to log out");
        System.out.print("choice No. : ");
        return checkNumber(1,"Please enter a valid number: ");
    }

    public  int doYouWantAnotherAction(){

        int choose;
        do {
            System.out.println("[1] Another action");
            System.out.println("[2] Exit the program");
            System.out.print("Choice No. : ");
            choose =checkNumber(1,"Please enter a valid number: ");
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
        System.out.println("[1] if you want to add a restaurant");
        System.out.println("[2] if you want to delete a restaurant");
        System.out.println("[3] if you want to add a menu");
        System.out.println("[4] if you want to delete a menu");
        System.out.println("[5] if you want to display restaurant with a menu");
        System.out.println("[6] if you want to log out");
        System.out.print("choice No. : ");
        return checkNumber(1,"Please enter a valid number: ");
    }

}
