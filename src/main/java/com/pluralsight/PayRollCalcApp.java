package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class PayRollCalcApp {

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("src/main/resources/employees.csv");
            BufferedReader theFile = new BufferedReader(reader);

            String line;
            int lineNum = 0;
            while((line = theFile.readLine()) != null){

                //we need to find a way to move past header row
                //Eat the line
                lineNum++;
                if(lineNum ==1){
                    continue;
                }

                //process the other rows
                // split the row on the |
                String[] employeeParts = line.split("\\|");

                //create an employee from the employee class and use the setters
                //to set the properties from the row in the file

               int id = Integer.parseInt(employeeParts[0]);
               String name = employeeParts[1];
               double employeeHours = Double.parseDouble(employeeParts[2]);
               double employeePayRate = Double.parseDouble(employeeParts[3]);

               //Checking to see if it prints
                System.out.println(Arrays.toString(employeeParts));

                // call the gross pay method on the employee to print out their gross pay
                System.out.println(line);

                double hoursWorked = 0;
                double payRate = 0;
                Employee employee = new Employee(id, name, hoursWorked, payRate);

                System.out.println(employee.getName() + " gross pay: " + employee.getGrossPay()
                );
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
