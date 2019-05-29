/*
 * Cryptographers Conundrum at Kattis.
 * User provides a text, and the program must output how many days it will take
 * In order to conver the entire text to PER.
 */

import java.util.Scanner;

public class Conundrum {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String cypher = "";
        
        // Send the input to upper case, providing it is not over 300 characters or
        // Not divisible by 3
        do {
            
            cypher = input.nextLine().toUpperCase();
        } while (cypher.length() % 3 != 0 || cypher.length() > 300);
        
        // Toss it in a char array for easier modification
        char[] cyph = cypher.toCharArray();
        
        // Count is for tracking the letters, day is for every day something is changed
        int count = 0;
        int day = 0;
        
        // Simple for loop, followed by comparing to the current days letter, resets once
        // It gets past r
        for (int i = 0; i < cyph.length; i++){
            
            if ((cyph[i] != 'P') && (count == 0)) {
                cyph[i] = 'P';
                count++;
                day++;
            } else if ((cyph[i] != 'E') && (count == 1)) {
                cyph[i] = 'E';
                count++;
                day++;
            } else if ((cyph[i] != 'R') && (count == 2)) {
                cyph[i] = 'R';
                count = 0;
                day++;
            } else {
                count++;
                if (count > 2){
                    count = 0;
                }
            }
        }
        
        System.out.println(day);
    }

}
