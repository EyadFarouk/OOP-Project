package resturants;

import person.User;

public class Review {
    User user;
    double scoreRating;
    public void setReviewForRestaurant(double scoreRating,Restaurant restaurant){
        this.scoreRating=scoreRating/ restaurant.numberOfRating+1;
        restaurant.rating=this.scoreRating;
    }
    public void serReviewForDish(double scoreRating,String name){

    }
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
