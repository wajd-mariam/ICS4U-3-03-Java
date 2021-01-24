/*
* This program uses binary search to find numbers inputted by the user.
*
* @author  Wajd Mariam
* @version 1.0
* @since   2021/01/06
*/

import java.util.Random;
import java.util.Scanner;

public class Main1 {
  
  static int[] sorter(int[] array1) {
    // Sorting array list from smallest number to largest:
    for (int startIndex = 0; startIndex < array1.length; startIndex++) {
      for (int currentIndex = (startIndex + 1); currentIndex < array1.length; currentIndex++) {
        if (array1[startIndex] > array1[currentIndex]) {
          int numberSelected = array1[currentIndex];
          array1[currentIndex] = array1[startIndex];
          array1[startIndex] = numberSelected;
        }
      }
    }
    return array1;
  }
  
  static String search(int[] array, int targetElement, 
                       int firstElement1, int lastElement1) {
    if (firstElement1 > lastElement1) {
      // Returning that the number could not be found in the array
      throw null;
    // Declaring variables used.
    } else {
      int middleElement = (int) Math.floor(lastElement1 + firstElement1) / 2;
    
      if (array[middleElement] < targetElement) {
        return (search(array, targetElement, middleElement + 1, lastElement1));
      } else if (array[middleElement] > targetElement) {
        return (search(array, targetElement, firstElement1, middleElement - 1));
      } else {
        String solution = Integer.toString(middleElement);
        return solution;
      }
    }
  }
  
  /**
   * Generating random numbers.
   */ 
  public static void main(String[] args) {

    // Try Catch statement:
    try {
      // Initializing the random class
      // Initializing array of numbers
      int[] arrayList = new int [25];

      // Adding numbers to the array
      for (int counter = 0; counter < arrayList.length; counter++) {
        arrayList[counter] =  (int) (Math.random() * 100);
      }
      
      // Printing out the list of generated numbers after sorting:
      System.out.println("Array list after being sorted: ");
      int[] numberArray = sorter(arrayList);
      String listPrint = "";
      for (int counter = 0; counter < numberArray.length; counter++) {
        listPrint = listPrint + numberArray[counter] + ", ";
      }
      System.out.println(listPrint);
 
      
      // Input
      // Requesting user to enter a number to find in the list: 
      Scanner input1 = new Scanner(System.in);
      System.out.println("");
      System.out.print("Enter a number you wish to find in the list: ");
      int inputNumber = input1.nextInt();

      // Passing number to the search method to look for it in the array:
      // Returning the location of the number  after finding it.
      String searchIndex = search(numberArray, inputNumber, 0, arrayList.length - 1);
      System.out.print("Number was found at index # " + searchIndex);

    } catch (NullPointerException e) {
      System.out.println("");
      System.out.print("ERROR.Number is unavailable in array!");
    } catch (Exception e) {
      System.out.println("Invalid Input");
    }
  }
}
