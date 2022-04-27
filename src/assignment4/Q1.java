package assignment4;

/**
 *
 *   interface create to declare method for who implement this interface.
 */
interface trankCall{
    int getCharge(int minits);
}

/**
 *
 * implemented trankCall
 * declared methods as per requirement and return output.
 *
 */
class OrdinaryCall implements trankCall{
    @Override
    public int getCharge(int minits) {
        if(minits<10){
            return 10;
        }
        else if(minits>20){
            return 30;
        }
        else {
            return 20;
        }
    }
}

/**
 *  implemented trankCall
 *  declared methods as per requirement and return output.
 */
class UrgentCall implements trankCall{
    @Override
    public int getCharge(int minits) {
        if(minits<10){
            return 20;
        }
        else if(minits>20){
            return 60;
        }
        else{
            return 40;
        }
    }
}

/**
 *  implemented trankCall
 *  declared methods as per requirement and return output
 */
class LightningCall implements trankCall{
    @Override
    public int getCharge(int minits) {
        if(minits<10){
            return 40;
        }
        else if(minits>20){
            return 150;
        }
        else{
            return 80;
        }
    }
}


/**
 * though polymorphism used trankcall to initialized OrdinaryCall,UrgentCall,LightningCall object.
 * and used call method and print expected result;
 *
 */
public class Q1 {
    public static void main(String[] args) {
        trankCall ordinarycall = new OrdinaryCall();
        System.out.println("ordinarycall 1 " +ordinarycall.getCharge(1));
        System.out.println("ordinarycall 15 " +ordinarycall.getCharge(15));
        System.out.println("ordinarycall 40 " +ordinarycall.getCharge(40));

        trankCall urgentCall =new UrgentCall();
        System.out.println("urgentCall 1 "+urgentCall.getCharge(1));
        System.out.println("urgentCall 15 "+urgentCall.getCharge(40));
        System.out.println("urgentCall 40 "+urgentCall.getCharge(15));

        trankCall lightningCall = new LightningCall();
        System.out.println("lightningCall 1 "+lightningCall.getCharge(1));
        System.out.println("lightningCall 15 "+lightningCall.getCharge(40));
        System.out.println("lightningCall 40 "+lightningCall.getCharge(15));

    }
}
