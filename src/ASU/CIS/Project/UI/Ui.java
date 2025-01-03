package ASU.CIS.Project.UI;

import ASU.CIS.Project.Interfaces.checkNumberValid;
import ASU.CIS.Project.Orders.Order;
import ASU.CIS.Project.Orders.OrderState;
import ASU.CIS.Project.Orders.AllOrders;
import ASU.CIS.Project.Payment.Card;
import ASU.CIS.Project.Person.Admin;
import ASU.CIS.Project.Person.Customer;
import ASU.CIS.Project.Person.Delivery_Staff;
import ASU.CIS.Project.Person.User;
import ASU.CIS.Project.Resturants.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;


public class Ui extends Thread implements checkNumberValid {
    Order order=new Order();
    @Override
    public void run(){
        Scanner scan = new Scanner(System.in);
        while (true) {
            int choose = firstPage();
            if (choose == 1) {
                try {
                    customerPath();
                } catch (URISyntaxException | IOException e) {
                    throw new RuntimeException(e);
                }
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
               System.exit(0);
            }
        }
    }
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
        System.out.println("[8] if you want to search for a dish by it's category");
        System.out.println("[9] if you want to search for a dish by it's name");
        System.out.println("[10] if you want to set a price range for dishes");
        System.out.println("[11] if you want to display the restaurants in order");
        System.out.println("[12] if you want to get location in google map");
        System.out.println("[13] if you want to get suggestion about dish in menu");
        System.out.println("[14] if you want to view your order's current state");
        System.out.println("[15] if you want to view order");
        System.out.println("[16] if you want to search about restaurant with address");
        System.out.println("[17] if you want to cancel order");
        System.out.println("[18] if you want to show all the orders you have made so far");
        System.out.println("[19] if you want to log out");
        System.out.print("choice No. : ");
        return checkNumber(1,19,"Please enter a valid number: ");
    }
    public  int homePageAdmin(){
        System.out.println("Hello in home page please enter the number of the action you want to operate");
        System.out.println("[1] if you want to add a restaurant");
        System.out.println("[2] if you want to delete a restaurant");
        System.out.println("[3] if you want to add a menu");
        System.out.println("[4] if you want to delete a menu");
        System.out.println("[5] if you want to display restaurant with a menu");
        System.out.println("[6] if you want to add a delivery staff member");
        System.out.println("[7] if you want to set report about restaurant");
        System.out.println("[8] if you want to log out");
        System.out.print("choice No. : ");
        return checkNumber(1,8,"Please enter a valid number: ");
    }
    public  int homePageDelivery() {
        System.out.println("Hello in home page please enter the number of the action you want to operate");
        System.out.println("[1] if you want to set order state ");
        System.out.println("[2] if you want to see order details");
        System.out.println("[3] if you want to display all orders");
        System.out.println("[4] if you want to log out");
        System.out.print("choice No. : ");
        return checkNumber(1,4,"Please enter a valid number");
    }
    public void customerPath() throws URISyntaxException, IOException {
        //up casting
        User user=new Customer();
        //down casting
        Customer customer = (Customer) user;
        int choose=loginOrSignup();
        if (choose==1){
            customer= customer.login();
        }
        else if(choose==2){
            customer.signup();
        }
        Restaurant restaurant=new Restaurant();
        List<Restaurant>restaurants=restaurant.loadData();
        Scanner scanner=new Scanner(System.in);
        Dish dish=new Dish();
        Review rev=new Review();
        List<Order>orders=order.loadData();
        List<Order>orderMakeByUser=new ArrayList<>();
        List<Review>reviewsRestaurant=rev.loadDataReviewRestaurant();
        List<Review>reviewsDelivery=rev.loadDataReviewDelivery();
        Random random=new Random();
        int h=random.nextInt(restaurants.size());
        Notification notification=new Notification(customer.getFname(),restaurants.get(h).name);
        notification.start();
        AllOrders allOrders=new AllOrders();
        allOrders=allOrders.loadData();
        List<Order>orderHistory=new ArrayList<>();
        boolean userMakeOrder=false;
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
            }
            else if (choose==2){
                restaurant.displayRestaurantWithMenu(restaurants);
                System.out.print("choose which restaurant you want to view : ");
                int number= checkNumber(1,restaurants.size(),"Invalid character. Please enter a valid number: ");
                if (number<=restaurants.size()){
                    restaurant=restaurants.get(number-1);
                }else{
                    System.out.print("number is wrong try again: ");
                }
            }
            else if (choose==3){
                if (restaurant.name!=null){
                    restaurant.displayMenu(restaurant.menu);
                    System.out.print("choose the Dish you want to order : ");
                    int number= checkNumber(1,restaurant.menu.size(),"Invalid character. Please enter a valid number: ");
                    if (number<=restaurant.menu.size()){
                        dish=restaurant.menu.get(number-1);
                    }else{
                        System.out.print("number is wrong try again: ");
                    }
                }
                else{
                    System.out.println("You should choose restaurant first");
                }
            }
            else if (choose==4){
                System.out.println("Please enter your location : ");
                String orderLocation = scanner.nextLine();
                Order order1=new Order(orderLocation,OrderState.Preparing,customer.getEmail());
                order1.setTotalPrice(order.getOrderPrice());
                order1.makeOrder();
                AllOrders.orderList.add(order1);

                orders.add(order1);
                userMakeOrder=true;
            }
            else if (choose==5){
                order.addFoodItem(dish);
            }
            else if (choose==6){
                Review review=new Review(restaurant);
                System.out.println("Please enter the rating : ");
                for (Review value : reviewsRestaurant) {
                    if (value.restaurant.name.equals(restaurant.name)) {
                        review.number_of_reviewsR++;
                    }
                }
                review.setReviewForRestaurant(checkNumber(1.0,5.0,"Invalid character please enter number : "));
                reviewsRestaurant.add(review);

            }
            else if (choose==7){
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
                for (Review value : reviewsDelivery) {
                    if (value.nameOfDelivery.equals(deliveryStaff.getFname())) {
                        review.number_of_reviewsDS++;
                    }
                }
                review.setReviewForDeliveryStaff(deliveryStaff,checkNumber(1.0,5.0,"Invalid character please enter number : "));
                reviewsDelivery.add(review);
            }
            else if (choose==8){
                if (restaurant.menu!=null){
                    System.out.println("Please enter what category you want to search : ");
                    String type=scanner.nextLine();
                    List<Dish>dishes= restaurant.menu.stream().
                            filter(dish2-> Objects.equals(dish2.categories, type)).toList();
                    restaurant.displayMenu(dishes);
                    System.out.println("Please enter the number of the dish you want to select : ");
                    int number= checkNumber(1,dishes.size(),"Invalid character. Please enter a valid number: ");
                    dish=dishes.get(number-1);
                }
                else {
                    System.out.println("you should choose restaurant first");
                }
            }
            else if (choose==9){
                if (!restaurant.menu.isEmpty()){
                    System.out.println("Please enter the name of the dish you want to search : ");
                    String name=scanner.nextLine();
                    List<Dish>dishes= restaurant.menu.stream().filter(dish1 -> dish1.name.equals(name)).toList();
                    if (dishes.getFirst()==null){
                        System.out.println("name is not found");
                    }
                    else{
                        dish=dishes.getFirst();
                    }
                }
                else{
                    System.out.println("You should choose restaurant first");
                }
            }
            else if (choose==10) {
                if (!restaurant.menu.isEmpty()){
                    System.out.println("enter the highest price you want to search : ");
                    int price=checkNumber(1,1000,"Invalid character. Please enter a valid number: ");
                    List<Dish>dishes=restaurant.menu.stream().filter(dish1 -> dish1.price<price).toList();
                    restaurant.displayMenu(dishes);
                    System.out.println("Please enter the number of the dish you want to select : ");
                    int number= checkNumber(1,dishes.size(),"Invalid character. Please enter a valid number: ");
                    dish=dishes.get(number-1);
                }
                else{
                    System.out.println("You should choose restaurant first");
                }
            }
            else if (choose==11){
                Customer finalCustomer = customer;
                List<Restaurant>restaurantList=restaurants
                        .stream()
                        .filter(restaurant1 -> restaurant1.address.equals(finalCustomer.getAddress()))
                        .toList();
                if(!restaurantList.isEmpty()){
                    restaurant.displayRestaurant(restaurantList);
                    System.out.print("choose which restaurant you want to view : ");
                    int number= checkNumber(1,restaurantList.size(),"Invalid character. Please enter a valid number: ");
                    restaurant=restaurantList.get(number-1);
                }else{
                    System.out.println("im sorry but not exist restaurant in your location");
                }

            }
            else if (choose==12){
                if (restaurant.name!=null){
                    restaurant.getLocation();
                }else{
                    System.out.println("You should choose restaurant first");
                }

            }
            else if (choose==13){
                if (restaurant.name!=null){
                    int number=random.nextInt(restaurant.menu.size());
                    System.out.println("name of item " +" : "+restaurant.menu.get(number).name);
                    System.out.println("description of item " +" : "+restaurant.menu.get(number).description);
                    System.out.println("price of item " +" : "+restaurant.menu.get(number).price);
                    System.out.println("type of item " +" : "+restaurant.menu.get(number).categories);
                    System.out.println("rating of item " +" : "+restaurant.menu.get(number).rating);
                    System.out.println("If you want to accept enter 1 or 0 to reject : ");
                    int number1=checkNumber(0,1,"enter valid number");
                    if (number1==1){
                        dish=restaurant.menu.get(number);
                    }else{
                        System.out.println("ok thank you");
                    }
                }else{
                    System.out.println("you should choose restaurant first");
                }
            }
            else if(choose == 14){
                orderMakeByUser=new ArrayList<>();
                for (Order order1:orders){
                    if (order1.getEmailUser().equals(customer.getEmail())){
                        orderMakeByUser.add(order1);
                    }
                }
                if (!orderMakeByUser.isEmpty()){
                    System.out.println("order's current state is : "+orderMakeByUser.getLast().getOrderState());
                }
                else{
                    System.out.println("You should make an order first");
                }
            }
            else if (choose==15){
                orderMakeByUser=new ArrayList<>();
                for (Order order1:orders){
                    if (order1.getEmailUser().equals(customer.getEmail())){
                        orderMakeByUser.add(order1);
                    }
                }
                if (!orderMakeByUser.isEmpty()){
                    System.out.println("order id is : "+orderMakeByUser.getLast().getOrderId());
                    System.out.println("order date is : "+orderMakeByUser.getLast().getOrderDate());
                    System.out.println("order total price is : "+orderMakeByUser.getLast().getOrderPrice());
                    System.out.println("order location is : "+orderMakeByUser.getLast().getOrderLocation());
                    System.out.println("order state is : "+orderMakeByUser.getLast().getOrderState());
                    if (userMakeOrder){
                        for (int i=0;i<Order.foodItems.size();i++){
                            System.out.println("Name of item : "+Order.foodItems.get(i).name);
                            System.out.println("Quantity of item : "+Order.quantites.get(i));
                        }
                    }

                }else{
                    System.out.println("You should make an order first");
                }

            }
            else if (choose==16){
                System.out.println("Please enter the address you want to search in : ");
                String address=scanner.nextLine();
                List<Restaurant>restaurantList=restaurants
                        .stream()
                        .filter(restaurant1 -> restaurant1.address.equals(address))
                        .toList();
                if(!restaurantList.isEmpty()){
                    restaurant.displayRestaurant(restaurantList);
                    System.out.print("choose which restaurant you want to view : ");
                    int number= checkNumber(1,restaurantList.size(),"Invalid character. Please enter a valid number: ");
                    restaurant=restaurantList.get(number-1);
                }else{
                    System.out.println("i'm sorry but there isn't a restaurant in that location");
                }
            }
            else if (choose==17){
                orderMakeByUser=new ArrayList<>();
                for (Order order1:orders){
                    if (order1.getEmailUser().equals(customer.getEmail())){
                        orderMakeByUser.add(order1);
                    }
                }
                if (!orderMakeByUser.isEmpty()&&orderMakeByUser.getLast().getOrderState()!=OrderState.Complete){
                    System.out.println("if you want to cancel the order please enter 1 if you don't want to cancel enter 0 : ");
                    int number=checkNumber(0,1,"enter number valid");
                    if (number==1){
                        orders.remove(orders.size()-1);
                        AllOrders.orderList.remove(AllOrders.orderList.size()-1);
                        orderMakeByUser.remove(orderMakeByUser.size()-1);
                        userMakeOrder=false;
                    }
                }else{
                    System.out.println("You should make order first");
                }
            }
            else if (choose==18){
                orderHistory=new ArrayList<>();
                for (Order order1:AllOrders.orderList){
                    if (order1.getEmailUser().equals(customer.getEmail())){
                        orderHistory.add(order1);
                    }
                }
                System.out.println("All the orders you made so far are : ");
                for (Order order1: orderHistory){
                    System.out.println("order's id is : "+order1.getOrderId());
                    System.out.println("order's total price is : "+order1.getOrderPrice());
                    System.out.println("order's location is : "+order1.getOrderLocation());
                }
            }
            else if(choose == 19){
                x = logOut();
            }
        }while (x==1);
        restaurant.saveData(restaurants);
        rev.saveDataReviewDelivery(reviewsDelivery);
        rev.saveData(reviewsRestaurant);
        order.saveData(orders);
        allOrders.saveData(allOrders);
    }
    public void adminPath()
    {
        Admin admin = new Admin();
        int choose= loginOrSignup();
        if (choose==1){
            admin.login();
        }else if (choose==2){
            admin.signup();
        }
        int x = 1;
        Restaurant restaurant=new Restaurant();
        List<Restaurant>restaurants=restaurant.loadData();
        Report report=new Report();
        List<Report>reports=report.loadData();
        do {
            choose = homePageAdmin();
            if (choose == 1) {
                Admin.restaurants = restaurants;
                admin.addRestaurant();
                restaurants = Admin.restaurants;
            }else if (choose == 2) {
                Admin.restaurants = restaurants;
                admin.deleteRestaurant();
                restaurants = Admin.restaurants;
            }else if (choose == 3) {
                Admin.restaurants = restaurants;
                admin.addMenu();
                restaurants = Admin.restaurants;
            }else if (choose == 4) {
                Admin.restaurants = restaurants;
                admin.deleteMenu();
                restaurants = Admin.restaurants;
            }else if (choose == 5) {
                restaurant.displayRestaurantWithMenu(restaurants);
            }else if (choose == 6){
                Delivery_Staff delivery= new Delivery_Staff("shubra");
                delivery.signup();
            }else if (choose==7){
                report.setReport(restaurants);
                reports.add(report);

            }
            else if (choose==8) {
                x = logOut();
            }
        }while (x==1);
        restaurant.saveData(restaurants);
        report.saveData(reports);
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
        Order order1=new Order();
        List<Order>orders=order1.loadData();
        do {
            choose = homePageDelivery();
            if (choose == 1) {
                System.out.println("enter the order's ID : ");
                String ID = scanner.nextLine();
                for (Order order2:orders){
                    if(ID.equals(order2.getOrderId())) {
                        order=order2;
                        System.out.println("what's current order state?");
                        order.setOrderState(OrderState.valueOf(scanner.nextLine()));
                    }
                }
            }
            else if (choose == 2) {
                System.out.println("Please enter the order's ID : ");
                String ID = scanner.nextLine();
                for (Order order2:orders){
                    if(ID.equals(order2.getOrderId())) {
                        System.out.println("Order's ID : " + order2.getOrderId());
                        System.out.println("Order's price is : " + order2.getOrderPrice());
                        System.out.println("Order's Location : " + order2.getOrderLocation());
                        System.out.println("Order's State : " + order2.getOrderState());
                    }
                }

            }
            else if (choose==3){
                for (Order order2:orders){
                    System.out.println("Order's ID : " + order2.getOrderId());
                    System.out.println("Order's price is : " + order2.getOrderPrice());
                    System.out.println("Order's Location : " + order2.getOrderLocation());
                    System.out.println("Order's State : " + order2.getOrderState());
                }
            }
            else if(choose == 4)
                x = logOut();
        }while(x == 1);
        order1.saveData(orders);
    }
    public void saveData(){
        Customer customer=new Customer();
        customer.saveData();

        Admin admin=new Admin();
        admin.saveData();

        Delivery_Staff deliveryStaff=new Delivery_Staff("shubra");
        deliveryStaff.saveData();

        Card card=new Card();
        card.saveData();

    }
    public void loadData(){
        Customer customer = new Customer();
        customer.loadData();

        Admin admin = new Admin();
        admin.loadData();


        Card card = new Card();
        card.loadData();

        Delivery_Staff deliveryStaff=new Delivery_Staff("shubra");
        deliveryStaff.loadData();
    }

}
