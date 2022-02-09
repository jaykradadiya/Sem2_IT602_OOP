package assignment1;

class Calander{
    private int year;
    Calander(int year){
        this.year= year;
    }
    public boolean isLeapYear(){
        if((year%4==0 && year%100!=0 )|| (year%100==0 && year%400==0)){
            return true;
        }
        return false;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Calander c1 = new Calander(2008);
        Calander c2 = new Calander(1900);
        Calander c3 = new Calander(2000);

        System.out.println(c1.isLeapYear());
        System.out.println(c2.isLeapYear());
        System.out.println(c3.isLeapYear());
    }
}
