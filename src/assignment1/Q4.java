package assignment1;


class ToogleRoom {

    // door open is equivalent to bool false
    // door close is equivalent to bool true

    // creating private variable and declaring bool array
    private int capacity;
    private boolean[] Rooms;

    // constructor that provide capacity and initialize bool array
    ToogleRoom(int TotalRoom) {
        capacity = TotalRoom;
        Rooms = new boolean[TotalRoom];
    }

    //toggle room as if it is multiple of that  argument
    private void toogleRoom(int inmultiplication) {
        int times = 0;
        for (int i = inmultiplication; i <= capacity; i = i + inmultiplication) {
            Rooms[i - 1] = !Rooms[i - 1];
            times++;
        }
    }

    public int getTotalOpenRoomsAfterSimulation() {
        //running simulation from 2 to till capacity of that array
        for (int i = 2; i <= capacity; i++) {
            toogleRoom(i);
        }
        int count = 0;
        //count all rooms that are open
        for (int i = 0; i < capacity; i++) {
            if (!Rooms[i]) {
                count++;
                System.out.print(i+1+" ");
            }
        }
        System.out.println();
        return count;
    }

//    public int wihtoutSimpulation() {
//        int count = 0;
//        //this is Mahtematical approach
//        for (int i = 1; i * i <= capacity; i++) {
//            System.out.print(i*i+" ");
//            count++;
//        }
//        System.out.println();
//        return count++;
//    }

}

public class Q4 {
    public static void main(String[] args) {
        ToogleRoom tg = new ToogleRoom(100);
        System.out.println("ans after simulation "+tg.getTotalOpenRoomsAfterSimulation()+" Doors are open");
//        System.out.println("ans from mathematical "+tg.wihtoutSimpulation());
    }
}
