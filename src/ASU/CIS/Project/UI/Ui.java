package ASU.CIS.Project.UI;

import ASU.CIS.Project.Interfaces.checkNumberValid;
import ASU.CIS.Project.Orders.Order;
import ASU.CIS.Project.Payment.Card;
import ASU.CIS.Project.Person.Admin;
import ASU.CIS.Project.Person.Customer;
import ASU.CIS.Project.Person.Delivery_Staff;
import ASU.CIS.Project.Resturants.Dish;
import ASU.CIS.Project.Resturants.Restaurant;
import ASU.CIS.Project.Resturants.Review;

import java.util.List;
import java.util.Scanner;

public class Ui implements checkNumberValid {

    Order order=new Order();

    public  int firstPage(){
        System.out.println("welcome to the restaurant ");
        System.out.println("please enter the number of the action you want to operate");
        System.out.println("[1] if you want to continue as a customer ");
        System.out.println("[2] if you want to continue as an Admin ");
        System.out.println("[3] if you want to continue as a Delivery Staff Member ");
        System.out.print("choice No. : ");
        return checkNumber(1,3,"Please enter a valid number: ");
    }
    public  int loginOrSignup(){
        System.out.println("welcome to the restaurant ");
        System.out.println("Please enter the number of the action you want to operate");
        System.out.println("[1] if you want to log in");
        System.out.println("[2] if you want to sign up");
        System.out.print("choice No. : ");
        return checkNumber(1,2,"Please enter a valid number: ");
    }
    public int logOut(){
        System.out.println("you are logged out");
        return 0;
    }
    public  int homePage(){
        System.out.println("Hello in home page please enter the number of the action you want to operate");
        System.out.println("[1] if you want to display the restaurants");
        System.out.println("[2] if you want to display the restaurants with the menu");
        System.out.println("[3] if you want to display the menu");
        System.out.println("[4] if you want to make an order");
        System.out.println("[5] if you want to add item to your order");
        System.out.println("[6] if you want to make a review for the restaurant");
        System.out.println("[7] if you want to review the Delivery staff member");
        System.out.println("[8] if you want to log out");
        System.out.print("choice No. : ");
        return checkNumber(1,8,"Please enter a valid number: ");
    }

