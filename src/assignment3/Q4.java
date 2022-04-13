package assignment3;


import java.util.Arrays;

/**
 * interface of shape defining method should be implemented.
 */
interface shape{

    double getArea();
    int getPerimeter();
    String toString();
}

/**
 * circle is using shape for getting defined method name and initialize method.
 *
 */
class circle implements shape{
    int radius;

    /**
     * set radious of circle
     * @param radius
     */
    circle(int radius){
        this.radius = radius;
    }

    /**
     * calculare area of circle
     * formula PI*radius*radius
     * @return
     */
    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    /**
     * calculate perimeter
     *
     * formula 2*PI*radius
     * @return
     */
    @Override
    public int getPerimeter() {
        return (int) (2*Math.PI*radius);
    }

    @Override
    public String toString() {
        return "circle{" +
                "radius=" + radius +
                "area "+ getArea()+" perimeter "+ getPerimeter()+
                '}';
    }
}

/**
 * polygon is also  using shape for getting defined method name and initialize method.
 *
 * acceptation side as array of sides
 * acceptation angle between 2 sides as array of angles
 *
 */
class polygon implements shape{
    int[] sides;
    int[] angles;

    /**
     * setting sides and angles of polygon if side and angle length should be same
     * @param sides
     * @param angles
     * @throws Exception
     */
    polygon(int[] sides, int[] angles) throws Exception {
        this.sides=sides;
        this.angles=angles;
        if(sides.length != angles.length){
            throw new Exception("sides lenght not equal as angle");
        }
    }

    /**
     * used general polygon area find formula
     * it divides polygon in triangle from central and calculate area of triangle
     * then it multiply with no of triangle
     *
     * it will not work with other than regular polygon
     *
     * @return area of polygon
     */
    @Override
    public double getArea() {
        int perimeter = this.getPerimeter();
        int avgSideLength = perimeter/sides.length;
        double avgApothem =  ((avgSideLength/2)*Math.tan(Math.toRadians(90- (180 / sides.length))));
        double triangle = (0.5)*(avgApothem*perimeter);
        return triangle;
    }

    /**
     * calculation of interior Angle of polygon
     * work with regular polygon
     * @return
     */
    public int getInteriorAngles(){
       return (180)*(sides.length-2)/sides.length;
    }

    /**
     *
     * @return
     */
    public int getExteriorAngle(){
        return  180 - getInteriorAngles();
    }

    @Override
    public int getPerimeter() {
        int sum =0;
        for (int size : sides) {
            sum+=size;
        }
        return sum;
    }

    public boolean isEqulSide(){
        for (int i = 0; i < sides.length-1; i++) {
            if(sides[i]!=sides[i+1]){
                return false;
            }
        }
        return true;
    }

    public boolean isEqualAngle(){
        for (int i = 0; i < angles.length-1; i++) {
            if(angles[i]!=angles[i+1]){
                return false;
            }
        }
        return true;
    }

    public boolean isConvex() {
        double sum = 0;

        if (isRegular())
            return true;

        for (int i=0; i<sides.length; i++) {
            if (angles[i] > 180)
                return false;
            sum += angles[i];
        }
        return (sum == ((sides.length - -2) *180));
    }

    public boolean isConcave() {
        if(sides.length<4)
            return false;
        return !isConvex();
    }

    public boolean isRegular() {
        if(isEqualAngle() && isEqulSide())
            return true;
        return false;
    }

    public boolean isIrRegular() {
        return !isRegular();
    }

    @Override
    public String toString() {
        String regular="";
        if(isRegular()){
            regular=" Regular polygon";
        }
        else {
            regular =" Irregular polygon";
        }

        String concave="";
        if(isConcave()){
            concave=" concave Polygon";
        }
        else if(isConvex()){
            concave=" convax Polygon";
        }
        return "polygone{" +
                "sides=" + Arrays.toString(sides) +
                ", angles=" + Arrays.toString(angles) +"\n"+
                " area "+ getArea()+" perimeter "+getPerimeter()+"\n"+
                " an exterior angle "+ getExteriorAngle()+
                " an Interior angle "+ getInteriorAngles()+
                regular+" "+ concave+
                '}';
    }
}


class square extends polygon {

    square(int sides) throws Exception {
        super(new int[]{sides,sides,sides,sides},new int[]{90,90,90,90});
    }

    @Override
    public double getArea() {
        return sides[0]*sides[0];
    }
}
class Octagon extends polygon {
    public Octagon(int side) throws Exception {
        super(new int[]{side,side,side,side,side,side,side,side},new int[]{45,45,45,45,45,45,45,45});
    }

    @Override
    public double getArea() {
        return (2 * (1 + Math.sqrt(2.0)) * sides[0] * sides[0]);
    }

    @Override
    public int getPerimeter() {
        return (8 * sides[0]);
    }
}
class Rectangle extends polygon {

    Rectangle(int l,int b) throws Exception {
        super(new int[]{l,b,l,b},new int[]{90,90,90,90});
    }

    @Override
    public double getArea() {
        return sides[0]*sides[1];
    }
}



public class Q4 {
    public static void main(String[] args) {

        try {

            int[] sides =new int[]{6,6,6,6};
            int[] angle =new int[]{10,10,10,10};
            polygon Polygon =new polygon(sides,angle);
            polygon square = new square(10);
            circle Circle = new circle(10);
            Octagon octagon = new Octagon(15);
            System.out.println("-------------circle-----------------------");
            System.out.println(Circle);
            System.out.println("-------------polygon-----------------------");
            System.out.println(Polygon);
            System.out.println("-------------square-----------------------");
            System.out.println(square);
            System.out.println("-------------octagon-----------------------");
            System.out.println(octagon);
        }
        catch (Exception t){
            System.out.println(t.getMessage());
        }
    }
}
