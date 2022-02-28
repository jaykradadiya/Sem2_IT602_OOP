package assignment2;


import java.util.Scanner;

class BullsAndCows{
    private String secret,guess;
    //static secrat at first time
    BullsAndCows(){
        secret="1807";
    }

    //manully set secreat while creating class;
    BullsAndCows(String s){
        this.secret=s;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String generateHint(){
        //lenth of both string is not equal
        if(secret.length()!=guess.length()){
            System.out.println("length of secret and guess are not same ");
            return "";
        }
        int Bulls=0,Cows=0;
        // create new arr for store occurance of that int here (0-9)are num accepting
        int secretArr[] = new int[10];
        int guessArr[] = new int[10];
        //here if both index int are same means it bull otherwise increase frequency of index on their arr
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                Bulls++;
            } else {
                secretArr[secret.charAt(i) - '0']++;
                guessArr[guess.charAt(i) - '0']++;
            }
        }

        // here we are counting cows as per frquency so we can rearrange that number and they can become bull.
        for (int i = 0; i < 10; i++) {
            if (secretArr[i] <= guessArr[i]) {
                Cows += secretArr[i];
            } else {
                Cows += guessArr[i];
            }
        }
        return Bulls+"A"+Cows+"B";
    }
}
public class Q3 {
    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        Scanner sc = new Scanner(System.in);
        String str;
        int n;
        // loop to continue to check multiple years.
        do {
            System.out.println("[ 1 ] generate hint");
            System.out.println("[ 2 ] set secret");
            System.out.println("[ 3 ] exit");
            System.out.print("[   ] enter your choice");
            n = sc.nextInt();
            switch (n) {
                case 1:

                    System.out.print("Enter guess");
                    sc.nextLine();
                    str = sc.nextLine();
                    bullsAndCows.setGuess(str);
                    System.out.println(bullsAndCows.generateHint());
                    break;
                case 2:
                    System.out.print("Enter secret");
                    sc.nextLine();
                    str = sc.nextLine();
                    bullsAndCows.setSecret(str);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Enter valid option");
            }
        } while (true);
    }
}
