package person;

public class User extends Person {
    String deliveryAddress;
    public void displayUserInfo(){
        System.out.println("Name of user is : "+name);
        System.out.println("Email of user is : "+email);
        System.out.println("Password of user is : "+password);
    }
}
