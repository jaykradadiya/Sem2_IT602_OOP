package assignment2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class TaskDataAnalysis {
    int today_dd = 26, today_mm = 2, today_yy = 2022;
    // function to check year is leap year or not
    public boolean isLeapYear(int year) {
        // return true for year id leap year
        if (year % 4 == 0 && year % 100 != 0) {
            // return true for year id leap year
            return true;
        } else return year % 100 == 0 && year % 400 == 0;
        //return false for year is not leap year
    }

    boolean checkAgeBelow50(int dd, int mm, int yy) {

        if ((2022 - yy) <= 50) {

            if ((2022 - yy) == 50) {
                if ((mm - today_mm) < 0) {
                    return false;
                }
                if ((mm - today_mm) == 0) {
                    return (today_dd - dd) <= 0;
                }
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    boolean checkdate(int dd, int mm, int yy) {
        int[] daysinMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (mm > 12 || mm < 1) {
            return false;
        }
        if (dd <= daysinMonth[mm - 1]) {
            return true;
        } else return dd == 29 && mm == 2 && isLeapYear(yy);
    }

    public void getFileData(String name) {
        String conetent ;
        try {
            File f = new File(name);
            Scanner scanner = new Scanner(f);

            while (scanner.hasNextLine()) {
                conetent = scanner.nextLine();
                System.out.println(conetent);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getAnalysisdata(String fromdata, String todata) {
        int count = 0;
        try {
            // file handle for from and to files
            File form = new File(fromdata);
            File to = new File(todata);
            //if output file not exists then create new file
            if (!to.exists()) {
                to.createNewFile();
            }
            //reading data form file
            Scanner scanner = new Scanner(form);
            //writing data to file
            FileWriter fileWriter = new FileWriter(to);
            while (scanner.hasNextLine()) {
                String date = scanner.nextLine();
                //if no data found then skip that line
                if (date.compareTo("") == 0) {
                    continue;
                }
                //split date part int 3 parts
                String[] dateParts = date.split("[- /,]");
                int dd=0, mm = 0, yy=0;
                // getting date from string
                try {
                    dd = Integer.parseInt(dateParts[0]);
                    mm = Integer.parseInt(dateParts[1]);
                    yy = Integer.parseInt(dateParts[2]);
                }
                catch (NumberFormatException e) {
                    System.out.println(date +" is not in corrent format");
                    mm= getMonthfromString(dateParts);
                }
                //checking age
                if (checkdate(dd, mm, yy)) {
                    //check age below 50 then write in file and increment count
                    if (checkAgeBelow50(dd, mm, yy)) {
                        count++;
                        fileWriter.write(dd + "-" + mm + "-" + yy + "\n");
                    }
                } else {
                    System.out.println(date+" date is not valid");
                }

            }
            fileWriter.close();
            scanner.close();
            System.out.println("printing data of below age 50");
            getFileData(todata);
            return count;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    private int getMonthfromString(String[] dateParts) {
        int mm=0;
        switch (dateParts[1].toLowerCase()) {
            case "jan":
            case "january":
                mm = 1;
                break;
            case "feb":
            case "february":
                mm = 2;
                break;
            case "mar":
            case "march":
                mm = 3;
                break;
            case "apr":
            case "april":
                mm = 4;
                break;
            case "may":
                mm = 5;
                break;
            case "jun":
            case "june":
                mm = 6;
                break;
            case "jul":
            case "july":
                mm = 7;
                break;
            case "aug":
            case "auguest":
                mm = 8;
                break;
            case "sep":
            case "september":
                mm = 9;
                break;
            case "oct":
            case "october":
                mm = 10;
                break;
            case "nov":
            case "november":
                mm = 11;
                break;
            case "dec":
            case "december":
                mm = 12;
                break;
        }
        return mm;
    }
}

public class Q5 {
    public static void main(String[] args) {
        TaskDataAnalysis taskDataAnalysis = new TaskDataAnalysis();

        System.out.println("NO of dob found which age below 50 " + taskDataAnalysis.getAnalysisdata("./src/assignment2/data.txt", "./src/assignment2/data1.txt"));
    }
}
