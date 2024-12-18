import ASU.CIS.Project.Person.Delivery_Staff;
import ASU.CIS.Project.Resturants.RestaurantLocation;
import ASU.CIS.Project.UI.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Ui ui=new Ui();
        ui.loadData();
        ui.runProject();
        ui.saveData();
    }
}