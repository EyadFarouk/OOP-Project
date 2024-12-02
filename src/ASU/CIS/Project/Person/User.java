package ASU.CIS.Project.Person;

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
    abstract public void signup();
}
