// ALEXANDER SMALLCOMB
// SPLITSHAPPEN EITC PROGAMMING TEST

// TAKE INPUT STRING, CONVERT TO SCORE CHAR ARRAY
// CREATE INDIVIDUAL VALUE INT ARRAY 
// CALC CONTXTUAL SCORE INT ARRAY 
	// STRIKE 'X' : + NEXT TWO BALLS
	// SPARE '/' : + NEXT ONE BALL
// SUBTRACT LAST TWO BONUS THROWS FROM STRINGS ENDING IN ...Xxx
// SUBTRACT LAST BONUS THROW FROM STRINGS ENDING IN .../x
// DISPLAY SCORE
	
// TEST CASES
// XXXXXXXXXXXX				: 300
// 9-9-9-9-9-9-9-9-9-9-		: 90
// 5/5/5/5/5/5/5/5/5/5/5	: 150
// X7/9-X-88/-6XXX81 		: 167

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		
        String testcaseString;
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER TESTCASE:" );
        
        testcaseString = input.next();
        input.close();
        
        // testcaseString = "XXXXXXXXXXXX";
        // testcaseString = "9-9-9-9-9-9-9-9-9-9-";
        // testcaseString = "5/5/5/5/5/5/5/5/5/5/5";
        // testcaseString = "X7/9-X-88/-6XXX81";
        
        char[] ball = testcaseString.toCharArray();
        
        int[] value = new int[testcaseString.length()+2];
        
        int[] score = new int[testcaseString.length()+2];
        
        int totalScore = 0;
        
        // CALC INDIVIDUAL THROW VALUES
        for(int i=0;i<ball.length;i++){
        	
        	value[i] = Character.getNumericValue(ball[i]);
        	
    		if (ball[i] == 'X'){
    			value[i] = 10;
    		}
    		if (ball[i] == '/'){
        			value[i] = 10 - value[i-1];
    		}
    		if (ball[i] == '-'){
    			value[i] = 0;
    		}
    	}
    	
        // CONVERT TO CONTEXTUAL SCORE
    	for(int j=0;j<ball.length;j++){
    		
    		score[j] = value[j];
    		
    		if (ball[j] == 'X'){
    			score[j] = (value[j] + value[j+1]+ value[j+2]);
    		}
    		if (ball[j] == '/'){
    			score[j] = (value[j] + value[j+1]);
    		}
    		
        	// System.out.print((j+1) + ": ");
        	// System.out.print(ball[j] + ": ");
        	// System.out.print(value[j]+ ": ");
        	// System.out.println(score[j]);
    		
    		// SUM SCORES
    		totalScore = totalScore + score[j]; 
    	}
    	
    	// CHECK FOR ...Xxx
    	if (ball[ball.length-3] == 'X'){
    		totalScore = totalScore - (score[ball.length-2] + score[ball.length-1]);
    	}
    	
    	// CHECK FOR .../x
    	if (ball[ball.length-2] == '/'){
    		totalScore = totalScore - score[ball.length-1];
    	}
    	 
        System.out.println("TOTAL SCORE: "+ totalScore);
	}
}

	

