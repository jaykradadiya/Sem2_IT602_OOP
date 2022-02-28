package assignment2;


import java.util.Scanner;

class royelCircus{

    public int findRodeWithallColoredRing(String rings){
        // here rodes are 10 and number 0 to 9
        int rodes[]= new int[10];
        int totalRodeswithallcoloredRing=0;
        /**
         * 1 for red ring
         * 2 for green ring
         * 5 for blue ring
         * and if 1 | 2 | 5 = 7 for all ring in that rode
         */
        for (int i = 0; i < rings.length(); i+=2) {
            switch (rings.charAt(i)){
                case 'R':
                    rodes[rings.charAt(i+1)- '1']|=1;
                    break;
                case 'G':
                    rodes[rings.charAt(i+1)- '1']|=2;
                    break;
                case 'B':
                    rodes[rings.charAt(i+1)- '1']|=5;
                    break;
            }
        }
        //here counting all rode having 7 value
        for (int j = 0; j < 10; j++) {
            if(rodes[j]==7){
                totalRodeswithallcoloredRing++;
            }
        }
        return totalRodeswithallcoloredRing;
    }
}

public class Q4 {
    public static void main(String[] args) {
        royelCircus rs = new royelCircus();
        Scanner sc = new Scanner(System.in);
        String roadString;
        int n;
        // loop to continue to check multiple years.
        do {
            System.out.println("[ 1 ] solve mystery");
            System.out.println("[ 2 ] exit");
            System.out.print("[   ] enter your choice");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.print("Enter string");
                    sc.nextLine();
                    roadString = sc.nextLine();
                    System.out.println("No of rods having all 3 colord rings are : "+
                                    rs.findRodeWithallColoredRing(roadString));
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Enter valid option");
            }
        } while (true);
    }
}
