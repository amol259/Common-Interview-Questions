/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromes;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author amolsidhu
 */
public class Palindromes {

    public static void main(String[] args) {
        System.out.println("Enter a string");
        Scanner input = new Scanner(System.in);
        String in= input.nextLine();
        System.out.println(checkIfPalindrome( in));
        System.out.println(reverseString(in));

               
    }
    
    
    //for civiv
    public static boolean checkIfPalindrome(String input){
        //create a hashset of characters to  store our unpaired chars
        Set<Character> unpairedCharacters= new HashSet<>();
        
        //iterate through and for each iteration check if that char is in the hashset and remove if it is
        //if it's not add it
        
     for(char i:input.toCharArray()){
         if(unpairedCharacters.contains(i)){
             unpairedCharacters.remove(i);
         } else 
             unpairedCharacters.add(i);
         
     }
     //true if we have 0 or 1 unpaired characters
        return unpairedCharacters.size() <=1;

    }
    
    public static String reverseString(String input){
        //convert to char array
       char[] charArray= input.toCharArray();
        
       //do in place reversal
       int startIndex=0;
       int lastIndex= charArray.length-1;
       
       while(startIndex<lastIndex){
           char tempStart = charArray[startIndex];
           //swap the first and last element of array
           charArray[startIndex] = charArray[lastIndex];
           //increment and decrement to continue through array
           charArray[lastIndex]=tempStart;
           startIndex++;
           lastIndex--;
       }
       //cas
        return String.copyValueOf(charArray);
        
        
    }
    
//O(N) time
}
    
    
    
    
