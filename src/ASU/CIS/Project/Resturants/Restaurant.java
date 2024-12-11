package ASU.CIS.Project.Resturants;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Restaurant extends Menu implements Comparable<Restaurant> {

    public String name;
    public String address;
    public String contactInformation;
    public double rating;
    public void displayMenu(List<Dish>menu){
        for (int i=0;i< menu.size();i++){
            System.out.println("name of item "+(i+1) +" : "+menu.get(i).name);
            System.out.println("description of item "+(i+1) +" : "+menu.get(i).description);
            System.out.println("price of item "+(i+1) +" : "+menu.get(i).price);
            System.out.println("categories of item "+(i+1) +" : "+menu.get(i).categories);
            System.out.println("rating of item "+(i+1) +" : "+menu.get(i).rating);
        }
    }
    public void displayRestaurant(List<Restaurant>restaurants){
        int i=1;
        for (Restaurant restaurant:restaurants){
            System.out.println("Name of restaurant "+i+" : "+restaurant.name);
            System.out.println("address of restaurant "+i+" : "+restaurant.address);
            System.out.println("contact information of restaurant "+i+" : "+restaurant.contactInformation);
            System.out.println("Name of restaurant "+i+" : "+restaurant.rating);
            i++;
        }
    }
    public void displayRestaurantWithMenu(List<Restaurant>restaurants){
        int j=1;
        for (Restaurant restaurant:restaurants){
            System.out.println("Name of restaurant "+j+" : "+restaurant.name);
            System.out.println("address of restaurant "+j+" : "+restaurant.address);
            System.out.println("contact information of restaurant "+j+" : "+restaurant.contactInformation);
            System.out.println("Name of restaurant "+j+" : "+restaurant.rating);
            j++;
            for (int i=0;i< restaurant.menu.size();i++){
                System.out.println("name of item "+(i+1) +" : "+restaurant.menu.get(i).name);
                System.out.println("description of item "+(i+1) +" : "+restaurant.menu.get(i).description);
                System.out.println("price of item "+(i+1) +" : "+restaurant.menu.get(i).price);
                System.out.println("categories of item "+(i+1) +" : "+restaurant.menu.get(i).categories);
                System.out.println("rating of item "+(i+1) +" : "+restaurant.menu.get(i).rating);
            }
        }
    }
    public Restaurant getRestaurant(int i,List<Restaurant>restaurants){
        return restaurants.get(i-1);
    }
    public Dish getDish(int i,List<Dish>menu){
        return menu.get(i-1);
    }
    public Dish searchAboutDishWithName(String name){
        for (Dish dish : menu) {
            if (name.equals(dish.name)) {
                System.out.println("dish is available");
                return dish;
            }
        }
        System.out.println("dish is not available");
        return null;

    }
    public Dish searchAboutDishWithDescription(String description){
        for (Dish dish : menu) {
            if (description.equals(dish.description)) {
                System.out.println("dish is available");
                return dish;
            }

        }
        System.out.println("dish is not available ");
        return null;
    }
    public Dish searchAboutDishWithCategories(String categories){
        for (Dish dish : menu) {
            if (categories.equals(dish.categories)) {
                System.out.println("dish is available");
                return dish;
            }

        }
        System.out.println("dish is not available");
        return null;
    }

    @Override
    public int compareTo(Restaurant o) {
        if (this.rating>o.rating){
            return 1;
        }else if (this.rating<o.rating){
            return -1;
        }
        return 0;
    }
    public void saveData(List<Restaurant> restaurantList) {
        try {
            BufferedWriter fileWriter=new BufferedWriter(new FileWriter("Data/restaurant.txt"));
               for (Restaurant restaurant :restaurantList) {
                   fileWriter.write(restaurant.name+'\n'+restaurant.address+'\n'+restaurant.contactInformation+'\n'+restaurant.rating+'\n');
                   for ( int i=0;i<restaurant.menu.size();i++){
                       fileWriter.write(restaurant.menu.get(i).name+'\n'+restaurant.menu.get(i).description+'\n'+restaurant.menu.get(i).price+'\n'+restaurant.menu.get(i).categories+'\n'+restaurant.menu.get(i).rating+'\n');
                   }
                   fileWriter.write('\n');
               }

            fileWriter.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    public List<Restaurant> loadData(){
        List<Restaurant>restaurantList=new ArrayList<>();
        try {
            BufferedReader reader=new BufferedReader(new FileReader("Data/restaurant.txt"));
            int i=0;
            int j=0;
            String line;
            Dish dish=new Dish();
            Restaurant restaurant=new Restaurant();
            while ((line =reader.readLine())!=null){
                restaurant.name=line;
                line=reader.readLine();
                restaurant.address=line;
                line=reader.readLine();
                restaurant.contactInformation=line;
                line=reader.readLine();
                restaurant.rating=Double.parseDouble(line);
                List<Dish>menu=new ArrayList<>();
                while (!(line =reader.readLine()).isEmpty()){
                 //   System.out.println(j);
                    dish.name=line;
                    line=reader.readLine();
                    dish.description=line;
                    line=reader.readLine();
                    dish.price=Double.parseDouble(line);
                    line=reader.readLine();
                    dish.categories=line;
                    line=reader.readLine();
                    dish.rating=Double.parseDouble(line);
                    menu.add(j,dish);
                    dish=new Dish();
                    j++;
                }
                restaurant.menu=menu;
                restaurantList.add(i,restaurant);
                restaurant=new Restaurant();
                j=0;
                i++;
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        return restaurantList;
    }
    public String toString() {
        return this.name + '\n' + this.address + '\n' + this.contactInformation + '\n' + this.rating + '\n' + this.menu +"\n\n";
    }
}
