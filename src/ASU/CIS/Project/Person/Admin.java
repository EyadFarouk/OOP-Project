package ASU.CIS.Project.Person;

import ASU.CIS.Project.Resturants.Menu;
import ASU.CIS.Project.Resturants.Restaurant;

import java.util.List;

public class Admin extends Person{
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
}
