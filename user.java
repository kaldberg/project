/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geography;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author MSI
 */
public class user {


    public static void main(String[] args) {

//        ArrayList list = new ArrayList<DATA>();
        int registrationNumber = 1;
        int choice;
        do {

            Scanner reader = new Scanner(System.in);  // Reading from System.in

            //displaying menu to the user
            System.out.println("\n-------------------------welcome ------------------  ");
            System.out.println("------------------File mangment system ------------------  ");
            System.out.println("\nEnter 1 add files ");
            System.out.println("Enter 2 select files ");
            System.out.println("Enter 3 delete files ");
            System.out.print("Enter 4 for exit!    ");
            choice = reader.nextInt();        //taking input choice from user

            reader.nextLine();  //reading null character

            if (choice == 1) //*view file* check if user enter 1
            {
                byte[] data = "Hello World".getBytes();
                String filePath = "myFile.txt";

                try {
                    FileOutputStream file = new FileOutputStream(filePath);
                    file.write(data);

                } catch (Exception e) {
                    //TODO Print Error
                }

            }
            //
            else if (choice == 2)  //*To select file* check if user enter 2
            {

                boolean fileNotFound = true;
                System.out.println("Enter path to search File in");
                String pathToSearch = reader.next();
                System.out.println("Enter file name to search");
                String fileName = reader.next();

                try {
                    File folder = new File(pathToSearch);
                    File[] listOfFiles = folder.listFiles();
                    for (File file : listOfFiles) {
                        if (file.isFile()) {
                            if (fileName.equals(file.getName())) {
                                fileNotFound = false;
                                System.out.println("File found on " + file.getAbsolutePath());
                            }
                        }
                    }
                    if (fileNotFound){
                        System.out.println("File " + fileName + " not found in " + pathToSearch);
                    }
                }catch (Exception e){
                    System.err.println("Path not correct");
                }

            }
            else if (choice == 3) //*To delete file* check if user enter 4
            {
                try {

                    // Get the file
                    File f = new File("myFile.txt");

                    // delete file
                    if (f.exists()){
                        f.deleteOnExit();
                        if (f.delete()) {
                            System.out.println("File deleted");
                        } else {
                            System.out.println("File not deleted ");
                        }
                    } else
                        System.out.println("File Not found ");
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
            else if (choice != 4) {
                //display invalid input 
                System.out.println("\nInvalid Input!!!! ");
            }

        } while (choice != 5);//repeat until user enter 5 to exit
    }

}

