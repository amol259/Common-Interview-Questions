/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbertowords;

import java.util.Scanner;


public class NumberToWords {
  private static final String[] ones= {"zero", "one","two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
   "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        
     private static final   String[] tens= { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println(convertToWord(i));
        
               
    }
    
    
    public static String convertToWord(int number){
       return getHundreds(number);
        
    }

    private static String getHundreds(int n){
     //example 523/100 = 5 hundred
        String s1= ones[n/100] + " hundred";
        String s2= getTens(n%100);
        return s1 +" "+ s2;
    }
    
    private static String getTens(int n){
        if(n<20){
            return ones[n];
    } 
        String s= tens[n/10-2]; //we do -2 because the array starts at 20
        
        if(n%10==0) {return s;} //if that was the last digit simply return it
        //else we need to pass an updated version
        return s + "-" +ones[n%10];
    }
    }
