package ASU.CIS.Project.Person;

abstract public class User {
    String Fname;
    String Lname;
    String email;
    int Phone;
    int age;
    String gender;
    String address;
    String password;
    abstract public void login();
    abstract public void signup();
}