    public  int doYouWantAnotherAction(){
        int choose;
        do {
            System.out.println("[1] Another action");
            System.out.println("[2] Exit the program");
            System.out.print("Choice No. : ");
            choose =checkNumber(1,2,"Please enter a valid number: ");
            if (choose==1){
                return choose;
            } else if (choose==2){
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
        return checkNumber(1,6,"Please enter a valid number: ");
    }
    public  int homePageDelivery() {
        System.out.println("Hello in home page please enter the number of the action you want to operate");
        System.out.println("[1] if you want to set order state ");
        System.out.println("[2] if you want to see order details");
        System.out.println("[3] if you want to log out");
        System.out.print("choice No. : ");
    return checkNumber(1,2,"Please enter a valid number");
    }
    public void customerPath() {
        Customer customer = new Customer();
        customer.loadData();
        int choose=loginOrSignup();
        if (choose==1){
            //      customer.login();
        }
        else if(choose==2){
            customer.signup();
        }
        Restaurant restaurant=new Restaurant();
        List<Restaurant>restaurants=restaurant.loadData();
        Scanner scanner=new Scanner(System.in);
        Dish dish=new Dish();
        Card card = new Card();
        card.loadData();
        Review rev=new Review();
        List<Review>reviewsRestaurant=rev.loadDataReviewRestaurant();
        List<Review>reviewsDelivery=rev.loadDataReviewDelivery();
        int x = 1;
        do {
             choose=homePage();
            if (choose==1){
                restaurant.displayRestaurant(restaurants);
                System.out.print("choose which restaurant you want to view : ");
                int number= checkNumber(1,restaurants.size(),"Invalid character. Please enter a valid number: ");
                if (number<=restaurants.size()){
                    restaurant=restaurants.get(number-1);
                }else{
                    System.out.print("number is wrong try again: ");
                }
            }else if (choose==2){
                restaurant.displayRestaurantWithMenu(restaurants);
                System.out.print("choose which restaurant you want to view : ");
                int number= checkNumber(1,restaurants.size(),"Invalid character. Please enter a valid number: ");
                if (number<=restaurants.size()){
                    restaurant=restaurants.get(number-1);
                }else{
                    System.out.print("number is wrong try again: ");
                }
            }else if (choose==3){
                restaurant.displayMenu(restaurant.menu);
                System.out.print("choose the Dish you want to order : ");
                int number= checkNumber(1,restaurants.size(),"Invalid character. Please enter a valid number: ");
                if (number<=restaurant.menu.size()){
                    dish=restaurant.menu.get(number-1);
                }else{
                    System.out.print("number is wrong try again: ");
                }

            }else if (choose==4){
                System.out.println("Please enter your location : ");
                scanner.nextLine();//clean buffer
                String orderLocation = scanner.nextLine();
                Order order=new Order(orderLocation,"Preparing");
                order.makeOrder();
            }else if (choose==5){
                order.addFoodItem(dish);
            }else if (choose==6){
                Review review=new Review(restaurant);
                System.out.println("Please enter the rating : ");
                for(int i=0;i<reviewsRestaurant.size();i++){
                    if (reviewsRestaurant.get(i).restaurant.name.equals(restaurant.name)){
                        review.number_of_reviewsR++;
                    }
                }
                review.setReviewForRestaurant(scanner.nextDouble());
                reviewsRestaurant.add(review);

            }else if (choose==7){
                Review review=new Review();
                System.out.println("Please enter name of the delivery staff member : ");
                scanner.nextLine();
                String name=scanner.nextLine();
                System.out.println("Please enter location of delivery : ");
                String location = scanner.nextLine();
                System.out.println("please enter your rating : ");
                //we should make check to get delivery from file important
                Delivery_Staff deliveryStaff=new Delivery_Staff(location);
                deliveryStaff.setFname(name);
                for(int i=0;i<reviewsDelivery.size();i++){
                    if (reviewsDelivery.get(i).nameOfDelivery.equals(deliveryStaff.getFname())){
                        review.number_of_reviewsDS++;
                    }
                }
                review.setReviewForDeliveryStaff(deliveryStaff,scanner.nextDouble());
                reviewsDelivery.add(review);
            }else if(choose == 8)
                x = logOut();
        }while (x==1);
        restaurant.saveData(restaurants);
        customer.saveData();
        card.saveData();
        rev.saveDataReviewDelivery(reviewsDelivery);
        rev.saveData(reviewsRestaurant);
    }
    public void adminPath()
    {
        Admin admin = new Admin();
        admin.loadData();
        int choose= loginOrSignup();
        if (choose==1){
            //    admin.login();
        }else if (choose==2){
            admin.signup();
        }
        int x = 1;
        Restaurant restaurant=new Restaurant();
        List<Restaurant>restaurants=restaurant.loadData();
        do {
            choose= homePageAdmin();
            if (choose==1){
                Admin.restaurants=restaurants;
                admin.addRestaurant();
                restaurants=Admin.restaurants;
            }else if (choose==2){
                Admin.restaurants=restaurants;
                admin.deleteRestaurant();
                restaurants=Admin.restaurants;
            }else if (choose==3){
                Admin.restaurants=restaurants;
                admin.addMenu();
                restaurants=Admin.restaurants;
            }else if (choose==4){
                Admin.restaurants=restaurants;
                admin.deleteMenu();
                restaurants=Admin.restaurants;
            }else if (choose==5){
                restaurant.displayRestaurantWithMenu(restaurants);
            }else if(choose==6)
                x = logOut();
        }while (x==1);
        restaurant.saveData(restaurants);
        admin.saveData();
    }
    public void deliveryPath()
    {
        int x = 1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the location you work in : ");
        String location =scanner.nextLine();
        Delivery_Staff deliveryStaff=new Delivery_Staff(location);
        int choose=loginOrSignup();
        if (choose==1){
            deliveryStaff.login();
        }else if (choose==2){
            deliveryStaff.signup();
        }
        do {
            choose = homePageDelivery();
            if (choose == 1) {
                System.out.println("what's current order state?");
                order.setOrderState(scanner.nextLine());
            }else if (choose == 2) {
                System.out.println("Please enter the order's ID : ");
                String ID = scanner.nextLine();
                if(ID.equals(order.getOrderId())) {
                    System.out.println("Order's ID : " + order.getOrderId());
                    System.out.println("Order's date : " + order.getOrderDate());
                    System.out.println("Order's price is : " + order.getOrderPrice());
                    System.out.println("Order's Location : " + order.getOrderLocation());
                    System.out.println("Order's State : " + order.getOrderState());
                }
            }else if(choose == 3)
                x = logOut();
        }while(x == 1);
    }
    public void runProject() {
        Scanner scan = new Scanner(System.in);
        boolean x = true;
        while (x) {
            int choose = firstPage();
            if (choose == 1) {
                customerPath();
            }else if (choose == 2) {
                adminPath();
            }else if (choose == 3) {
                deliveryPath();
            }
            System.out.println("[0] if you want to close the program");
            System.out.println("[1] if you want to go to the login screen");
            choose = scan.nextInt();
            if(choose == 0)
            {
                x = false;
            }
        }
    }
}
