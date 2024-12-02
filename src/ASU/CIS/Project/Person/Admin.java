package ASU.CIS.Project.Person;

import ASU.CIS.Project.Resturants.Menu;
import ASU.CIS.Project.Resturants.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends User {
   public static List<Restaurant>restaurants;

   public static Restaurant getRestaurant(String name){
      try {
          for (Restaurant restaurant:restaurants){
              if (name.equals(restaurant.name)){
                  return restaurant;
              }
          }
      }catch (Exception e){
          System.out.println("Restaurant not found");
      }
       return null;
   }
   public static int getMenu(String name,Restaurant restaurant){
       int i;
     try {
         for (i=0;i<restaurant.menu.size();i++){
             if(name.equals(restaurant.menu.get(i).name)){
                 return i;
             }
         }
     }catch (Exception e){
         System.out.println("Dish not found");
     }
       return 10000;
   }
   public static void addRestaurant(Restaurant restaurant){

       restaurants.set(restaurants.size(), restaurant);

    }
   public static void deleteRestaurant(String name){

       restaurants.remove(getRestaurant(name));

    }
   public static void addMenu(Menu menu){

    }
    public static void deleteMenu(String name){

        if (getRestaurant(name)==null){
            System.out.println("Restaurant not found");
        }else{
            getRestaurant(name).menu.clear();
        }

    }
    public static void deleteDish(String nameOfRestaurant,String nameOfDish){
        Restaurant restaurant=getRestaurant(nameOfRestaurant);
        if (restaurant==null){
            System.out.println("Restaurant is not found");
        }
        else{
            int index=getMenu(nameOfDish,restaurant);
            if (index==10000){
                System.out.println("Dish not found");
            }
            else{
                restaurant.menu.remove(index);
            }

        }

    }

    @Override
    public void signup() {
        // hard code to test
        List<Admin> adminList=new ArrayList<>();
        Admin admin1=new Admin();
        admin1.email="mohamedtalat";
        admin1.password="1234567";
        Admin admin2=new Admin();
        admin2.email="talat saber";
        admin2.password="1234578";
        adminList.add(admin1);
        adminList.add(admin2);
        // end hard code
        System.out.println("Welcome in sign up page");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your first name : ");
        this.Fname=scanner.next();
        System.out.println("Please enter your last name : ");
        this.Lname=scanner.next();
        System.out.println("Please enter your email : ");
        this.email=scanner.next();
        System.out.println("Please enter your phone number : ");
        this.phone=scanner.next();
        System.out.println("Please enter your age : ");
        this.age=scanner.nextInt();
        System.out.println("Please enter your gender : ");
        this.gender=scanner.next();
        System.out.println("Please enter your address : ");
        this.address=scanner.next();
        System.out.println("Please enter your password : ");
        this.password=scanner.next();
        for (Admin admin : adminList) {
            if (this.email.equals(admin.email)) {
                System.out.println("im sorry email must be unique");
                signup();
            }
        }
        System.out.println("sign up succeful");
    }

    @Override
    public Admin login() {
        // hard code to test
        List<Admin> adminList=new ArrayList<>();
        Admin admin1=new Admin();
        admin1.email="mohamedtalat";
        admin1.password="1234567";
        Admin admin2=new Admin();
        admin2.email="talat saber";
        admin2.password="1234578";
        adminList.add(admin1);
        adminList.add(admin2);
        // end hard code
        System.out.println("Welcome in Log in page");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your email : ");
        this.email=scanner.next();
        System.out.println("Please enter your password : ");
        this.password=scanner.next();
        for (int i=0;i<adminList.size();i++){
            if (this.email.equals(adminList.get(i).email)){
                if (this.password.equals(adminList.get(i).password)){
                    System.out.println("log in success");
                }
                else if (i==adminList.size()-1){
                    System.out.println("the email or password is not correct");
                    login();
                }
            }
            else if (i==adminList.size()-1){
                System.out.println("the email or password is not correct");
                login();
            }
        }
        return admin2;
    }
}
