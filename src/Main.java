import ASU.CIS.Project.UI.*;
import ASU.CIS.Project.Person.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        Admin admin = new Admin();
        // A function to give fake data to test on
            Customer.instance();
            Admin.instance();
            customer.saveData();
            admin.saveData();
        //------------------------------
        Ui ui=new Ui();

        int choose= ui.firstPage();

        if (choose==1){

            choose=ui.loginOrSignup();

            if(choose==1){
               customer= customer.login();
               customer.displayUserInfo();
            }

            else if (choose==2){
                customer.signup();
                customer= customer.login();
                customer.displayUserInfo();
            }

            ui.homePage();
/*
            Restaurant restaurant= ui.displayRestaurants();*/

            choose=ui.homePageAfterSelectRestaurant();

        }
        else if (choose==2){

            choose= ui.loginOrSignup();

            if (choose==1) {
                admin = admin.login();
                admin.displayUserInfo();
            }else if (choose==2){
                admin.signup();
                admin= admin.login();
                admin.displayUserInfo();
            }

            choose= ui.homePageAdmin();

        }
    }

}