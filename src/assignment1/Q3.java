package assignment1;

class calculator{
    private int aint ,bint;
    private float aFloat, bFloat;

    calculator(int a,int b){
        this.aint=a;
        this.bint=b;
    }

    calculator(float a,float b){
        this.aFloat=a;
        this.bFloat=b;
    }

    int addition(int a,int b){
        return a+b;
    }
    float addition(float a,float b){
        return a+b;
    }

    int substraction(int a,int b){
        return a-b;
    }

    float substraction(float a,float b){
        return a-b;
    }

    int multiplication(int a,int b){
        return  a*b;
    }

    float multiplication(float a, float b){
        return a*b;
    }
}

public class Q3 {
    public static void main(String[] args) {

    }
}
