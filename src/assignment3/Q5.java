package assignment3;

import java.util.*;

/**
 * interface created for declaring account should contain this methods
 */
interface AccountInteface {
    boolean DepositAmount(double amount);

    boolean WithdrawAmount(double amount);

    void AccessTheBalance();

    void AccessTheName();

    boolean checkPin();

    double computeFees();

    void computeInterest();
}

/**
 * account is generalized form.
 * account no is used to assign id to account
 * today is use as system date
 */
abstract class Account implements AccountInteface {
    static int accountId = 1;
    static Date today = new Date();
    double balance;
    int pinNO;
    int Accountno;
    String name;
    Date date;
    public int getAccountno() {
        return Accountno;
    }

    /**
     * increase month of this system
     * as according compute fees and interest
     * @param accounts
     */
    static void increamentMonth(List<Account> accounts){
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.MONTH, 1);
        today=cal.getTime();

        for (Account account :
                accounts) {
            account.computeFees();
            account.computeInterest();
        }
    }

    /**
     * increase year of this system
     * as according compute fees and interest
     * @param accounts
     */
    static void increamentYear(List<Account> accounts){
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.YEAR, 1);
        today=cal.getTime();

        for (Account account :
                accounts) {
            account.computeFees(12);
            account.computeInterest();
        }
    }

    /**
     * initialize account details
     *
     * @param name
     * @param balance
     * @param pinno
     */
    Account(String name, int balance, int pinno) {
        this.Accountno = Account.accountId++;
        this.name = name;
        this.pinNO = pinno;
        this.balance = balance;
        date=today;
        System.out.println("Account no :: " + this.Accountno);
        System.out.println("Account holder name :: " + name);
        System.out.println("Current Balance :: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static int getAccountId() {
        return accountId;
    }

    public int getPinNO() {
        return pinNO;
    }

    public void setPinNO(int pinNO) {
        this.pinNO = pinNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * computes fee of account return that fees for month
     * @return
     */
    public double computeFees() {
        double fees = Math.max(10, (balance * 10) / 100);
        balance -= fees;
        return fees;
    }
    /**
     * computes fee of account return that fees for no of month
     * @return
     */
    public double computeFees(int months) {
        double fees = Math.max(10, (balance * 10) / 100)*months;
        balance -= fees;
        return fees;
    }


    /**
     * deposit amount to this accuout;
     * @param amount
     * @return
     */
    public boolean DepositAmount(double amount) {
        balance += amount;
        balance -= checkPanelty();
        return true;
    }

    /**
     * print account holder name
     */
    public void AccessTheName() {
        System.out.println("this account holder name is " + this.getName());
    }

    /**
     * check pin of this account
     * @return
     */
    @Override
    public boolean checkPin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your pin");
        int n = sc.nextInt();
        if (n == this.pinNO) {
            return true;
        }
        return false;
    }

    abstract double checkPanelty();

    /**
     * withdrow amount from this account and check for penalty.
     * @param amount
     * @return
     */
    public boolean WithdrawAmount(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        balance -=checkPanelty();
        return true;
    }

    /**
     * print current balance
     */
    @Override
    public void AccessTheBalance() {
        System.out.println("Your current balance is " + this.getBalance());
    }

    /**
     * this method use to transfer amount between 2 account
     * @param allaccounts
     * @param idFrom
     * @param idTo
     * @param amount
     * @return
     */
    public static boolean transaction(List<Account> allaccounts , int idFrom , int idTo, double amount){
        if(Account.accountId<=idFrom || Account.accountId<=idTo || idFrom==idTo){
            return false;
        }
           if (allaccounts.get(idFrom-1).WithdrawAmount(amount)==false){
               return false;
           }
           if(allaccounts.get(idTo-1).DepositAmount(amount)==false){
               allaccounts.get(idFrom-1).DepositAmount(amount);
           }
        return true;
    }

    /**
     * get no of month pass from give date
     * @param d
     * @return
     */
    public static int getMonths(Date d){
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        Calendar todayCal = Calendar.getInstance();
        todayCal.setTime(Account.today);
        int year = todayCal.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        int difMonth = year*12 +todayCal.get(Calendar.MONTH) - cal.get(Calendar.MONTH);
        return difMonth;
    }
}


