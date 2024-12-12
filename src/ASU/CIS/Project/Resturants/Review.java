package ASU.CIS.Project.Resturants;

import ASU.CIS.Project.Person.Delivery_Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is made to get the feedback of the customer
 */
public class Review {
    double scoreRating;

    public Restaurant restaurant;

    public List<String> notes = new ArrayList<>();
    public String nameOfDelivery;


    public  int number_of_reviewsR=0,number_of_reviewsD=0,number_of_reviewsDS=0;
    public Review(){
        restaurant=new Restaurant();
    }
    /**
     * this is it's constructor, and it takes a restaurant object
     *
     * @param restaurant restaurant object
     */
    public Review(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    /**
     * This method sets the restaurant's rating and calculate the average rating
     *
     * @param Rating the rating the user gives
     */
    public void setReviewForRestaurant(double Rating) {
        number_of_reviewsR++;

        this.scoreRating = Rating;

        restaurant.rating = (restaurant.rating + Rating) / number_of_reviewsR;
    }

    /**
     * This method is used to set the review of the dish and calculate the average rating
     *
     * @param rate the rate the user returns
     * @param name name of the dish
     */
    public void setReviewForDish(double rate, String name) {
        number_of_reviewsD++;

      int i = 0;

        while(true) {
            i++;
            if (name.equals(restaurant.menu.get(i).name)) {
                this.scoreRating = rate;

                break;
            }

            restaurant.menu.get(i).rating = (restaurant.menu.get(i).rating + rate)/number_of_reviewsD;
        }
    }

    /**
     * This method is used to set the review of the delivery staff member and calculate the average rating
     * @param deliveryStaff the deliveryman's first name
     * @param rating the rating you want to give him
     */
    public void setReviewForDeliveryStaff(Delivery_Staff deliveryStaff ,double rating)
    {
        number_of_reviewsDS++;
        nameOfDelivery=deliveryStaff.Fname;
        this.scoreRating = rating;
        deliveryStaff.setRating ((deliveryStaff.getRating()+rating)/number_of_reviewsDS) ;
    }
    public void saveData(List<Review>reviews){
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("Data/reviews.txt"));
             for (Review review : reviews){
                 bufferedWriter.write(review.restaurant.name+'\n');
                 bufferedWriter.write(String.valueOf(review.scoreRating)+'\n');
                 bufferedWriter.write(String.valueOf(review.number_of_reviewsR)+'\n');
             }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Review>loadDataReviewRestaurant(){
        List<Review>reviews=new ArrayList<>();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader("Data/reviews.txt"));
            String line;

            Review review=new Review();
            while ((line=bufferedReader.readLine())!=null){
                review.restaurant.name=line;
                line=bufferedReader.readLine();
                review.scoreRating=Double.parseDouble(line);
                line=bufferedReader.readLine();
                review.number_of_reviewsR=Integer.parseInt(line);
                reviews.add(review);
                review=new Review();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }
    public void saveDataReviewDelivery(List<Review>reviews){
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("Data/reviewsDelivery.txt"));
            for (Review review : reviews){
                bufferedWriter.write(review.nameOfDelivery+'\n');
                bufferedWriter.write(String.valueOf(review.scoreRating)+'\n');
                bufferedWriter.write(String.valueOf(review.number_of_reviewsDS)+'\n');
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Review>loadDataReviewDelivery(){
        List<Review>reviews=new ArrayList<>();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader("Data/reviewsDelivery.txt"));
            String line;
            Review review=new Review();
            while ((line=bufferedReader.readLine())!=null){
                review.nameOfDelivery=line;
                line=bufferedReader.readLine();
                review.scoreRating=Double.parseDouble(line);
                line=bufferedReader.readLine();
                review.number_of_reviewsDS=Integer.parseInt(line);
                reviews.add(review);
                review=new Review();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }
}
