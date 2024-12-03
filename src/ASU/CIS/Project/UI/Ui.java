package ASU.CIS.Project.UI;

import ASU.CIS.Project.Orders.Cart;
import ASU.CIS.Project.Orders.Order;
import ASU.CIS.Project.Person.Admin;
import ASU.CIS.Project.Person.Customer;
import ASU.CIS.Project.Resturants.Dish;
import ASU.CIS.Project.Resturants.Restaurant;
import ASU.CIS.Project.Resturants.Review;

import java.util.List;
import java.util.Scanner;

public class Ui {
Scanner scanner=new Scanner(System.in);

    static Restaurant restaurant=new Restaurant();

    public  int firstPage(){
        System.out.println("Hello in management restaurant system");
        System.out.println("Please enter number of action you need");
        System.out.println("1- if you want to continue as user : ");
        System.out.println("2- if you want to continue as Admin : ");

        return scanner.nextInt();
    }
    public  int loginOrSignup(){
        System.out.println("Hello in management restaurant system");
        System.out.println("Please enter number of action you need");
        System.out.println("1- if you want to log in : ");
        System.out.println("2- if you want to sign up : ");
        return scanner.nextInt();
    }
    public  int homePage(){
        System.out.println("Hello in home page please enter the number of action you need");
        System.out.println("1- if you want to display restaurant : ");
        System.out.println("2- if you want to log out : ");
        return scanner.nextInt();
    }
    public  Restaurant displayRestaurants(){
        Restaurant []restaurants=new Restaurant[10];
        System.out.println("Welcome in home page please enter the number of restaurant you need");
        for (int i=0;i<10;i++){
            System.out.println("Name of restaurant "+(i+1)+ " : "+restaurants[i].name);
            System.out.println("Rating of restaurant "+(i+1)+ " : "+restaurants[i].rating);
        }

        int choose=scanner.nextInt();
        restaurant=restaurants[choose-1];
        return restaurants[choose-1];
    }
    public  void selectDish(){
        System.out.println("Welcome in home page please enter the number of dish you need");
        restaurant.displayMenu();
        int choose=scanner.nextInt();
        System.out.println("Do you want to add this to your cart enter 1 if you agree");
        int cart=scanner.nextInt();
        if (cart==1){
            System.out.println("Please enter quantities you need : ");
            int quantity =scanner.nextInt();
            System.out.println("Do you want any addition if you want please enter 1 : ");
            int x=scanner.nextInt();
            if (x==1){
                System.out.println("Enter addition you need");
                String add =scanner.next();
                Cart.addItem(restaurant.menu.get(choose-1), quantity,add );
            }else {
                Cart.addItem(restaurant.menu.get(choose-1), quantity,null);
            }

        }
        doYouWantAnotherAction();

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
            System.out.println("How would you rate your Dish out of 5:: ");
            rate=scanner.nextInt();
          /*  review.serReviewForDish(rate,name);*/
        }
        doYouWantAnotherAction();
    }
    public  int homePageAfterSelectRestaurant(){

        System.out.println("Hello in home page please enter the number of action you need");
        System.out.println("1- if you want to select dish : ");
        System.out.println("2- if you want to set review : ");
        System.out.println("3- if you want to Cart information : ");
        System.out.println("4- if you want to order information : ");
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

        System.out.println("Hello in home page please enter the number of action you need");
        System.out.println("1- if you want to add restaurant : ");
        System.out.println("2- if you want to delete restaurant : ");
        System.out.println("3- if you want to add menu : ");
        System.out.println("4- if you want to delete menu : ");

        return scanner.nextInt();
    }
    public  void addRestaurantAdmin(){
        Restaurant restaurant1=new Restaurant();

        System.out.println("Please enter name of restaurant : ");
        restaurant1.name=scanner.next();
        System.out.println("Please enter address of restaurant : ");
        restaurant1.address=scanner.next();
        System.out.println("Please enter contact information of restaurant : ");
        restaurant1.contactInformation=scanner.next();
        System.out.println("Please enter rating of restaurant : ");
        restaurant1.rating=scanner.nextDouble();
        System.out.println("next we want to add Menu items");
        Dish menu=new Dish();
        List<Dish>menus = null;
        System.out.println("Please enter number of items in menu : ");
        int numberOfItems=scanner.nextInt();
        for (int i=0;i<numberOfItems;i++){
            System.out.println("Please enter name of dish : ");
            menu.name=scanner.next();
            System.out.println("Please enter description : ");
            menu.description=scanner.next();
            System.out.println("Please enter price : ");
            menu.price=scanner.nextDouble();
            System.out.println("Please enter categories : ");
            menu.categories=scanner.next();
            System.out.println("Please enter rating : ");
            menu.rating=scanner.nextDouble();
            menus.add(menus.size(),menu);
        }
        restaurant1.menu=menus;
        Admin.addRestaurant(restaurant1);
        doYouWantAnotherAction();
    }
    public  void deleteRestaurantAdmin(){

        System.out.println("Please enter name of restaurant you need to delete : ");
        String name =scanner.next();
        Admin.deleteRestaurant(name);
    }
    public  void deleteMenu(){
        System.out.println("Enter name of restaurant you need to delete menu from");
        String name=scanner.next();
        Admin.deleteMenu(name);
    }
    public  void modifyQuantity(){
        Cart.displayCart();

        System.out.println("Enter number of item you want to update quantities : ");
        int number=scanner.nextInt();
        System.out.println("Enter number of new quantities : ");
        int numberNew=scanner.nextInt();
        Cart.modifyQuantitie(number,numberNew);
        doYouWantAnotherAction();
    }
    public  void deleteItemFromCart(){
        Cart.displayCart();
        System.out.println("Please enter number of item you want to delete : ");
        int number=scanner.nextInt();
        Cart.deleteItem(number);
        doYouWantAnotherAction();
    }
    public void deleteDish(){
        displayRestaurants();
        System.out.println("Enter name of Restaurant you need");
        String nameOfRestaurant=scanner.next();
        restaurant.displayMenu();
        System.out.println("Enter name of Dish");
        String nameOfDish=scanner.next();
        Admin.deleteDish(nameOfRestaurant,nameOfDish);
        doYouWantAnotherAction();
    }
    public void displayUserInfo(Customer customer){

        customer.displayUserInfo();

    }
    public void makeOrder(){
        System.out.println("Please enter delivery address : ");
        String deliveryAddress=scanner.next();
        System.out.println("Please enter time of delivery : ");
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
        Order order=new Order();
        order.setOrder(deliveryAddress,timeOfDelivery, transaction,cart);
    }
}
