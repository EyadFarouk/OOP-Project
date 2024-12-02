import ASU.CIS.Project.UI.*;
import ASU.CIS.Project.Person.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        Ui ui=new Ui();

        int choose= ui.firstPage();

        if (choose==1){

            Customer customer =new Customer();

            choose=ui.loginOrSignup();

            if(choose==1){
                customer.login();
            }

            else if (choose==2){
                customer.signup();
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