class RegularAccount extends Account {
    int minBalance;
    public RegularAccount(String name, int balance, int pinno) {
        super(name, balance, pinno);
        minBalance=500;
    }

    /**
     *
     * use to calculate penalty of this account
     * as per condtion
     * @return
     */
    @Override
    double checkPanelty() {
        if (this.balance < this.minBalance) {
            return 10;
        }
        return 0;
    }

    /**
     * calculate interest but for this account not have to calculate interest
     */
    @Override
    public void computeInterest() {
        return;
    }
}



class InterestAccount extends Account {
    int interestPercentage;
    Date date;

    public InterestAccount(String name, int balance, int pinno) {
        super(name, balance, pinno);
        this.interestPercentage = 7;
        this.date = new Date();
    }



    @Override
    double checkPanelty() {
        return 0;
    }

    /**
     * calculate interest base on months
     */
    @Override
    public void computeInterest() {
        int month = getMonths(date);
        double interest = (balance * interestPercentage) / 100;
        balance += interest * month;
        date = today;
    }



}


class CheckingAccount extends Account {
    int interestPercentage;
    double transactionCharges;
    int minBalance;
    public CheckingAccount(String name, int balance, int pinno) {
        super(name, balance, pinno);
        this.interestPercentage = 7;
        minBalance=100;
        this.transactionCharges= 0.10;
    }

    @Override
    public boolean DepositAmount(double amount) {
         if(super.DepositAmount(amount)==false)
             return false;
         balance-=transactionCharges;
         checkPanelty();
         return true;
    }

    @Override
    public boolean WithdrawAmount(double amount) {
        if(super.WithdrawAmount(amount))
            return false;
        balance-=transactionCharges;
        checkPanelty();
        return true;
    }

    @Override
    double checkPanelty() {
        if (this.balance < this.minBalance) {
            return 10;
        }
        return 0;
    }

    /**
     * calculate interest base on months
     */
    @Override
    public void computeInterest() {
        int month = getMonths(date);
        double interest = (balance * interestPercentage) / 100;
        balance += interest * month;
        date= today;
    }
}


class CDAccount extends Account {
    int interestPercentage;
    int minMonth;
    Date AcDate;
    int penltyCharge;
    public CDAccount(String name, int balance, int pinno) {
        super(name, balance, pinno);
        this.interestPercentage = 15;
        this.minMonth=12;
        this.penltyCharge=20;
        AcDate=today;
    }

    /**
     * deposit amount to this accuout;
     *
     * @param amount
     * @return
     */
    @Override
    public boolean DepositAmount(double amount) {
        if(super.DepositAmount(amount)==false)
            return false;
        AcDate=today;
        return true;
    }

    /**
     * compute panelty as per condition
     * not last time excution of withdrow and depostit date will be in consideration
     */

    @Override
    double checkPanelty() {
        int month=getMonths(AcDate);
        if (month < minMonth) {
            return (balance*penltyCharge)/100;
        }

        return 0;
    }

    /**
     * compute interest as per condition
     * assumption execution will diffrence will be in year so year/12 not include any months.
     */
    @Override
    public void computeInterest() {
        int year = getMonths(date);
        if(year/12>0) {
            double interest = (balance * interestPercentage) / 100;
            balance += interest * (year/12);
            date=today;
        }
        else{
            return;
        }
    }
}


public class Q5 {
    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();

