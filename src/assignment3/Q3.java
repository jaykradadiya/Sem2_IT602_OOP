package assignment3;


/**
 * employee is generalized term so i make it abstract class.
 * and also define abstract function to be inilize in extended classes.
 *
 * subclass
 *   1 software developer
 *   2 team leader
 *   3 manager
 */
abstract class employee {
    int incrementPercentage;
    int referealIncrement;
    int refereals;
    int salary;

    /**
     *
     * setting salary of employee
     * incrementPercentage
     *
     * and statically setting 0.5% for all employee
     *  here i set percentage as 5 and while calculation added division of 10 to set floating point of 0.5%
     * refreal count to 0;
     *
     * @param salary
     * @param incrementPercentage
     */
    public employee(int salary, int incrementPercentage) {
        this.salary = salary;
        this.incrementPercentage = incrementPercentage;
        this.referealIncrement = 5;
        this.refereals = 0;
    }

    /**
     * used to set referals.
     * @param n
     */
    public void addRefereal(int n) {
        this.refereals += n;
    }

    /**
     * return salary of employee
     * @return salary
     */
    public int getSalary(){
        return this.salary;
    }
    abstract boolean incrementCondition();

    /**
     *
     * here it will check is salary have to increment or not
     * according to that it will increment salary.
     *
     * and increment salary per referal.
     *
     * then set to current salary and return this salary.
     * @return totalsalary
     */
    public int incrementSalary() {
        int totalSalary = salary;
        if(incrementCondition()==true){
            totalSalary += ((totalSalary*incrementPercentage)/100);
        }
        totalSalary += ((totalSalary * referealIncrement) / 1000)*refereals;
        refereals=0;
        salary=totalSalary;
        return totalSalary;
    }

    @Override
    public String toString() {
        return "employee{" +
                "incrementPercentage=" + incrementPercentage +
                ", referealIncrement=" + referealIncrement +
                ", refereals=" + refereals +
                ", salary=" + salary +
                '}';
    }
}

/**
 * software developer is also generalized word
 *
 * and here we also calculation no of years worked for that company.
 *
 * subclasses are
 *      1 jrsoftwaredeveloper
 *      2 srsoftwaredeveloper
 */

abstract class softwareDevelopment extends employee {
    int workedOnCompnay;

    public softwareDevelopment(int workedOnCompnay, int salary) {
        super(salary,0);
        this.workedOnCompnay = workedOnCompnay;
    }

    public softwareDevelopment(int workedOnCompnay, int salary, int incrementPercentage) {
        super(salary, incrementPercentage);
        this.workedOnCompnay = workedOnCompnay;
    }

    public void setWorkedOnCompnay(int workedOnCompnay) {
        this.workedOnCompnay = workedOnCompnay;
    }

    @Override
    public String toString() {
        return "softwareDevelopment{" +
                "incrementPercentage=" + incrementPercentage +
                ", referealIncrement=" + referealIncrement +
                ", refereals=" + refereals +
                ", salary=" + salary +
                ", workedOnCompnay=" + workedOnCompnay +
                '}';
    }
}

class jrSoftwareDevelopment extends softwareDevelopment {

    public jrSoftwareDevelopment(int workedOnCompnay, int salary) {
        super(workedOnCompnay, salary,7);
    }

    public jrSoftwareDevelopment(int workedOnCompnay, int salary, int incrementPercentage) {
        super(workedOnCompnay, salary, incrementPercentage);
    }

    /**
     * here we are overriding incrementcondtion as per current class condtion.
     * return that employee eligible to increment or not
     * @return
     */
    @Override
    boolean incrementCondition() {
        if(this.workedOnCompnay>=2){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
            return super.toString();
    }
}

class srSoftwareDevelopment extends softwareDevelopment {
    public srSoftwareDevelopment(int salary) {
        super(0,salary,10);
    }
    /**
     * here we are overriding incrementcondtion as per current class condtion.
     * return that employee eligible to increment or not
     * @return
     */
    @Override
    boolean incrementCondition() {
        if(this.workedOnCompnay>=2){
            return true;
        }
        return false;
    }
    public srSoftwareDevelopment(int workedOnCompnay, int salary) {
        super(workedOnCompnay, salary,10);
    }

    public srSoftwareDevelopment(int workedOnCompnay, int salary, int incrementPercentage) {
        super(incrementPercentage,salary, workedOnCompnay);
    }
}

/**
 * in teamLeader class we are using no of project for increment Condition
 *
 */

class teamLead extends employee {
    int noOfProject;

    public teamLead(int salary, int noOfProject) {
        super(salary,15);
        this.noOfProject = noOfProject;
    }

    public teamLead(int salary, int incrementPercentage, int noOfProject) {
        super(salary, incrementPercentage);
        this.noOfProject = noOfProject;
    }

    public void setNoOfProject(int noOfProject) {
        this.noOfProject = noOfProject;
    }
    /**
     * here we are overriding incrementcondtion as per current class condtion.
     * return that employee eligible to increment or not
     * @return
     */
    @Override
    boolean incrementCondition() {
        if(this.noOfProject>=10){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "teamLead{" +
                "incrementPercentage=" + incrementPercentage +
                ", referealIncrement=" + referealIncrement +
                ", refereals=" + refereals +
                ", salary=" + salary +
                ", noOfProject=" + noOfProject +
                '}';
    }
}

/**
 * there is no condition to increment salary.
 */
class manager extends employee {
    public manager(int salary) {
        super(salary,30);
    }

    public manager(int salary, int incrementPercentage) {
        super(salary, incrementPercentage);
    }

    /**
     * here we are overriding incrementcondtion as per current class condtion.
     * return that employee eligible to increment or not
     * @return
     */
    @Override
    boolean incrementCondition() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


public class Q3 {
    public static void main(String[] args) {
        softwareDevelopment jrSoftwareDevelopment = new jrSoftwareDevelopment(2, 200);
        softwareDevelopment srSoftwareDevelopment = new srSoftwareDevelopment(2, 200);
        employee manager = new manager(200);
        employee teamLead  = new teamLead(200,10);


        System.out.println(jrSoftwareDevelopment);
        System.out.println(srSoftwareDevelopment);
        System.out.println(teamLead);
        System.out.println(manager);

        System.out.println("jrSoftwareDevelopment salary increment "+jrSoftwareDevelopment.incrementSalary());
        System.out.println("srSoftwareDevelopment salary increment "+srSoftwareDevelopment.incrementSalary());
        System.out.println("teamLead salary increment " +teamLead.incrementSalary());
        System.out.println("manager salary increment " +manager.incrementSalary());
        System.out.println();
        jrSoftwareDevelopment.addRefereal(2);
        srSoftwareDevelopment.addRefereal(1);
        System.out.println(jrSoftwareDevelopment);
        System.out.println(srSoftwareDevelopment);
        System.out.println(manager);
        System.out.println(teamLead);
        System.out.println();
        System.out.println("jrSoftwareDevelopment salary increment "+jrSoftwareDevelopment.incrementSalary());
        System.out.println("srSoftwareDevelopment salary increment "+srSoftwareDevelopment.incrementSalary());
        System.out.println("teamLead salary increment " +teamLead.incrementSalary());
        System.out.println("manager salary increment " +manager.incrementSalary());


        System.out.println(jrSoftwareDevelopment);
        System.out.println(srSoftwareDevelopment);
        System.out.println(manager);
        System.out.println(teamLead);

    }
}
