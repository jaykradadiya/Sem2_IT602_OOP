package assignment2;

import java.util.Scanner;

class Message{
    protected String message;
    String defaultmsg;
    //seting default message
    Message(){
        defaultmsg="MAYDAY";
    }
    Message(String message){
        defaultmsg=message;
    }
    public String getMessage() {
        return message;
    }

    //set message is length of string is in multiple of default string
    public void setMessage(String message) {
        if(message.length()%defaultmsg.length()==0)
            this.message = message;
        else
            System.out.println(message+" is not valid");
    }

    public int getDamegedCharecter(){
        if(message.length()==0){
            return 0;
        }
        int defaultmsgindex=0;
        int count=0;
        //iterate over message and compare with same message
        for (int i = 0; i < message.length(); i++,defaultmsgindex++) {
            if(defaultmsgindex==(defaultmsg.length())){
                defaultmsgindex=defaultmsgindex%defaultmsg.length();
            }
            if(message.charAt(i)!= defaultmsg.charAt(defaultmsgindex)){
                count++;
            }
        }
//        System.out.println(count);
        return count;
    }
}

public class Q1 {
    public static void main(String[] args) {
//        String sos = "MAYDXYMAYDAY";
       Message message= new Message();
        Scanner sc = new Scanner(System.in);
        int n;
        String msg;
        // loop to continue to check messages
        do {
            System.out.println("[ 1 ] damaged Characters");
            System.out.println("[ 2 ] exit");
            System.out.print("[   ] enter your choice");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.print("Enter message (ie MAYDAY)");
                    sc.nextLine();
                    msg = sc.nextLine();
                    message.setMessage(msg);
                    System.out.println("damaged characters are "+ message.getDamegedCharecter()+ " in message :: " + message.getMessage());
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Enter valid option");
            }
        } while (true);

    }
}
