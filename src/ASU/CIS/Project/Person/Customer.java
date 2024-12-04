package ASU.CIS.Project.Person;

import ASU.CIS.Project.Interfaces.saveAndLoad;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Customer extends User implements saveAndLoad{
    String deliveryAddress;
    static List<Customer> userList=new ArrayList<>();
    public void displayUserInfo(){
        super.displayUserInfo();
        System.out.println("delivery address of user is : "+this.deliveryAddress);
    }

    public static void instance(){
        Customer Eyad=new Customer();
        Eyad.email="Eyad";
        Eyad.password="Eyad";
        userList.add(Eyad);
        for (int i = 0; i < 10; i++) {
            Customer customer=new Customer();
            customer.Fname="Fname"+i;
            customer.Lname="Lname"+i;
            customer.email="email"+i+"@email.com";
            customer.phone="phone"+i;
            customer.age=1;
            customer.gender="male";
            customer.address="address"+i;
            customer.password="password"+i;
            customer.deliveryAddress="address"+i;
            userList.add(customer);
            customer.displayUserInfo();
            userList.get(i).displayUserInfo();
        }
    }

    @Override
    public Customer login() {
        System.out.println("Welcome in Log in page");
        do {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Please enter your email : ");
            this.email=scanner.next();
            System.out.println("Please enter your password : ");
            this.password=scanner.next();
            for (int i = 0; i < userList.size(); i++) {
                if (this.email.equals(userList.get(i).email)) {
                    if (this.password.equals(userList.get(i).password)) {
                        System.out.println("log in success");
                        return userList.get(i);
                    } else if (i == userList.size() - 1) {
                        System.out.println("the email or password is not correct");
                    }
                } else if (i == userList.size() - 1) {
                    System.out.println("The email could not be found");
                }
            }
        }while (true);
    }

    @Override
    public void signup() {
        super.signup();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please enter your Delivery Address : ");
        this.deliveryAddress=scanner.next();
        checkEmailUnique();
        System.out.println("Sign up successful");
        userList.add(this);
    }

    private void checkEmailUnique(){
        while (true) {
            Scanner scanner=new Scanner(System.in);
            boolean exists=false;
            for (Customer customer : userList) {
                if (this.email.equals(customer.email)) {
                    System.out.print("I'm sorry email must be unique. Please enter another Email: ");
                    exists=true;
                }
            }
            if (!exists) {
                break;
            }
            this.email=scanner.next();
        }
    }

    @Override
    public void saveData() {
        FileWriter fw;
        while(true) {
            try {
                fw = new FileWriter("Data/CustomerData.csv");
                fw.write("FName,LName,Email,Phone,Age,Gender,Address,Password,Delivery Address\n");
                for (Customer customer : userList) {
                    fw.append(customer.toString());
                }
                fw.close();
                break;
            } catch (FileNotFoundException e) {
                File file = new File("Data/");
                if (!file.exists()) {file.mkdir();}
            } catch (IOException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
    @Override
    public void loadData() {
        try {
            FileReader fr = new FileReader("Data/CustomerData.csv");
            BufferedReader br = new BufferedReader(fr);
//            int i=0;
            br.readLine();
            String line;
            while((line = br.readLine()) != null) {
//                System.out.println(line);
                Customer customer= new Customer();
                customer.Fname=(line.split(",")[0]);
                customer.Lname=(line.split(",")[1]);
                customer.email=(line.split(",")[2]);
                customer.phone=(line.split(",")[3]);
                customer.age=(Integer.parseInt(line.split(",")[4]));
                customer.gender=(line.split(",")[5]);
                customer.address=(line.split(",")[6]);
                customer.password=(line.split(",")[7]);
                customer.deliveryAddress=(line.split(",")[8]);
                userList.add(customer);
//                System.out.println(userList.get(i).toString());
//                i++;
            }
            fr.close();
        }catch (FileNotFoundException e) {
            File file = new File("Data/");
            if (!file.exists()) {file.mkdir();}
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public String toString() {
        return this.Fname + ',' + this.Lname + ',' + this.email + ',' + this.phone + ',' + this.age + ',' + this.gender + ',' + this.address + ',' + this.password + ',' + this.deliveryAddress+'\n';
    }
}
