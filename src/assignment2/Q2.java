package assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Mystery{
    String mystry;
    public String getMystry() {
        return mystry;
    }

    public void setMystry(String mystry) {
        this.mystry = mystry;
    }

    public String SolveMystery(){
        //creatin hashmap which has key char and value as int
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        // for all char in mystry set or update its value and value determine frequency of that char
        for (char i :
                mystry.toCharArray()) {
            if(map.containsKey(i)==true)
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }

        boolean ignored1char=false;
        boolean solved=false;
        char ignored = ' ';
        int constFeq=map.get(mystry.charAt(0));

        // iterate all key of hashmap and check for same frequency and also ignore 1 char
        for (Map.Entry<Character,Integer> m:
             map.entrySet()) {
            if (constFeq == m.getValue()) {
                continue;
            } else if ((constFeq ==  (m.getValue() - 1)) && !ignored1char) {
                ignored=m.getKey();
                ignored1char=!ignored1char;
            }
            else if ((m.getValue() < constFeq) &&(m.getValue() == 1)&& !ignored1char){
                ignored=m.getKey();
                ignored1char=!ignored1char;
            }
            else {
                return "NO";
            }
        }

        if(ignored1char){
            return "YES "+ignored;
        }
        else
            return "YES";
    }
}
public class Q2 {
    public static void main(String[] args) {
        Mystery mystery = new Mystery();
        Scanner sc = new Scanner(System.in);
        String mstry;
        int n;
        // loop to continue to check multiple years.
        do {
            System.out.println("[ 1 ] solve mystery");
            System.out.println("[ 2 ] exit");
            System.out.print("[   ] enter your choice");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.print("Enter Mystery");
                    sc.nextLine();
                    mstry = sc.nextLine();
                    mystery.setMystry(mstry);
                    System.out.println(mystery.SolveMystery());
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Enter valid option");
            }
        } while (true);

    }
}
