package ASU.CIS.Project.Person;
import java.util.Scanner;

abstract public class User {
    String Fname;
    String Lname;
    String email;
    String phone;
    int age;
    String gender;
    String address;
    String password;
    abstract public User login();
    public void signup(){
        System.out.println("Welcome in sign up page");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your first name : ");
        this.Fname=scanner.next();
        System.out.println("Please enter your last name : ");
        this.Lname=scanner.next();
        System.out.println("Please enter your email : ");
        this.email=scanner.next();
        System.out.println("Please enter your phone number : ");
        this.phone=scanner.next();
        System.out.println("Please enter your age : ");
        this.age=scanner.nextInt();
        System.out.println("Please enter your gender : ");
        this.gender=scanner.next();
        System.out.println("Please enter your address : ");
        this.address=scanner.next();
        System.out.println("Please enter your password : ");
        this.password=scanner.next();
    }
    public void displayUserInfo(){
        System.out.println("Name of user is : "+this.Fname+" "+this.Lname);
        System.out.println("Email of user is : "+this.email);
        System.out.println("phone of user is : "+this.phone);
        System.out.println("age of user is : "+this.age);
        System.out.println("gender of user is : "+this.gender);
        System.out.println("address of user is : "+this.address);
        System.out.println("Password of user is : "+this.password);
    }
    abstract public void saveData();
}
