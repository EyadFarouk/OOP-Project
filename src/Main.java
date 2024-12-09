import ASU.CIS.Project.Payment.Card;
import ASU.CIS.Project.UI.*;
import ASU.CIS.Project.Person.*;
import ASU.CIS.Project.Resturants.*;
import ASU.CIS.Project.Orders.*;

import java.util.ArrayList;
import java.util.List;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer();
        Admin admin = new Admin();
        Card card = new Card();
        // A function to give fake data to test on
//            Customer.instance();
//            Admin.instance();
//            Card.instance();
//            customer.saveData();
//            admin.saveData();
//        card.saveData();
        card.loadData();
        customer.loadData();
        admin.loadData();
        //------------------------------
        Ui ui = new Ui();
        int choose = ui.firstPage(), x = 1;
        while (x == 1) {
            if (choose == 1) {

                choose = ui.loginOrSignup();

                if (choose == 1) {
                    customer = customer.login();
                    customer.displayUserInfo();
                } else if (choose == 2) {
                    customer.signup();
                    customer = customer.login();
                    customer.displayUserInfo();
                }

                choose = ui.homePage();

                if (choose == 1) {
                    Restaurant restaurant = ui.displayRestaurants();

                } else
                    ui.loginOrSignup();

                choose = ui.homePageAfterSelectRestaurant();

                if (choose == 1) {
                    ui.selectDish();

                    /*  Order order = new Order();*/
                } else if (choose == 2) {
                    ui.setReview();
                } else if (choose == 3) {
                    ui.display_cart();
                } else if (choose == 4) {
                    // until we know how order works
                } else if (choose == 5) {
                    ui.loginOrSignup();
                }

            } else if (choose == 2) {

                choose = ui.loginOrSignup();

                if (choose == 1) {
                    admin = admin.login();
                    admin.displayUserInfo();
                } else if (choose == 2) {
                    admin.signup();
                    admin = admin.login();
                    admin.displayUserInfo();
                }

                choose = ui.homePageAdmin();

                if(choose == 1)
                {
                    ui.addRestaurantAdmin();
                }
                else if(choose == 2)
                {
                    ui.deleteDish();
                }
                else if(choose == 3)
                {
                    ui.addMenu();
                }
                else if(choose == 4)
                {
                    ui.deleteMenu();
                }
                else if(choose == 5)
                {
                    ui.loginOrSignup();
                }

            }
            customer.saveData();
            admin.saveData();
        }
        x = ui.doYouWantAnotherAction();
    }
}