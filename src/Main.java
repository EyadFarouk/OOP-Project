import person.Admin;
import person.User;
import resturants.Restaurant;
import ui.Ui;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Ui ui=new Ui();
        int choose= ui.firstPage();
        if (choose==1){
            User user=new User();
            choose=ui.loginOrSignup();
            if(choose==1){
                user.login();
            }
            else if (choose==2){
                user.signup();
            }
            ui.homePage();
            Restaurant restaurant= ui.displayRestaurants();
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