        accountList.add(new RegularAccount("Jay",200,1898));
        accountList.add(new InterestAccount("Name2",900,1999));
        accountList.add(new CheckingAccount("name3",3000,1000));
        accountList.add(new CDAccount("name4",8000,2000));


        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("1. Create account ");
            System.out.println("2. WithdrawAmount ");
            System.out.println("3. DepositAmount");
            System.out.println("4. getAccount details");
            System.out.println("5 transfer fund");
            System.out.println("6. increse  date");
            System.out.println("7 exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:{
                    String name;
                    sc.nextLine();
                    System.out.print("Enter name :: ");
                    name=sc.nextLine();
                    int balance;
                    System.out.print("Enter balance :: ");
                    balance=sc.nextInt();
                    int pinno;
                    System.out.print("Enter pin no ");
                    pinno=sc.nextInt();

                    System.out.println("1 regular account");
                    System.out.println("2 interest account");
                    System.out.println("3 checking account");
                    System.out.println("4 SD account");
                    choice = sc.nextInt();

                    switch (choice){
                        case 1:
                            accountList.add(new RegularAccount(name,balance,pinno));
                            break;
                        case 2:
                            accountList.add(new InterestAccount(name,balance,pinno));
                            break;
                        case 3:
                            accountList.add(new CheckingAccount(name,balance,pinno));
                            break;
                        case 4:
                            accountList.add(new CDAccount(name,balance,pinno));
                            break;
                    }
                }
                   break;
                case 2:{
                    int accNo;
                    System.out.print("Enter account no");
                    accNo=sc.nextInt();
                    if(accNo<Account.accountId){
                       if( accountList.get(accNo-1).checkPin()==true){
                           double amount;
                           System.out.print("Enter amount" );
                           amount = sc.nextDouble();
                           boolean res= accountList.get(accNo-1).WithdrawAmount(amount);
                           if(res) {
                               System.out.println("amount withdrawed");
                               System.out.println("account no " + accountList.get(accNo-1).getAccountno()+ " name "+ accountList.get(accNo-1).getName()+" balance "+ accountList.get(accNo-1).getBalance());
                           }else
                               System.out.println("amount not withdrwed");
                       }
                       else{
                           System.out.println("pin not valid");
                       }
                    }
                    else {
                        System.out.println("account not found");
                    }

                }
                    break;
                case 3:{
                    int accNo;
                    System.out.print("Enter account no");
                    accNo=sc.nextInt();
                    if(accNo<Account.accountId){
                        if( accountList.get(accNo-1).checkPin()==true){
                            double amount;
                            System.out.print("Enter amount" );
                            amount = sc.nextDouble();
                            boolean res= accountList.get(accNo-1).DepositAmount(amount);
                            if(res) {
                                System.out.println("amount Deposit");
                                System.out.println("account no " + accountList.get(accNo-1).getAccountno()+ " name "+ accountList.get(accNo-1).getName()+" balance "+ accountList.get(accNo-1).getBalance());
                            }
                            else
                                System.out.println("amount not Deposit");
                        }
                        else{
                            System.out.println("pin not valid");
                        }
                    }
                    else {
                        System.out.println("account not found");
                    }

                }
                    break;
                case 4:
                    for (Account account :
                            accountList) {
                        System.out.println("account no " + account.getAccountno()+ " name "+ account.getName()+" balance "+account.getBalance());
                    }
                    break;
                case 5:{
                    int from ;
                    System.out.print("Enter from which account amount transfer ");
                    from=sc.nextInt();
                    System.out.print("Enter to which account amount transfer ");
                    int to = sc.nextInt();
                    System.out.println("Enter amount ");
                    int amount = sc.nextInt();
                    if(Account.transaction(accountList,from,to,amount)){
                        System.out.println("transaction sucessfull");
                        System.out.println("account no " + accountList.get(from-1).getAccountno()+ " name "+  accountList.get(from-1).getName()+" balance "+ accountList.get(from-1).getBalance());
                        System.out.println("account no " + accountList.get(to-1).getAccountno()+ " name "+ accountList.get(to-1).getName()+" balance "+ accountList.get(to-1).getBalance());

                    }
                    else{
                        System.out.println("transaction fail");
                    }
                }
                    break;
                case 6:{
                        System.out.println("1. month");
                        System.out.println("2. year");
                        choice = sc.nextInt();
                        switch (choice){
                            case 1:
                                Account.increamentMonth(accountList);
                                break;
                            case 2:
                                Account.increamentYear(accountList);
                                break;
                        }
                        for (Account account :
                                accountList) {
                            System.out.println("account no " + account.getAccountno()+ " name "+ account.getName()+" balance "+account.getBalance());
                        }
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("wrong choice");
            }

        }while (true);

    }
}
