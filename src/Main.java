import ASU.CIS.Project.UI.*;
import ASU.CIS.Project.Person.*;

import java.util.ArrayList;
import java.util.List;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        // A function to give fake data to test on
            customer.instance();
        //------------------------------
        Ui ui=new Ui();

        int choose= ui.firstPage();

        if (choose==1){

            choose=ui.loginOrSignup();
            Customer customer1;

            if(choose==1){
               customer1= customer.login();
               customer1.displayUserInfo();
            }

            else if (choose==2){
                customer.signup();
                customer1= customer.login();
                customer1.displayUserInfo();
                customer.displayUserInfo();
            }

            ui.homePage();
/*
            Restaurant restaurant= ui.displayRestaurants();*/

            choose=ui.homePageAfterSelectRestaurant();

        }

        else if (choose==2){
            Admin admin=new Admin();

            choose= ui.loginOrSignup();

            if (choose==1){

                admin.login();

            }
            else if (choose==2){

                admin.signup();

            }

            choose= ui.homePageAdmin();

        }
    }

}