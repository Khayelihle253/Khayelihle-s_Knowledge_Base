package com.khaya.problem_solving_excercises.string_challenge;
import java.util.*;
import java.io.*;
class Main {
    public static String StringChallenge(String str) {
        //define variables
        boolean hasLowerCaseLetter = false;
        boolean hasUpperCaseLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;
        //check password length
        if(str.length()<=7 || str.length()>=31){
            return "false";
        }
        //check if there if 'password' exist
        if(str.toLowerCase().contains("password")){
            return "false";
        }
        //loop through the string and check each character
        for (int i=0; i<str.length();i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                hasLowerCaseLetter = true;
            }else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                hasUpperCaseLetter = true;
            }else if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                hasNumber = true;
            }else if((str.charAt(i) >= 33 && str.charAt(i) <= 47) || (str.charAt(i) >= 58 && str.charAt(i) <= 64) ||
                    (str.charAt(i) >= 91 && str.charAt(i) <= 96) || (str.charAt(i) >= 123 && str.charAt(i) <= 126)){
                hasSpecialCharacter = true;
            }
        }

        //determine if string is a valid password
        if (hasLowerCaseLetter && hasUpperCaseLetter && hasNumber && hasSpecialCharacter){
            return "true";
        }
        return "false"; //string is not a valid password
    }
    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the password to validate: ");
        System.out.print(StringChallenge(s.nextLine()));
    }
}
