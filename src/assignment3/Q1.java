package assignment3;

/**
 *
 * Food contains name of food name or by default set to Food
 */
class Food{
    String name;

    /**
     * seting default food name;
     */
    Food(){
        this.name="Food";
    }
    /**
     *
     * @param name setName of food
     */
    Food(String name){
        this.name=name;
    }

    /**
     *
     * @return string with name of Food.
     */
    @Override
    public String toString() {
        return "This "+ name +" is Food\n";
    }
}

/**
 * Fruits is subClass of Food
 * it use super to initialize name of food
 * default name will be Fruit.
 */
class Fruits extends Food{
    Fruits(){
        this.name="Fruit";
    }
    Fruits(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a fruit \n";
    }
}

/**
 * Vegetables is subClass of Food.
 * it use super to initialize name of food
 * default name will be Vegetable.
 */
class Vegetables extends Food{
    Vegetables(){
        this.name="Vegetable";
    }

    Vegetables(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a vegetable \n";
    }
}


/**
 * there is 3 category of Food and Vegetables
 * for Fruits
 *            1 SummerFruits
 *            2 WinterFruits
 *            3 MonsoonFruits
 * for Vegetables
 *            1 SummerVegetables
 *            2 WinterVegetables
 *            3 MonsoonVegetables
 *
 * all class use super to define name of Fruits or vegetable.
 */
class SummerFruits extends Fruits{
    SummerFruits(){
        this.name = "SummerFruits";
    }

    SummerFruits(String name){
        this.name = "name";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a SummerFruits \n";
    }
}

class WinterFruits extends Fruits{
    WinterFruits(){
        this.name = "WinterFruits";
    }

    WinterFruits(String name){
        this.name = "name";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a WinterFruits \n";
    }
}

class MonsoonFruits extends Fruits{
    MonsoonFruits(){
        this.name = "MonsoonFruits";
    }

    MonsoonFruits(String name){
        this.name = "name";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a MonsoonFruits \n";
    }
}

class SummerVegetables extends Vegetables{
    SummerVegetables(){
        this.name = "SummerVegetables";
    }

    SummerVegetables(String name){
        this.name = "name";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a SummerVegetables \n";
    }
}

class WinterVegetables extends Vegetables{
    WinterVegetables(){
        this.name = "WinterVegetables";
    }

    WinterVegetables(String name){
        this.name = "name";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a WinterVegetables \n";
    }
}

class MonsoonVegetables extends Vegetables{
    MonsoonVegetables(){
        this.name = "MonsoonVegetables";
    }

    MonsoonVegetables(String name){
        this.name = "name";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a MonsoonVegetables \n";
    }
}

/**
 *
 * there is 2 vegetables or fruits class are extended
 *      from each season.
 *
 * 1 Vegetables
 *      1 SummerVegetables
 *              1 Cucumber
 *              2 Brinjal
 *      2 WinterVegetables
 *              1 Bittergourd
 *              2 Tommato
 *      3 MonsoonVegetables
 *              1 Peas
 *              2 Ridge
 *
 * 2 Fruits
 *      1 SummerFruits
 *              1 Watermelon
 *              2 Mango
 *      2 WinterFruits
 *              1 Orange
 *              2 Apple
 *      3 MonsoonFruits
 *              1 pear
 *              2 Blueberries
 *
 *  all extended class define its own name to super class.
 *  and print data according.
 */
class Cucumber extends SummerVegetables{
    Cucumber(){
        this.name = "Cucumber";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a SummerVegetables \n";
    }
}
class Brinjal extends SummerVegetables{
    Brinjal(){
        this.name = "Brinjal";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a SummerVegetables \n";
    }
}
class Bittergourd extends WinterVegetables{
    Bittergourd(){
        this.name = "Bittergourd";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a WinterVegetables \n";
    }
}
class Tomato extends WinterVegetables{
    Tomato(){
        this.name = "Tomato";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a WinterVegetables \n";
    }
}
class Peas extends MonsoonVegetables{
    Peas(){
        this.name = "Peas";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a MonsoonVegetables \n";
    }
}
class Ridge extends MonsoonVegetables{
    Ridge(){
        this.name = "Ridge";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a MonsoonVegetables \n";
    }
}

class Watermelon extends SummerFruits{
    Watermelon(){
        this.name = "Watermelon";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a SummerFruits \n";
    }
}
class Mango extends SummerFruits{
    Mango(){
        this.name = "Mango";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a SummerFruits \n";
    }
}
class Orange extends WinterFruits{
    Orange(){
        this.name = "Orange";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a WinterFruits \n";
    }
}
class Apple extends WinterFruits{
    Apple(){
        this.name = "Apple";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a WinterFruits \n";
    }
}
class Pear extends MonsoonFruits{
    Pear(){
        this.name = "Pear";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a MonsoonFruits \n";
    }
}
class Blueberries extends MonsoonFruits{
    Blueberries(){
        this.name = "Blueberries";
    }

    @Override
    public String toString() {
        return super.toString()+
                "This "+ name+" is a MonsoonFruits \n";
    }
}

public class Q1 {
    public static void main(String[] args) {
        Watermelon watermelon = new Watermelon();
        Mango mango = new Mango();
        Orange orange= new Orange();
        Apple apple = new Apple();
        Pear pear = new Pear();
        Blueberries blueberries= new Blueberries();

        Cucumber cucumber=new Cucumber();
        Brinjal brinjal = new Brinjal();
        Bittergourd bittergourd= new Bittergourd();
        Tomato tomato=new Tomato();
        Peas peas = new Peas();
        Ridge ridge = new Ridge();

        System.out.println(watermelon);
        System.out.println(mango);
        System.out.println(orange);
        System.out.println(apple);
        System.out.println(pear);
        System.out.println(blueberries);
        System.out.println(cucumber);
        System.out.println(brinjal);
        System.out.println(bittergourd);
        System.out.println(tomato);
        System.out.println(peas);
        System.out.println(ridge);
    }
}
