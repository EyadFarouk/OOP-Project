package ASU.CIS.Project.Person;
import java.util.InputMismatchException;
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
        System.out.print("Please enter your first name : ");
        this.Fname= checkNoNumbers(scanner.next());
        System.out.print("Please enter your last name : ");
        this.Lname=checkNoNumbers(scanner.next());
        System.out.print("Please enter your email : ");
        this.email=scanner.next();
        System.out.print("Please enter your phone number : ");
        this.phone=scanner.next();
        System.out.print("Please enter your age : ");
        while (true) {
            try {
                this.age = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid age: ");
            }
            scanner.nextLine(); // clears the buffer
        }
        System.out.print("Please enter your gender : ");
        this.gender=checkGender(scanner.next());
        System.out.print("Please enter your address : ");
        this.address=scanner.next();
        System.out.print("Please enter your password : ");
        this.password=checkPasswordValid(scanner.next());
    }

    private String checkPasswordValid(String password){
        while (true) {
            if (password.matches("^(?=.*[0-9])"       //Checks if the password has a number
                    + "(?=.*[a-z])"                         //Checks if the password has a small letter
                    + "(?=.*[A-Z])"                         //Checks if the password has a capital letter
                    + "(?=.*[@#$%^&+=])"                    //Checks if the password has a special character
                    + "(?=\\S+$).{8,20}$"))                //Checks if the password has at least 8 characters and has no white spaces
            {
                return password;
            }else{
                if (password.length() < 8) {
                    System.err.println("Password must be at least 8 characters");
                }
                if (!password.matches(".*\\d.*")) {
                    System.err.println("Password must have at least one number");
                }
                if (!password.matches(".*[a-z].*")) {
                    System.err.println("Password must have at least one lower case letter");
                }
                if (!password.matches(".*[A-Z].*")) {
                    System.err.println("Password must have at least one upper case letter");
                }
                if (!password.matches("^.*[@#$%^&-+=()].*")) {
                    System.err.println("Password must have at least one special character");
                }
                if (password.contains(" ")) {
                    System.err.println("Password mustn't have spaces");
                }
                System.out.print("Enter a valid password: ");
                Scanner scanner=new Scanner(System.in);
                password = scanner.nextLine();
            }
        }
    }

    private String checkGender(String gender){
        while (true) {
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")) {
                return "Male";
            } else if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
                return "Female";
            } else
                System.out.println("Please enter a valid gender: ");
            Scanner scanner=new Scanner(System.in);
            gender = scanner.nextLine();
        }
    }

    private String checkNoNumbers(String name){
        while(true){
            Scanner scanner=new Scanner(System.in);
            if(name.matches(".*\\d.*"))
            {
                System.out.print("The name can't contain numbers: ");
                name = scanner.next();
            }else
                return name;
        }
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
}
