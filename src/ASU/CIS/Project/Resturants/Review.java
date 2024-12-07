package ASU.CIS.Project.Resturants;

/**
 * This class is made to get the feedback of the customer
 */
public class Review {
    double scoreRating;

    Restaurant restaurant;

    int number_of_reviewsR,number_of_reviewsD;

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
     * @param name nameof the dish
     */
    public void setReviewForDish(int rate, String name) {
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
}
