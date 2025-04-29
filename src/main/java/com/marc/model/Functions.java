package com.marc.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Functions class
 * @author Marc
 */
public class Functions {
  
  /**
   * Create Directory
   * @param dirName
   * @throws IOException
   */
  public static void createFolder(String dirName) throws IOException {
    Path path = Paths.get(dirName);
    Files.createDirectory(path);
  }

  /**
   * Create File
   * @param path
   * @param fileName
   * @param content
   * @throws IOException
   */
  public static void createFile(String path, String fileName, String content) throws IOException {
    Path filePath = Paths.get(path, fileName);
    Files.writeString(filePath, content);
  }

  /**
   * Show Files in Directory
   * @param path
   * @return
   * @throws IOException
   */
  public static String[] showListFiles(String path) throws IOException {
    Path dirPath = Paths.get(path);
    return Files.list(dirPath)
      .map(Path::getFileName)
      .map(Path::toString)
      .toArray(String[]::new);
  }

  /**
   * Show file content
   * @param path
   * @param fileName
   * @return
   * @throws IOException
   */
  public static String showFile(String path, String fileName) throws IOException {
    Path filePath = Paths.get(path, fileName);
    return Files.readString(filePath);
  }

  /**
   * OverWrite File
   * @param path
   * @param fileName
   * @param newContent
   * @return
   * @throws IOException
   */
  public static boolean overWriteFile(String path, String fileName, String newContent) throws IOException {
    Path filePath = Paths.get(path, fileName);
    Files.writeString(filePath, newContent);
    return true;
  }

  /**
   * Delete file
   * @param path
   * @param filename
   * @throws IOException
   */
  public static void deleteFile(String path, String filename) throws IOException {
    Path filePath = Paths.get(path, filename);
    Files.delete(filePath);
  }

  /**
   * Count characters
   * @param path
   * @param fileName
   * @return
   * @throws IOException
   */
  public static int countChars(String path, String fileName) throws IOException {
    Path filePath = Paths.get(path, fileName);
    String content = Files.readString(filePath);
    return content.length();
  }

  /**
   * Count Words
   * @param path
   * @param fileName
   * @return
   * @throws IOException
   */
  public static int countWords(String path, String fileName) throws IOException {
    Path filePath = Paths.get(path, fileName);
    String content = Files.readString(filePath);
    String[] words = content.split("\\s+");
    return words.length;
  }

  /**
   * Swap file Words
   * @param path
   * @param fileName
   * @param oldWord
   * @param newWord
   * @return
   * @throws IOException
   */
  public static String swapWords(String path, String fileName, String oldWord, String newWord) throws IOException {
    Path filePath = Paths.get(path, fileName);
    String content = Files.readString(filePath);
    String newContent = content.replaceAll(oldWord, newWord);
    Files.writeString(filePath, newContent);
    return newContent;
  }

}
