package assignment1;

import java.util.Scanner;

class calculator {
    // private variables
    private int aint, bint;
    private float aFloat, bFloat;

    // initialize data from constructor and example of constructor overloading
    calculator(int a, int b) {
        this.aint = a;
        this.bint = b;
    }

    calculator(float a, float b) {
        this.aFloat = a;
        this.bFloat = b;
    }

    // function with method overloading and return data as according
    int addition(int a, int b) {
        return a + b;
    }

    float addition(float a, float b) {
        return a + b;
    }

    int substraction(int a, int b) {
        return a - b;
    }

    float substraction(float a, float b) {
        return a - b;
    }

    int multiplication(int a, int b) {
        return a * b;
    }

    float multiplication(float a, float b) {
        return a * b;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int intVal1, intVal2;
        float floatVal1, floatVal2;
        calculator cal;
        do {
            System.out.println("[ 1 ] int type operation");
            System.out.println("[ 2 ] float type operation");
            System.out.println("[ 3 ] exit");
            System.out.println("[   ] enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter 1st int val");
                    intVal1 = sc.nextInt();
                    System.out.print("Enter 2st int val");
                    intVal2 = sc.nextInt();
                    cal = new calculator(intVal1, intVal2);
                    System.out.println("a + b = " + cal.addition(intVal1, intVal2));
                    System.out.println("a - b = " + cal.substraction(intVal1, intVal2));
                    System.out.println("a * b = " + cal.multiplication(intVal1, intVal2));
                    break;
                case 2:
                    System.out.print("Enter 1st float val");
                    floatVal1 = sc.nextFloat();
                    System.out.print("Enter 1st float val");
                    floatVal2 = sc.nextFloat();
                    cal = new calculator(floatVal1, floatVal2);
                    System.out.println("a + b = " + cal.addition(floatVal1, floatVal2));
                    System.out.println("a - b = " + cal.substraction(floatVal1, floatVal2));
                    System.out.println("a * b = " + cal.multiplication(floatVal1, floatVal2));
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Enter valid option");
                    break;
            }

        } while (true);
    }
}
