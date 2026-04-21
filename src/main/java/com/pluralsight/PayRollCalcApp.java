package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PayRollCalcApp {

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("src/main/resources/employees.csv");
            BufferedReader theFile = new BufferedReader(reader);

            String line;
            while((line = theFile.readLine()) != null){

                //we need to find a way to move past header row

                //process the other rows
                //split the row on the |

                //create an employee from the employee class and use the setters
                //to set the properties from the row in the file

                // call the gross pay method on the employee to print out their gross pay
                System.out.println(line);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
