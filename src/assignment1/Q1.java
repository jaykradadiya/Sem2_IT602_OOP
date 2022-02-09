package assignment1;

class vehicles{
    private int noOfSeats,noOfWheels;

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }
}

public class Q1 {
    public static void main(String[] args) {

        vehicles Motercycle = new vehicles();
        vehicles Car = new vehicles();

        Motercycle.setNoOfSeats(2);
        Motercycle.setNoOfWheels(2);

        Car.setNoOfSeats(5);
        Car.setNoOfWheels(4);

        System.out.println("MoterCycle has "+Motercycle.getNoOfWheels()+" wheels and "+Motercycle.getNoOfSeats()+" seats");
        System.out.println("Car has "+Car.getNoOfWheels()+" wheels and "+Car.getNoOfSeats()+" seats");


    }
}
