package ASU.CIS.Project.Resturants;

import ASU.CIS.Project.Person.Delivery_Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is made to get the feedback of the customer
 */
public class Review {
    double scoreRating;

    Restaurant restaurant;

    public List<String> notes = new ArrayList<>();

    int number_of_reviewsR,number_of_reviewsD,number_of_reviewsDS;

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
     * @param name the deliveryman's first name
     * @param location his current location
     * @param rating the rating you want to give him
     */
    public void setReviewForDeliveryStaff(String name , String location ,double rating)
    {
        number_of_reviewsDS++;

        Delivery_Staff delivery = new Delivery_Staff(location);

        if(name.equals(delivery.Fname))
        {
            this.scoreRating = rating;

            delivery.setRating ((delivery.getRating()+rating)/number_of_reviewsDS) ;
        }
    }
}
