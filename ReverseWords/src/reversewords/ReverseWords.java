/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversewords;

/**
 *
 * @author amolsidhu
 */
public class ReverseWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  String message = "find you will pain only go you recordings security the into if";
  System.out.print(reverseWords(message));


    }
    //reverses words of string
   // When writing your function, assume the message contains only letters and spaces, and all words are separated by one space.

  public static String reverseWords(String message) {

    char[] messageChars = message.toCharArray();

    // first we reverse all the characters in the entire messageChars array
    // this gives us the right word order
    // but with each word backwards
  //  reverseCharacters(messageChars, 0, messageChars.length - 1);
  reverse(messageChars);
  

    // now we'll make the words forward again
    // by reversing each word's characters

    // we hold the index of the *start* of the current word
    // as we look for the *end* of the current word
//    int currentWordStartIndex = 0;
//    for (int i = 0; i <= messageChars.length; i++) {
//
//        // found the end of the current word by either recognizing a space or recognizing last char
//        if (i == messageChars.length || messageChars[i] == ' ') {
//
//            // if we haven't exhausted the string, our
//            // next word's start is one character ahead
//            reverseCharacters(messageChars, currentWordStartIndex, i - 1);
//            currentWordStartIndex = i + 1;
//        }
//    }

    reverse(messageChars);

    return messageChars;
}

private static void reverseCharacters(char[] messageChars, int startIndex, int endIndex) {

    // walk towards the middle, from both sides
    while (startIndex < endIndex) {

        // swap the front char and back char
        char temp = messageChars[startIndex];
        messageChars[startIndex] = messageChars[endIndex];
        messageChars[endIndex] = temp;
        startIndex++;
        endIndex--;
    }
}


private static String reverse(char[] messageChars){
    String reverse ="";
    for(int i=messageChars.length-1; i>=0; i--){
        reverse= reverse+ messageChars[i];
    }
    return reverse;
}
}