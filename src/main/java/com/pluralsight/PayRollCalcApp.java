package com.pluralsight;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
//import java.util.*

public class PayRollCalcApp {
    static Scanner theScanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            //Do this first
            //Prompt the user questions:
            System.out.print("Enter the name of the file employee file to process: ");
            String theFile3 = theScanner.nextLine();
            System.out.println();
            System.out.print("Enter the name of the payroll file to create: ");
            String namePayRoll = theScanner.nextLine();

            //Concat but don't hard code the files
            //Goes to the source of the file
            FileReader reader = new FileReader("src/main/resources/" + theFile3);
            //Actually reads it line by line/pass the reader into the bufReader ro read the actual files
            BufferedReader theFile = new BufferedReader(reader);

            //Creating a file writer
            FileWriter fileWriter = new FileWriter("src/main/resources/" + namePayRoll);
            //create a buffered writer
            BufferedWriter theFile2 = new BufferedWriter(fileWriter);

            //Add Header to the file
            theFile2.write("ID|NAME|GROSSPAY\n");
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
                //System.out.println(Arrays.toString(employeeParts));

                // call the gross pay method on the employee to print out their gross pay
                //System.out.println(line);

                Employee employee = new Employee(id, name, employeeHours, employeePayRate);

                System.out.printf("ID: %d\n Name: %s\n Gross pay is %.2f.\n",employee.getEmployeeId(),employee.getName(),employee.getGrossPay());

                //Writing the file into theFile2
                theFile2.write(employee.getEmployeeId() +"|" +employee.getName() +"|"+ employee.getGrossPay() + "\n");
                //Close the Buffered Writer and reader, so it could empty into the new file

            }
            //Close outside of loop
            theFile2.close();//bufferedwriter
            fileWriter.close();//filewriter

            //Exception e will catch all errors
        } catch (Exception e) {
            System.out.println("Could not find file");
            throw new RuntimeException(e);
        }
    }
}
