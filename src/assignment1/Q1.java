package assignment1;

//creating a class
class vehicles {
    //creating private variables
    private int noOfSeats, noOfWheels;

    //getter of both variable from we can get value to private variable
    public int getNoOfSeats() {
        return noOfSeats;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    //setter of both variable from we can set value to private variable
    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }
}

public class Q1 {
    public static void main(String[] args) {

        //creating object of class
        vehicles Motorcycle = new vehicles();
        vehicles Car = new vehicles();

        //assign value of variable to objects
        Motorcycle.setNoOfSeats(2);
        Motorcycle.setNoOfWheels(2);

        Car.setNoOfSeats(5);
        Car.setNoOfWheels(4);

        //display and getting value of variable from object
        System.out.println("MotorCycle has " + Motorcycle.getNoOfWheels() + " wheels and " + Motorcycle.getNoOfSeats() + " seats");
        System.out.println("Car has " + Car.getNoOfWheels() + " wheels and " + Car.getNoOfSeats() + " seats");
    }
}
