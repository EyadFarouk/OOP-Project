package ASU.CIS.Project.Person;

import ASU.CIS.Project.Interfaces.saveAndLoad;

/**
 * This is the class Delivery Staff that displays the delivery man. It contains attributes:
 * 1- First Name
 * 2- last Name
 * 3- Location
 * 4- Rating
 */


public class Delivery_Staff extends User implements saveAndLoad {

    private double rating;               //kept private to be set by admin only
    String Location;

    /**
     * Constructor to instantiate delivery man
     * @param location shows the current location of the delivery man
     */

    public Delivery_Staff(String location) {
        this.Location = location;
    }

    /**
     * getter for rating
     * @return returns delivery man's rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * setter for rating
     * @param rating sets the rating of the delivery man (to be set by admin/customer)
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public void saveData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public User login() {
        return null;
    }


}
