package SoftwareEngineering;

import java.util.Scanner;

public class Triangle {
    final int EQUILATERAL =0;
    final int ISOSCELES = 1;
    final int SCALENE =2 ;
    final int INVALID =3;

    int triangle(int a ,int b, int c){

        if(a>=b+c || b>= a+c || c>= a+b){
            return  (INVALID);
        }
        if(a==b && b==c){
            return EQUILATERAL;
        }
        if(a==b || a==c || b==c){
            return ISOSCELES;
        }
        return SCALENE;
    }

}
