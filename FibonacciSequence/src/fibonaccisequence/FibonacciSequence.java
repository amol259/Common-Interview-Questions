/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonaccisequence;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *Write a function fib() that a takes an integer n and returns the nth fibonacci ↴ number.
 */
public class FibonacciSequence {
    
 public static void main(String[] args) {
   
    System.out.println("Input n");

   Scanner input= new Scanner(System.in);
   int n =input.nextInt();
    System.out.println(FibBotUp(n));
    
    }
 
     private Map<Integer, Integer> memo = new HashMap<>();

 //bottom up approach
 static int Fib(int n){
    
    
    
    
     //Base Case n is 0 or 1
     if(n==0||n==1){
        return n;
     }
     //Edge case
     if(n <0){
         throw new IllegalArgumentException("you must have positive numbers");
     }
    
     return Fib(n-1) + Fib(n-2);
     //sum of last 2 items
     
    
 }
    //to avoid recursion use a bottom up approach where we 
 
 static int FibBotUp(int n){
     
     // edge cases:
    if (n < 0) {
        throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");
    } else if (n == 0 || n == 1) {
        return n;
    }
     
     
     int prevPrev=0;//0th
     int prev=1; //1st
     int current=0; //declare and intialize current
     
     
     for(int i=0;i<n-1;i++){
         current=prev+prevPrev; //add last 2 items
         prevPrev=prev; //move prevPrev up 1
         prev=current; //move prev up 1
     }
     return current;
     //O(n) time
 }
 


    
    
    
    
    
    
}
