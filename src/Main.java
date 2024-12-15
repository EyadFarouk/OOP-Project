import ASU.CIS.Project.Person.Delivery_Staff;
import ASU.CIS.Project.UI.*;

public class Main {
    public static void main(String[] args) {
        Ui ui=new Ui();
        ui.loadData();
        ui.runProject();
        ui.saveData();
    }
}