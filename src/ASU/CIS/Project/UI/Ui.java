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

    static Restaurant restaurant=new Restaurant();

    public  static List<Restaurant>restaurants= new ArrayList<>();

    public  int firstPage(){
        System.out.println("welcome to the restaurant ");
        System.out.println("please enter the number of the action you want to operate");
        System.out.println("1- if you want to continue as a customer : ");
        System.out.println("2- if you want to continue as an Admin : ");
        restaurants= restaurant.loadData();
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
        System.out.println("1- if you want to display restaurant : ");
        System.out.println("2- if you want to log out : ");
        return scanner.nextInt();
    }
    public  Restaurant displayRestaurants(){

        System.out.println("Welcome please enter the number of the restaurant you want to order from");
        for (int i=0;i<restaurants.size();i++){
            System.out.println("Name of restaurant "+(i+1)+ " : "+restaurants.get(i).name);
            System.out.println("Rating of restaurant "+(i+1)+ " : "+restaurants.get(i).rating);
            System.out.println("Contact information of restaurant "+(i+1)+ " : "+restaurants.get(i).contactInformation);
            System.out.println("Address of restaurant "+(i+1)+ " : "+restaurants.get(i).address);
        }

        int choose=scanner.nextInt();
        restaurant=restaurants.get(choose-1);
        return restaurants.get(choose-1);
    }
    public  void selectDish(){
        System.out.println("please choose the dish you want to order");
        restaurant.displayMenu();
        int choose=scanner.nextInt();
        System.out.println("Do you want to add this to your cart enter 1 if you agree");
        int cart=scanner.nextInt();
        if (cart==1){
            System.out.println("Please enter quantity you desire : ");
            int quantity =scanner.nextInt();
            System.out.println("Do you want any addition if yes then please enter 1 : ");
            int x=scanner.nextInt();
            if (x==1){
                System.out.println("Enter the addition you want");
                String add =scanner.next();
                Cart.addItem(restaurant.menu.get(choose-1), quantity,add );
            }else {
                Cart.addItem(restaurant.menu.get(choose-1), quantity,null);
            }

        }

    }
    public  void setReview(){
        Review review=new Review(restaurant);
        System.out.println("please enter 1 if you want to rate restaurant or 2 if you want to rate dish");
        int choose=scanner.nextInt();
        int rate;
        if (choose==1){
            System.out.print("How would you rate your experience out of 5: ");
            rate=scanner.nextInt();
            review.setReviewForRestaurant(rate);
        }
        else if (choose==2){
            System.out.println("Please enter the name of dish : ");
            String name=scanner.next();
            System.out.println("How would you rate your Dish out of 5 : ");
            rate=scanner.nextInt();
            review.setReviewForDish(rate,name);
        }
    }
    public  int homePageAfterSelectRestaurant(){

        System.out.println("Hello in home page please enter the number of the action you want to operate");
        System.out.println("1- if you want to select dish : ");
        System.out.println("2- if you want to set review : ");
        System.out.println("3- if you want to Cart information : ");
        System.out.println("4- if you want the order information : ");
        System.out.println("5- if you want to log out : ");
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
        System.out.println("5- if you want to log out");

        return scanner.nextInt();
    }
    public  void addRestaurantAdmin(){
        Restaurant restaurant1=new Restaurant();

        System.out.println("Please enter the name of the restaurant : ");
        restaurant1.name=scanner.next();
        System.out.println("Please enter the address : ");
        restaurant1.address=scanner.next();
        System.out.println("Please enter the contact information : ");
        restaurant1.contactInformation=scanner.next();
        System.out.println("Please enter the rating of the restaurant : ");
        while (true) {
            try {
                restaurant1.rating = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid rating: ");
            }
            scanner.nextLine();
        }

        System.out.println("next we want to add Menu items");
        Dish menu=new Dish();
        List<Dish>menus = null;
        System.out.println("Please enter number of items in menu : ");
        int numberOfItems=scanner.nextInt();
        for (int i=0;i<numberOfItems;i++){
            System.out.println("Please enter name of the dish : ");
            menu.name=scanner.next();
            System.out.println("Please enter the description : ");
            menu.description=scanner.next();
            System.out.println("Please enter the price : ");
            while (true) {
                try {
                    menu.price = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Please enter a valid price: ");
                }
                scanner.nextLine();
            }

            System.out.println("Please enter the categories : ");
            menu.categories=scanner.next();
            System.out.println("Please enter the rating : ");
            while (true) {
                try {
                    menu.rating = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Please enter a valid rating : ");
                }
                scanner.nextLine();
            }

            menus.add(menus.size(),menu);
        }
        restaurant1.menu=menus;
        Admin.addRestaurant(restaurant1);
    }
    public  void deleteRestaurantAdmin(){
        displayRestaurants();
        System.out.println("Please enter the name of the restaurant you want to delete : ");
        String name =scanner.next();
        Admin.deleteRestaurant(name);
    }
    public void addMenu(){
        displayRestaurants();
        System.out.println("Please enter the name of the restaurant you want to add the menu of ");
        String name = scanner.nextLine();
        Dish menu=new Dish();
        List<Dish>menus = new ArrayList<>();
        System.out.println("Please enter number of items in menu : ");
        int numberOfItems=scanner.nextInt();
        for (int i=0;i<numberOfItems;i++){
            System.out.println("Please enter name of the dish : ");
            menu.name=scanner.next();
            System.out.println("Please enter the description : ");
            menu.description=scanner.next();
            System.out.println("Please enter the price : ");
            while (true) {
                try {
                    menu.price = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Please enter a valid price: ");
                }
                scanner.nextLine();
            }

            System.out.println("Please enter the categories : ");
            menu.categories=scanner.next();
            System.out.println("Please enter the rating : ");
            while (true) {
                try {
                    menu.rating = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Please enter a valid rating : ");
                }
                scanner.nextLine();
            }

            try {
                menus.add(menus.size(),menu);
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
        Admin.addMenu(name,menus);
    }
    public  void deleteMenu(){
        displayRestaurants();
        System.out.println("Enter the name of the restaurant you want to delete menu from");
        String name=scanner.next();
        Admin.deleteMenu(name);
    }
    public  void modifyQuantity(){
        Cart.displayCart();

        System.out.println("Enter the number of items you want to update the quantities of : ");
        int number=scanner.nextInt();
        System.out.println("Enter the number of new quantities : ");
        int numberNew=scanner.nextInt();
        Cart.modifyQuantitie(number,numberNew);
        doYouWantAnotherAction();
    }
    public  void deleteItemFromCart(){
        Cart.displayCart();
        System.out.println("Please enter the number of items you want to delete : ");
        int number=scanner.nextInt();
        Cart.deleteItem(number);
        doYouWantAnotherAction();
    }
    public void deleteDish(){
       // displayRestaurants();
        System.out.println("Enter the name of the Restaurant you want");
        String nameOfRestaurant=scanner.next();
        restaurant.displayMenu();
        System.out.println("Enter the name of the Dish");
        String nameOfDish=scanner.next();
        Admin.deleteDish(nameOfRestaurant,nameOfDish);
        doYouWantAnotherAction();
    }
    public void displayUserInfo(Customer customer){

        customer.displayUserInfo();

    }
    public void makeOrder(){
        System.out.println("Please enter the delivery address : ");
        String deliveryAddress=scanner.next();
        System.out.println("Please enter the time of delivery : ");
        String timeOfDelivery=scanner.next();
        System.out.println("Do you want to pay with card if yes please enter 1 if cash please enter 0 : ");
        boolean cart=scanner.nextBoolean();
        String transaction;
        if (cart){
            System.out.println("Please enter transaction id : ");
            transaction =scanner.next();
        }else{
            System.out.println("Please enter transaction status");
            transaction =scanner.next();
        }

    }
    public void exitProgram(){
        restaurant.saveData(restaurants);
        exit(0);
    }
    public void display_cart()
    {
        Cart.displayCart();
    }
}
