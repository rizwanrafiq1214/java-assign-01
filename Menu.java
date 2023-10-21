import java.util.Locale;
import java.util.Scanner;
import java.io.*;

public class Menu {

    private static final int ARRAY_LENGTH = 7;
    static int[] studentScore = new int[ARRAY_LENGTH];
    

    public static void readScore(int[] studentScore, Scanner input) {
                        
        int i=0;
        //studentScore = new int[ARRAY_LENGTH];
        
        while (i<ARRAY_LENGTH) {
            System.out.print("Enter the score for the " + (i+1) + Prefix(i+1) + " student ");
            int scoreValue = input.nextInt();
            if (scoreValue >= 0 && scoreValue <= 100) {
                studentScore[i] = scoreValue;
                i++;
            } else {
                System.out.println("Error - Input out of bound. Score can only be between 0  and 100.");    
            }
        }

        System.out.println("Thank you for your input. Your entered scores are:");

        for (int j = 0; j < ARRAY_LENGTH; j++) {
            System.out.print(studentScore[j]);
            
            if (j < 6) { System.out.print(", ");  }
            
        }
    }

    public static String Prefix(int i){
        String prefix = null;
            if (i == 1) {
                prefix = "st";
            } else if (i == 2) {
                prefix = "nd";
            } else if (i == 3){
                prefix = "rd";
            } else if (i > 3) {
                prefix = "th";
            }
        return prefix;
    }

    public static void calculateMean(int[] studentScore) {
        int sum = 0;
        double average = 0;
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            sum = sum + studentScore[i];
        }
        average = (double) sum / studentScore.length;
        System.out.format("The mean of the numbers is %.2f", average);
        
    }
    
    public static void twohighestScore(int[] studentScore){
        int firsthighesScore = studentScore[0];
        int secondhighestScore = studentScore[0];
        
        int highestindex = 0;

        for(int i=0; i<ARRAY_LENGTH; i++){
     
            if(studentScore[i] > firsthighesScore){
                secondhighestScore = firsthighesScore;
                firsthighesScore = studentScore[i];
                highestindex = i;

            } else if( studentScore[i] > secondhighestScore && i!=highestindex){
                secondhighestScore = studentScore[i];
            }
        }
        System.out.println("The two highest scores provided are " + firsthighesScore + ", and " + secondhighestScore);
    }
    
    public static void twolowestScore(int[] studentScore){
        
        int firstlowestScore= Integer.MAX_VALUE;
        int lowestIndex = 0;
        int secondlowestScore = Integer.MAX_VALUE;
               
        for(int i=0; i<ARRAY_LENGTH; i++){
     
            if(studentScore[i] < firstlowestScore){
                
                secondlowestScore = firstlowestScore;
                firstlowestScore = studentScore[i];
                lowestIndex = i;
                
            } else if( studentScore[i] < secondlowestScore && i!= lowestIndex){
                secondlowestScore = studentScore[i];
            }

            /* 
            else if( studentScore[i] < secondlowestScore && studentScore[i] != firstlowestScore){
                secondlowestScore = studentScore[i];
            }*/
        }
        System.out.println("The two lowest scores provided are " + firstlowestScore + ", and " + secondlowestScore);
    }

    public static void positionHigh() {
        int highestScore = 0;
        int highestIndex = 0;
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (studentScore[i] > highestScore) {
                highestScore = studentScore[i];
                highestIndex = i;
            }
        }

        System.out.println(
                "The highest score is " + highestScore + " and belongs to the " + (highestIndex+1) + Prefix(highestIndex+1) + " Student");
    }

    public static void hashFind(Scanner input) {
        System.out.print("Type your post: ");
        String storeEnter = input.nextLine();
        String mysocialString = input.nextLine();
                
        String[] splitArray = mysocialString.split(" ");
            int hashCount = 0;
            String hashTag = "";
            
            for(int i=0; i< splitArray.length; i++){
                
                String isHash = splitArray[i];
                if(isHash.startsWith("#")){
                    hashCount ++;
                    hashTag += isHash+" ";
                } 
            }

            if(hashCount>0){
                
                System.out.print("Hashtags found: "+hashTag.toString());
            } else{
                System.out.println("No hashtags were typed");
            }
            
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.ENGLISH);
        int valueMenu;

        readScore(studentScore, input);

        do {
            System.out.println("\n");
            System.out.println("Welcome to the menu. Choose one of the options below:");
            System.out.println("1. Register new scores for students.");
            System.out.println("2. Calculate the mean of the entered scores.");
            System.out.println("3. Find the two highest and two lowest scores.");
            System.out.println("4. Find the highest score and its position.");
            System.out.println("5. Collect hashtags from a post.");
            System.out.println("6. To exit.");
            
                System.out.print("Type your option: ");
                valueMenu = input.nextInt();
                
            switch (valueMenu) {
                case 1:
                    readScore(studentScore, input);
                    break;
                case 2:
                    calculateMean(studentScore);
                    break;
                case 3:
                    twolowestScore(studentScore);
                    twohighestScore(studentScore);
                    break;
                case 4:
                    positionHigh();
                    break;
                case 5:
                    hashFind(input);
                    break;
                case 6:
                    System.out.println("Thank you for using our grading system. Have a nice day!");
                    break;
                default:
                System.out.println("Error - Invalid value. Please type between 1 and 6");
                    break;
            }
        } while (valueMenu != 6);
        input.close();

    }
}