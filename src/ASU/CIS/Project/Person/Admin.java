package ASU.CIS.Project.Person;

import ASU.CIS.Project.Resturants.Menu;
import ASU.CIS.Project.Resturants.Restaurant;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends User {
   public static List<Restaurant>restaurants;
   static List<Admin> adminList=new ArrayList<>();

   static public void instance(){
        Admin Eyad=new Admin();
        Eyad.email="Eyad";
        Eyad.password="Eyad";
        adminList.add(Eyad);
        for (int i = 0; i < 10; i++) {
            Admin admin=new Admin();
            admin.Fname="Fname"+i;
            admin.Lname="Lname"+i;
            admin.email="email"+i+"@email.com";
            admin.phone="phone"+i;
            admin.age=1;
            admin.gender="male";
            admin.address="address"+i;
            admin.password="password"+i;
            adminList.add(admin);
            admin.displayUserInfo();
        }
   }

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

       restaurants.add(restaurants.size(), restaurant);

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
       super.signup();
        for (Admin admin : adminList) {
            if (this.email.equals(admin.email)) {
                System.out.println("im sorry email must be unique");
                signup();
            }
        }
        System.out.println("sign up succeful");
        adminList.add(this);
    }

    @Override
    public Admin login() {
       do {
           System.out.println("Welcome in Log in page");
           Scanner scanner = new Scanner(System.in);
           System.out.println("Please enter your email : ");
           this.email = scanner.next();
           System.out.println("Please enter your password : ");
           this.password = scanner.next();
           for (int i = 0; i < adminList.size(); i++) {
               if (this.email.equals(adminList.get(i).email)) {
                   if (this.password.equals(adminList.get(i).password)) {
                       System.out.println("log in success");
                       return adminList.get(i);
                   } else if (i == adminList.size() - 1) {
                       System.out.println("the email or password is not correct");
                   }
               } else if (i == adminList.size() - 1) {
                   System.out.println("the email or password is not correct");
               }
           }
       }while (true);
    }

    @Override
    public void saveData() {
        FileWriter fw;
        try {
            fw = new FileWriter("Data/AdminData.csv");
            fw.write("FName,LName,Email,Phone,Age,Gender,Address,Password\n");
            for (Admin admin:adminList) {
                fw.append(admin.toString());}
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String toString() {
        return this.Fname + ',' + this.Lname + ',' + this.email + ',' + this.phone + ',' + this.age + ',' + this.gender + ',' + this.address + ',' + this.password + ','+'\n';
    }
}
