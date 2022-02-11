package assignment1;

import java.util.Scanner;

class quadraticEqu{
    //declare and initialize private variable from constructor
    private double a,b,c;
    quadraticEqu(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    // prints all root if it is available
    public void printRealRoots(){

        double delta=(Math.pow(b,2)-(4*a*c));
        if(delta<0){
            System.out.println("No real root found");
            return ;
        }

        double ans1 = ( -b+ Math.sqrt(delta))/(2*a);
        double ans2 = ( -b- Math.sqrt(delta))/(2*a);
        System.out.println("root 1 "+ ans1);
        System.out.println("root 2 "+ ans2);
    }
}

public class Q5 {
    public static void main(String[] args) {
        quadraticEqu quadraticEqu;
        Scanner sc = new Scanner(System.in);
        int n;
        // loop to continue to check multiple years.
        do {
            System.out.println("[ 1 ] find roots of equation");
            System.out.println("[ 2 ] exit");
            System.out.print("[   ] enter your choice");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    double a,b,c;
                    // creating and checking year is leap year or not
                    System.out.print("Enter value of a");a=sc.nextDouble();
                    System.out.print("Enter value of b");b=sc.nextDouble();
                    System.out.print("Enter value of c");c=sc.nextDouble();
                    quadraticEqu=new quadraticEqu(a,b,c);
                    quadraticEqu.printRealRoots();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Enter valid option");
            }
        } while (true);
    }
}
