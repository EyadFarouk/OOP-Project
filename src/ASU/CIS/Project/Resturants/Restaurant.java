package ASU.CIS.Project.Resturants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Restaurant extends Menu implements Comparable<Restaurant> {

    public String name;
    public String address;
    public String contactInformation;
    public double rating;
    public void displayMenu(){
        for (int i=0;i< menu.size();i++){
            System.out.println("name of item "+(i+1) +" : "+menu.get(i).name);
            System.out.println("description of item "+(i+1) +" : "+menu.get(i).description);
            System.out.println("price of item "+(i+1) +" : "+menu.get(i).price);
            System.out.println("categories of item "+(i+1) +" : "+menu.get(i).categories);
            System.out.println("rating of item "+(i+1) +" : "+menu.get(i).rating);
        }
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
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("Data/restaurantdata.csv");
            fileWriter.write("name\n address\n contact info\n rating\n name dish1\n descripiton1\n price1\n categories1\n rating1\n name dish2\n descripiton2\n price2\n categries2\n rating2\n\n");

               for (Restaurant restaurant :restaurantList) {
                   fileWriter.write(restaurant.toString());
               }

            fileWriter.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    public List<Restaurant> loadData(List<Restaurant>restaurantList){

        try {
            BufferedReader reader=new BufferedReader(new FileReader("Data/restaurantdata.csv"));
            String line;
            int i=0;
            this.name=reader.readLine();
            this.address=reader.readLine();
            this.contactInformation=reader.readLine();
            this.rating=Double.parseDouble(reader.readLine());
            int j=0;
            Dish dish=new Dish();
            while((line=reader.readLine())!=null){
                dish.name=line;
                dish.description=reader.readLine();
                dish.price=Double.parseDouble(reader.readLine());
                dish.categories=reader.readLine();
                dish.rating=Double.parseDouble(reader.readLine());
                this.menu.add(j,dish);
                if (line.isEmpty()){
                    restaurantList.add(i,this);
                    j=0;
                    i++;
                    this.name=reader.readLine();
                    this.address=reader.readLine();
                    this.contactInformation=reader.readLine();
                    this.rating=Double.parseDouble(reader.readLine());
                }
                j++;
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
