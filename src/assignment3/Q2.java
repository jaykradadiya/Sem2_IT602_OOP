package assignment3;

import java.util.Locale;
import java.util.Scanner;

/**
 * this class is abstract because vehicle is generalized name.
 * and we have to generate calculate journey price of specialized class only.
 *
 */
abstract class Vehicale{
    int singleJourny=0;
    int returnJourny=0;

    /**
     * setting prices of journey. of the respected vehicles.
     * @param singleJourny
     * @param returnJourny
     */
    public Vehicale(int singleJourny, int returnJourny) {
        this.singleJourny = singleJourny;
        this.returnJourny = returnJourny;
    }

    /**
     * it will return price of singleJourney.
     * @return singleJourny
     */
    public int getSingleJourny() {
        return singleJourny;
    }

    /**
     *  set the price of singleJourney for update of price;
     * @param singleJourny
     */
    public void setSingleJourny(int singleJourny) {
        this.singleJourny = singleJourny;
    }
    /**
     * it will return price of returnJourny.
     * @return singleJourny
     */
    public int getReturnJourny() {
        return returnJourny;
    }

    /**
     *  set the price of returnJourny for update of price;
     * @param returnJourny
     */
    public void setReturnJourny(int returnJourny) {
        this.returnJourny = returnJourny;
    }

    /**
     * this method will check is joury is single or not
     * for single journey it will return amount of single journey
     * otherwise return journey amount.
     * @param journy
     */
    public void getTotalAmount(String journy){
        if(journy.compareTo("single")==0){
            System.out.println("Amount to be paid: Rs "+singleJourny);
        }
        else {
            System.out.println("Amount to be paid: Rs "+returnJourny);
        }
    }
}

/**
 *
 * there are multiple subclass of vehicles
 * 1 wheeler2 ( use for 2wheeler vehicles)
 * 2 Car
 * 3 Jeep
 * 4 Van
 * 5 Bus
 * 6 Truck
 *
 * all subclass define statically price of single or double journy in parent class.
 */

class Wheeler2 extends Vehicale{
    Wheeler2(){
        super(10,15);
    }

    public Wheeler2(int singleJourny, int returnJourny) {
        super(singleJourny, returnJourny);
    }
}
class Car extends Vehicale{
    Car(){
        super(105,155);
    }

    public Car(int singleJourny, int returnJourny) {
        super(singleJourny, returnJourny);
    }
}
class Jeep extends Vehicale{
    Jeep(){
        super(105,155);
    }

    public Jeep(int singleJourny, int returnJourny) {
        super(singleJourny, returnJourny);
    }
}
class Van extends Vehicale{
    Van(){
        super(105,155);
    }

    public Van(int singleJourny, int returnJourny) {
        super(singleJourny, returnJourny);
    }
}
class Bus extends Vehicale{
    Bus(){
        super(350,525);
    }

    public Bus(int singleJourny, int returnJourny) {
        super(singleJourny, returnJourny);
    }
}
class Truck extends Vehicale{
    Truck(){
        super(350,525);
    }

    public Truck(int singleJourny, int returnJourny) {
        super(singleJourny, returnJourny);
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicale vehicale=null;
        /**
         * used a exit as commad to exit form program.
         * should be entered as vehicle name;
         */
        System.out.println("to exit enter Exit as vehicle name");

        do{
            /**
             * takign name of vehicle and type of journey.
             */
            System.out.print("Type of vehicle passing through the toll plaza: ");
            String typeOfVehicle = sc.nextLine();
            System.out.print("Journey type( Single | Return ): ");
            String typeOfJourny = sc.nextLine();

            /**
             * assign respective class.
             */
            switch (typeOfVehicle.toLowerCase()){
                case "2-wheeler":
                    vehicale= new Wheeler2();
                    break;
                case "car":
                    vehicale = new Car();
                    break;
                case "jeep":
                    vehicale = new Jeep();
                    break;
                case "van":
                    vehicale = new Van();
                    break;
                case "bus":
                    vehicale = new Bus();
                    break;
                case "truck":
                    vehicale = new Truck();
                    break;
                case "exit":
                    return;
                default:
                    continue;
            }

            /**
             * after assigning respective class it will return totalAmount as its typeofJourney.
             */
            switch (typeOfJourny.toLowerCase()){
                case "single":
                    vehicale.getTotalAmount("single");
                    break;
                case "return":
                    vehicale.getTotalAmount("return");
                    break;
            }
        }while (true);

    }
}
