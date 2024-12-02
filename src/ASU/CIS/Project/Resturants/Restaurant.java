package ASU.CIS.Project.Resturants;

import ASU.CIS.Project.Person.Customer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Restaurant extends Menu implements Comparable<Restaurant> {

    public String name;
    public String address;
    public String contactInformation;
    public double rating;
    public void displayMenu(){
        for (int i=0;i<10;i++){
            System.out.println("name of item "+(i+1) +" : "+menu.get(i).name);
            System.out.println("description of item "+(i+1) +" : "+menu.get(i).description);
            System.out.println("price of item "+(i+1) +" : "+menu.get(i).price);
            System.out.println("categories of item "+(i+1) +" : "+menu.get(i).categories);
            System.out.println("rating of item "+(i+1) +" : "+menu.get(i).rating);
        }
    }
    public void searchAboutDishWithName(String name){
        for (int i=0;i<menu.size();i++){
            if (name.equals(menu.get(i).name)){
                System.out.println("dish is available");
            }
            else{
                System.out.println("dish is not available");
            }
        }
    }
    public void searchAboutDishWithDescription(String description){
        for (int i=0;i<menu.size();i++){
            if (description.equals(menu.get(i).description)){
                System.out.println("dish is available");
            }
            else{
                System.out.println("dish is not available");
            }
        }
    }
    public void searchAboutDishWithCategories(String categories){
        for (int i=0;i<menu.size();i++){
            if (categories.equals(menu.get(i).categories)){
                System.out.println("dish is available");
            }
            else{
                System.out.println("dish is not available");
            }
        }
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
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("Data/restaurantdata.csv");
            fileWriter.write("name,address,contact info,rating,name dish1,descripiton1,price1,categories1,rating1,name dish2,descripiton2,price2,categries2,rating2\n");

               for (Restaurant restaurant :restaurantList) {
                   fileWriter.append(restaurant.toString());
               }

            fileWriter.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    public String toString() {
        return this.name + ',' + this.address + ',' + this.contactInformation + ',' + this.rating + ',' + this.menu +'\n';
    }
}
