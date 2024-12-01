package ASU.CIS.Project.Person;

public class Customer extends User {
    String deliveryAddress;
    public void displayUserInfo(){
        System.out.println("Name of user is : "+Fname+" "+Lname);
        System.out.println("Email of user is : "+email);
        System.out.println("Password of user is : "+password);
    }
}
