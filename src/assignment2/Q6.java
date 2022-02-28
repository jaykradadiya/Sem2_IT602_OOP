package assignment2;


class magic{
    String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int findOccurance(int lth, int rth, char c){
        int count=0;
        int length=str.length();
        int loopinmaic = (rth-lth)/length;
        int i;
        if(loopinmaic>0){
            for (i = 0; i < length; i++) {
                if(str.charAt(i)==c){
                    count++;
                }
            }
            count=count*loopinmaic;
        }

        lth = (--lth%length);
        rth = (--rth%length);

        if(lth>rth) {
            for (int j = lth; j < length; j++) {
                if (str.charAt(j) == c) {
                    count++;
                }
            }
            for (int j = rth; j < lth; j++) {
                if (str.charAt(j) == c) {
                    count++;
                }
            }
        }
        else{
            for (int j = lth; j <= rth; j++) {
                if (str.charAt(j) == c) {
                    count++;
                }
            }
        }
        return count;
    }
}
public class Q6 {
    public static void main(String[] args) {
        magic magic= new magic();
        magic.setStr("abcabdca");
        System.out.println("magic abcabdca");
        System.out.println("lth = 1 rth = 8 ch = c " +magic.findOccurance(1,8,'c'));
        System.out.println("lth = 1 rth = 15 ch = b " +magic.findOccurance(1,15,'b'));
        System.out.println("lth = 4 rth = 9 ch = a " +magic.findOccurance(4,9,'a'));
        System.out.println("lth = 5 rth = 25 ch = d " +magic.findOccurance(5,25,'d'));
        System.out.println("lth = 2 rth = 7 ch = c " +magic.findOccurance(1,7,'c'));
        System.out.println("lth = 3 rth = 8 ch = c " +magic.findOccurance(3,8,'c'));
    }
}
