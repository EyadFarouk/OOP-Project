package ui;

import orders.Cart;
import orders.Order;
import person.Admin;
import person.User;
import resturants.Menu;
import resturants.Restaurant;
import resturants.Review;

import java.util.List;
import java.util.Scanner;

public class Ui {
Scanner scanner=new Scanner(System.in);
    static Restaurant restaurant=new Restaurant();
    public  int firstPage(){
        System.out.println("Hello in mangment resturant system");
        System.out.println("Please enter number of action you need");
        System.out.println("1- if you want to continue as user : ");
        System.out.println("2- if you want to continue as Admin : ");

        return scanner.nextInt();
    }
    public  int loginOrSignup(){
        System.out.println("Hello in mangment resturant system");
        System.out.println("Please enter number of action you need");
        System.out.println("1- if you want to log in : ");
        System.out.println("2- if you want to sign up : ");
        return scanner.nextInt();
    }
    public  int homePage(){
        System.out.println("Hello in home page please enter the number of action you need");
        System.out.println("1- if you want to display resturant : ");
        System.out.println("2- if you want to log out : ");
        return scanner.nextInt();
    }

    public  Restaurant displayRestaurants(){
        Restaurant []restaurants=new Restaurant[10];
        System.out.println("Welcome in home page please enter the number of resturant you need");
        for (int i=0;i<10;i++){
            System.out.println("Name of resturant "+(i+1)+ " : "+restaurants[i].name);
            System.out.println("Rating of resturant "+(i+1)+ " : "+restaurants[i].rating);
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
            int quantite=scanner.nextInt();
            System.out.println("Do you want any addition if you want please enter 1 : ");
            int x=scanner.nextInt();
            if (x==1){
                System.out.println("Enter addition you need");
                String add =scanner.next();
                Cart.addItem(restaurant.menu.get(choose-1), quantite,add );
            }else {
                Cart.addItem(restaurant.menu.get(choose-1), quantite,null);
            }

        }
        doYouWantAnotherAction();

    }
    public  void setReview(){
        Review review=new Review();
        System.out.println("please enter 1 if you want to rate resturant or 2 if you want to rate dish");
        int choose=scanner.nextInt();
        int rate;
        if (choose==1){
            System.out.println("Please enter the rate : ");
            rate=scanner.nextInt();
            review.setReviewForRestaurant(rate,restaurant);
        }
        else if (choose==2){
            System.out.println("Please enter the name of dish : ");
            String name=scanner.next();
            System.out.println("Please enter the rate : ");
            rate=scanner.nextInt();
            review.serReviewForDish(rate,name);
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
            System.out.println("If you want antoher action please enter 1 : ");
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
        System.out.println("1- if you want to add resturant : ");
        System.out.println("2- if you want to delete resturant : ");
        System.out.println("3- if you want to add menu : ");
        System.out.println("4- if you want to delete menu : ");

        return scanner.nextInt();
    }
    public  void addRestaurantAdmin(){
        Restaurant restaurant1=new Restaurant();

        System.out.println("Please enter name of resturant : ");
        restaurant1.name=scanner.next();
        System.out.println("Please enter address of resturant : ");
        restaurant1.address=scanner.next();
        System.out.println("Please enter contact information of resturant : ");
        restaurant1.contactInformation=scanner.next();
        System.out.println("Please enter rating of resturant : ");
        restaurant1.rating=scanner.nextDouble();
        System.out.println("next we want to add Menu items");
        Menu menu=new Menu();
        List<Menu>menus = null;
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
            menus.set(menus.size(),menu);
        }
        restaurant1.menu=menus;
        Admin.addRestaurant(restaurant1);
        doYouWantAnotherAction();
    }
    public  void deleteRestaurantAdmin(){

        System.out.println("Please enter name of resturant you need to delete : ");
        String name =scanner.next();
        Admin.deleteRestaurant(name);
    }
    public  void deleteMenu(){
        System.out.println("Enter name of resturant you need to delete menu from");
        String name=scanner.next();
        Admin.deleteMenu(name);
    }
    public  void modifiyQuantitie(){
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
    public void displayUserInfo(User user){

        user.displayUserInfo();

    }
    public void makeOrder(){
        System.out.println("Please enter deliveryaddress : ");
        String deliveryAddress=scanner.next();
        System.out.println("Please enter time of delivery : ");
        String timeOfDelivery=scanner.next();
        System.out.println("Do you want to pay with card if agree please enter 1 if cash please enter 0 : ");
        boolean cart=scanner.nextBoolean();
        String transiction;
        if (cart){
            System.out.println("Please enter transcition id : ");
            transiction=scanner.next();
        }else{
            System.out.println("Please enter transcition status");
            transiction=scanner.next();
        }
        Order order=new Order();
        order.setOrder(deliveryAddress,timeOfDelivery,transiction,cart);
    }
}
