import ASU.CIS.Project.Payment.Card;
import ASU.CIS.Project.UI.*;
import ASU.CIS.Project.Person.*;
import ASU.CIS.Project.Resturants.*;
import ASU.CIS.Project.Orders.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Ui ui=new Ui();
        int choose=ui.firstPage();
        if (choose==1){
            Customer customer = new Customer();
            customer.loadData();
            choose=ui.loginOrSignup();
            if (choose==1){
                customer.login();
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

            int x;
            do {
                choose=ui.homePage();
                if (choose==1){
                    restaurant.displayRestaurant(restaurants);
                    System.out.println("Enter number of restaurant you want : ");
                    restaurant=restaurants.get(scanner.nextInt()-1);
                }
                else if (choose==2){
                    restaurant.displayRestaurantWithMenu(restaurants);
                    System.out.println("Enter number of restaurant you want : ");
                    restaurant=restaurants.get(scanner.nextInt()-1);
                }
                else if (choose==3){
                    restaurant.displayMenu(restaurant.menu);
                    System.out.println("Enter number of Dish you want : ");
                    dish=restaurant.menu.get(scanner.nextInt()-1);
                }
                else if (choose==4){
                    System.out.println("Please enter order location : ");
                    String orderLocation = scanner.nextLine();
                    Order order=new Order(orderLocation,"Preparing");
                    order.addFoodItem(dish);
                }
                else if (choose==5){

                }
                else if (choose==6){
                    Review review=new Review(restaurant);
                    System.out.println("Please enter rating : ");
                    review.setReviewForRestaurant(scanner.nextDouble());
                }
                else if (choose==7){
                    Review review=new Review(restaurant);
                    System.out.println("Please enter rating : ");
                    review.setReviewForDish(scanner.nextDouble(),dish.name);
                }
                else if (choose==8){

                }

                x= ui.doYouWantAnotherAction();
            }while (x==1);
           restaurant.saveData(restaurants);
           customer.saveData();
           card.saveData();
        }
        else if (choose==2){
            Admin admin = new Admin();
            admin.loadData();
            choose= ui.loginOrSignup();
            if (choose==1){
                admin.login();
            }
            else if (choose==2){
                admin.signup();
            }
            int x;
            Restaurant restaurant=new Restaurant();
            List<Restaurant>restaurants=restaurant.loadData();
            do {
                choose= ui.homePageAdmin();
                if (choose==1){
                    Admin.restaurants=restaurants;
                    admin.addRestaurant();
                    restaurants=Admin.restaurants;
                }
                else if (choose==2){
                    Admin.restaurants=restaurants;
                    admin.deleteRestaurant();
                    restaurants=Admin.restaurants;
                }
                else if (choose==3){
                    Admin.restaurants=restaurants;
                    admin.addMenu();
                    restaurants=Admin.restaurants;
                }
                else if (choose==4){
                    Admin.restaurants=restaurants;
                    admin.deleteMenu();
                    restaurants=Admin.restaurants;
                }
                else if (choose==5){
                    restaurant.displayRestaurantWithMenu(restaurants);
                }
                else if (choose==6){

                }

               x = ui.doYouWantAnotherAction();
            }while (x==1);
            restaurant.saveData(restaurants);
            admin.saveData();
        }
        else if (choose==3){
            Delivery_Staff deliveryStaff=new Delivery_Staff("cairo");
        }

    }
}