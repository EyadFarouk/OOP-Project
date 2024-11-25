package ASU.CIS.Project.Resturants;

/**
 * This class is made to get the feedback of the customer
 */
public class Review {
    double scoreRating;

    Restaurant restaurant;

    /**
     * this is it's constructor
     * @param restaurant restaurant object
     */
    public Review (Restaurant restaurant){
        this.restaurant = restaurant;
    }

    /**
     * This method sets the restaurant's rating
     * @param Rating the rating the user gives
     */
    public void setReviewForRestaurant(double Rating) {
            this.scoreRating= Rating;

           restaurant.rating += (Rating*0.125);
    }

    /**
     * This method is used to set the review of the dish
     * @param rate the rate the user returns
     * @param name nameof the dish
     */
   /* public void serReviewForDish(int rate, String name) {
        if (name.equals(dish name))
        {
            this.scoreRating = rate;
        }
        dish rating += (rate*0.125)
    }*/

   /* public void setReview(int dishOrRestaurant,String name,double scoreRating){
        if(dishOrRestaurant==1){
            this.scoreRating=scoreRating;
        }else if (dishOrRestaurant==2){
            Restaurant restaurant=new Restaurant();
            Menu menu=new Menu();
            for (int i=0;i<restaurant.menu.size();i++){
                if (name.equals(restaurant.menu.get(i).name)){
                    menu=restaurant.menu.get(i);
                }
            }
            this.scoreRating=scoreRating;
        }
    }*/

}
