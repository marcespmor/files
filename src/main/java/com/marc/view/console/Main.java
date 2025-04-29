package com.marc.view.console;

import java.io.IOException;
import java.util.Scanner;

import com.marc.model.Functions;

/**
 * Main Console class
 * @author Marc
 */
public class Main {
  private static final Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    int option;
    do {
      System.out.print(showMenu());
      System.out.print(" - Option: ");
      option = sc.nextInt();
      sc.nextLine();
      if (option > 0 && option <= 10) executeFunction(option);
    } while (option != 10);
  }

  public static String showMenu() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("=== Options ===\n");
    stringBuilder.append("1. Create Folder\n");
    stringBuilder.append("2. Create File\n");
    stringBuilder.append("3. Show List Files\n");
    stringBuilder.append("4. Show File\n");
    stringBuilder.append("5. OverWrite File\n");
    stringBuilder.append("6. Delete File\n");
    stringBuilder.append("7. Count Chars\n");
    stringBuilder.append("8. Count Words\n");
    stringBuilder.append("9. Swap Words\n");
    stringBuilder.append("10. Exit\n");

    return stringBuilder.toString();
  }

  public static void executeFunction(int option) {
    String path;
    String fileName;
    switch(option) {
      // Create Folder
      case 1:
        System.out.print("Directory name: ");
        String dirName = sc.nextLine();
        try {
          Functions.createFolder(dirName);
          System.out.println("Folder successfully created");
        } catch (IOException e) {
          System.out.println("Error creating the folder: "+e.getMessage());
        }
        break;
      // Create File
      case 2:
        System.out.print("Path: ");
        path = sc.nextLine();
        System.out.print("File Name: ");
        fileName = sc.nextLine();
        System.out.print("Content: ");
        String content = sc.nextLine();
        try {
          Functions.createFile(path, fileName, content);
          System.out.println("File successfully created");
        } catch (IOException e) {
          System.out.println("Error creating the file: "+e.getMessage());
        }
        break;
      // Show List Files
      case 3:
        System.out.print("Path: ");
        path = sc.nextLine();
        try {
          String[] listFiles = Functions.showListFiles(path);
          for(String file : listFiles) {
            System.out.print(file+" ");
          }
          System.out.println("");
        } catch (IOException e) {
          System.out.println("Error list the files: "+e.getMessage());
        }
        break;
      // Show File
      case 4:
        System.out.print("Path: ");
        path = sc.nextLine();
        System.out.print("File Name: ");
        fileName = sc.nextLine();
        try {
          String file = Functions.showFile(path, fileName);
          System.out.println(file);
        } catch (IOException e) {
          System.out.println("Error creating the file: "+e.getMessage());
        }
        break;
      // OverWrite File
      case 5:
        System.out.print("Path: ");
        path = sc.nextLine();
        System.out.print("File Name: ");
        fileName = sc.nextLine();
        System.out.print("Content: ");
        String newContent = sc.nextLine();
        try {
          Functions.createFile(path, fileName, newContent);
          System.out.println("File successfully updated");
        } catch (IOException e) {
          System.out.println("Error updating the file: "+e.getMessage());
        }
        break;
      // Delete File
      case 6:
        System.out.print("Path: ");
        path = sc.nextLine();
        System.out.print("File Name: ");
        fileName = sc.nextLine();
        try {
          Functions.deleteFile(path, fileName);
          System.out.println("File successfully deleted");
        } catch (IOException e) {
          System.out.println("Error creating the file: "+e.getMessage());
        }
        break;
      // Count Chars
      case 7:
        System.out.print("Path: ");
        path = sc.nextLine();
        System.out.print("File Name: ");
        fileName = sc.nextLine();
        try {
          int chars = Functions.countChars(path, fileName);
          System.out.println("Chars: "+chars);
        } catch (IOException e) {
          System.out.println("Error counting chars in the file: "+e.getMessage());
        }
        break;
      // Count Words
      case 8:
        System.out.print("Path: ");
        path = sc.nextLine();
        System.out.print("File Name: ");
        fileName = sc.nextLine();
        try {
          int words = Functions.countWords(path, fileName);
          System.out.println("Words: "+words);
        } catch (IOException e) {
          System.out.println("Error counting words in the file: "+e.getMessage());
        }
        break;
      // Swap Words
      case 9:
        System.out.print("Path: ");
        path = sc.nextLine();
        System.out.print("File Name: ");
        fileName = sc.nextLine();
        System.out.print("Old Word: ");
        String oldWord = sc.nextLine();
        System.out.print("New Word: ");
        String newWord = sc.nextLine();
        try {
          Functions.swapWords(path, fileName, oldWord, newWord);
          System.out.println("Words successfully swaped");
        } catch (IOException e) {
          System.out.println("Error counting words in the file: "+e.getMessage());
        }
        break;
    }
  }
}
