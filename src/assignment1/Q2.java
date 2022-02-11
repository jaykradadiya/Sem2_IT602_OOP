package assignment1;

import java.util.Scanner;

class Calendar {
    // crating a private variable
    private int year;

    // initialize from constructor to private variable
    Calendar(int year) {
        this.year = year;
    }

    // function to check year is leap year or not
    public boolean isLeapYear() {
        if (year % 4 == 0 && year % 100 != 0) {
            // return true for year id leap year
            return true;
        } else if (year % 100 == 0 && year % 400 == 0) {
            // return true for year id leap year
            return true;
        }
        //return false for year is not leap year
        return false;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        // loop to continue to check multiple years.
        do {
            System.out.println("[ 1 ] check year is leap year or not");
            System.out.println("[ 2 ] exit");
            System.out.print("[   ] enter your choice");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    // creating and checking year is leap year or not
                    System.out.print("Enter any year");
                    n = sc.nextInt();
                    if ((new Calendar(n).isLeapYear()))
                        System.out.println("The year " + n + " is leap year ");
                    else
                        System.out.println("the year " + n + " is not leap year");
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Enter valid option");
            }
        } while (true);

    }
}
