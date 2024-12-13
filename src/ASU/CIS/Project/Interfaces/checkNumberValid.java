package ASU.CIS.Project.Interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface checkNumberValid {
    default int checkNumber(int CheckIfIntOrDouble, String s){
        Scanner scanner=new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print(s);
            }
            scanner.nextLine(); // clears the buffer
        }
    }

    default double checkNumber(double CheckIfIntOrDouble, String s){
        Scanner scanner=new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print(s);
            }
            scanner.nextLine(); // clears the buffer
        }
    }
}
