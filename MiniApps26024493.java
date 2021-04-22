package miniApps;

import java.util.Scanner;
import java.util.Random;

public class MiniApps26024493{

  /**************************************************************************************************************************************
   *                                                                Menu
   * ************************************************************************************************************************************/
/*Test plan:
 * ----------
 * 
 * -If I input 1. in the scanner input, as menuSelect, then it should access the PlayKeepCounting() function.
 *  
 * -2, 3, 4 will activate the AccessNumberConversionTool(), AccessUPCCalculator(), AccessUPCChecler() functions respectively.
 * 
 * -9 will print 'Bye...' and break out of the loop.
 * 
 * -If I input a number between 4 and 9 (inclusive), it should print 'Unrecognised option, please try again: ', go through the loop again
 * and go through the scanner input again.
 * 
 *  -If I input any other number, for example -10 or 120, it should print 'Invalid option, please try again: ' go through the loop again
 * and go through the scanner input again..*/
  
  public static void LaunchMenu(Scanner input)
  {
	boolean keepUsing = true;
	
	//first loop to let user go through applications until they choose 9
	do{
	    System.out.println("P4CS Mini Applications");
	    System.out.println("-----------------------");
	    System.out.println("Please select an option: ");
	    System.out.println("1) Keep Counting Game");
	    System.out.println("2) Number Conversion Tool");
	    System.out.println("3) Universal Product Code (UPC) Calculator");
	    System.out.println("4) Universal Product Code (UPC) Checker");
	    System.out.println("9) Quit");
	    System.out.println("Please enter option:");
	    
	    keepUsing = ChooseGame(input);
	}while(keepUsing);
  }
  
  public static boolean ChooseGame(Scanner input)
  {
	    boolean valid = false;
	
	    //second loop to validate the chosen option until user chooses 1,2,3,4 or 9
		do{
			int menuSelect = input.nextInt();
			
			if(menuSelect == 1)
			{
			AccessKeepCounting(input); //Choosing 1 goes to the Keep Counting Game
			valid = true;
			return true;
			
			}
			else if(menuSelect == 2)
			{
			AccessNumberConversionTool(input); //Choosing 2 goes to the Number Conversion Tool
			valid = true;
			return true;
			
			}
			else if(menuSelect == 3)
			{
			AccessUPCCalculator(input); //Choosing 3 goes to the UPC calculator
			valid = true;
			return true;
			
			}
			else if(menuSelect == 4)
			{
			AccessUPCChecker(input); //Choosing 4 goes to the UPC checker
			valid = true;
			return true;
			
			}
			else if(menuSelect > 4 && menuSelect < 9)
			{
			System.out.println("Unrecognised option, please try again: ");
			return true;
			}
			else if(menuSelect == 9)
			{
			System.out.println("Bye..."); //Choosing 9 will break both loops and quit the program
			valid = true;
			return false;
			
			}
			else
			{
			System.out.println("Invalid option, please try again: ");
			return true;
			
			}
		  }while(!valid);
  }
   /**************************************************************************************************************************************
    *                                                           Keep Counting
    * ************************************************************************************************************************************/
/*Test plan:
 * ----------
 * 
 * -Activated the KeepCounting() function many times to make sure that both the operator and the second operand is randomly generated for 
 * each question, and that the first operand is randomly generated in the first question.
 * 
 * -Answered one question incorrectly and it should break the while loop and print message 'Incorrect, the answer was + correctAnswer'.
 * 
 * -Answered all questions correctly in approximately 20 seconds and the message should read 'Questions completed in 20 seconds'.
 * 
 * -Answered all questions correctly in approximately 45 seconds and the message should read 'Questions completed in 45 seconds'.
 * 
 * -Answered all questions correctly in approximately 60 seconds and the message should read 'Questions completed in 60 seconds'*/
  
  public static void AccessKeepCounting(Scanner input)
  {
    System.out.println("Keep Counting");
    System.out.println("---------------");
    System.out.println("You will be presented with 8 additional questions.");
    System.out.println("After the first question, the left-hand operand is");
    System.out.println("the result of the previous addition");
    System.out.println("Press enter to start...\n");
    PlayKeepCounting(input);
  }
  
  public static void PlayKeepCounting(Scanner input)
  {
	//all variables needed to be initialised
	int number = 1; 
	int min = 1, max = 9;
	int correctAnswer = 0;
	boolean fail = false;
	
	int userInput, firstOperand, secondOperand;
	
	firstOperand=0; //firstOperand variable is randomly initialised as 0 and will be declared a different value later on.

    long startTime = System.currentTimeMillis(); //stopwatch starts
    
    //processes through loop until question 8 has completed or if the user answer one question incorrectly
    while(number <= 8 && !fail) {
  
    	secondOperand = (int)(Math.random() * (max - min+1) + min);
    	
	    if(number == 1){ 
	    	firstOperand = (int)(Math.random() * (max - min+1) + min);
	    }
	    
	    String randomOperator = FlipCoin(); 
	    
	    //Prints out the question
	    System.out.println("Question " + number + ": " + firstOperand + " " + randomOperator + " " + secondOperand + " = ");
	    userInput = input.nextInt();
	    
	    switch(randomOperator) { //Both operators will have a 50% chance of being chosen from the FlipCoin() function
	      case "+": correctAnswer = firstOperand + secondOperand; break;
	      case "-": correctAnswer = firstOperand - secondOperand; break;
	      }
	    
	   if(userInput == correctAnswer) {
	    number++;
	    firstOperand = correctAnswer;
	    
	   }else {
	    System.out.println("Incorrect. The answer was " + correctAnswer + ".\n");
	    fail = true;
	   }
	   
	   }
    ShowKeepCountingResult(fail, startTime);
  }
  
  public static String FlipCoin() 
  {
	  //operator will have 50% chance of being assigned either '+' or '-'
	  return Math.random() < 0.5 ? "+" : "-";
  }
  
  public static void ShowKeepCountingResult(boolean fail, long startTime)
  {
	//If the user has incorrectly answered one questions, this if statement will activate
	if(!fail) 
	{
    long endTime = System.currentTimeMillis(); //stopwatch ends
    int timeElapsedInSeconds = (int) (endTime - startTime) / 1000;
    System.out.println("Questions completed in " + timeElapsedInSeconds + " seconds\n");
	}
  }
  
  
  /**************************************************************************************************************************************
   *                                                           Number Conversion Tool
   * ************************************************************************************************************************************/
  /*Test Plan:
   * ---------
   * 
   *-If we input a number less than 0 it should print 'Invalid input please try again' and goes through do while loop again.
   *
   *-The if statements from both ConvertToBinary() and ConvertToHex() functions, removes the first digit at the beginning to avoid the 0 padding 
   *at the beginning, so we input 'number = 0' to make sure that it's not affected by it and should print 'Binary: 0' and 'Hex: 0'.  
   *
   *Similarly, we input 'number = 1' to make sure it does not affect it too and print 'Binary: 1' and 'Hex: 1'.
   *
   *If I input 'number = 2' to make sure the binary is in base 2 and print 'Binary: 10' and 'Hex: 2'.
   *
   *Similarly, we input 'number = 16' to make sure that the if statement from ConvertToBinary() does not remove the first digit and
   *hexadecimal is in base 16. The output should be 'Binary: 10000' and 'Hex: 10'.
   *
   *To make sure that the switch statement from ConvertToHex() is working properly, we input decimals which have letters in its hexadecimal
   *in this case 'number = 10' and it should print 'Hex is A'.
   *
   *We also input other decimals which have letters, other than 'A' in their hexadecimal in this case 'number = 11', 'number = 12', 'number = 13', 
   *'number = 14', and 'number = 15', and it should print 'Hex : B', Hex: C', 'Hex: D', and 'Hex E' respectively.
   *
   *To make sure that the function ConvertToHexadecimal() can print out a hexadecimal consisting of digits and letters, we input 'number = 31' and I
   *expect the output to be 'Hex: 1F'
   *
   *Finally, we input 'number = 10000' to make sure there is no limit to what positive base-10 integer can be place as an input, so it should print 
   *'Binary: 10011100010000 and Hex: 2710.
   * */
  
  public static void AccessNumberConversionTool(Scanner input)
  {
	  System.out.println("Number Conversion Tool");
	  System.out.println("-----------------------");
	  System.out.println("Please enter a positive base-10 number: ");
	  CheckValidNumber(input);
  }
  
  public static void CheckValidNumber(Scanner input)
  {
	  //check if number is positive
	  boolean valid = false;
	  do {
		  int number = input.nextInt(); //scanner for user to input number
		  
		  if(number >= 0)
		  {
			  valid = true;
			  ConvertToBinary(number); 
			  ConvertToHexadecimal(number); 
			  System.out.println("\n");
			  
		  }
		  else
		  {
			  System.out.println("Invalid input please try again");
		  }
		  }while(!valid);
  }

  public static void ConvertToBinary(int number)
  {
	  String binary = "";
	  double base = ObtainBaseLimit(2, number);
	  boolean paddingRemoved = false;
	  
	  //loop until number equals 0
	  while(base >= 1){
		  
		  //boolean statement used to remove unnecessary 0 padding at the beginning
		  if(base > number && number != 0 && !paddingRemoved)
		  {
			  paddingRemoved = true;
			  base/=2;
			  continue;
		  }
		  
		  if(number >= base)
		  {
			  binary+="1";
			  number-=base;
		  }
		  else 
		  {
			  binary+="0";
		  }
		  base/=2;

	  }
	System.out.println("Binary: " + binary);
  }

  public static void ConvertToHexadecimal(int number)
  {
	  String hex = ""; //initialise hex code as empty first
	  boolean paddingRemoved = false; //boolean value for padding
	  double base = ObtainBaseLimit(16, number); //obtains maximum limit for hex base
	  
	  //loop until number equals 0
	  while(base >= 1)
	  {	
		  //if statement used to remove the unnecessary 0 padding at the beginning
		  if(base > number && number != 0 && !paddingRemoved)
		  {
			  paddingRemoved = true;
			  base /= 16;
			  continue;
			  
		  }
		 
		int remainder =  (int)(number / base);

		if(remainder >= 0 && remainder <= 9)
		{
			hex+=remainder; //add remainder to hex code
		}
		else 
		{
			//if 9 < division < 16
			switch(remainder) //switch statement to add corresponding letter to hex code
			{
			case 10: hex+="A";break;
			case 11: hex+="B";break;
			case 12: hex+="C";break;
			case 13: hex+="D";break;
			case 14: hex+="E";break;
			case 15: hex+="F";break;
			}
		}
		number-=base*remainder; //number becomes remainder
		base /= 16;
	  }
		
	System.out.println("Hex: " + hex);
	}
  
  public static double ObtainBaseLimit(int base, int number)
  {
	  double baseLimit = 1;
	  while(number > baseLimit)
	  {
		baseLimit *= base;
	  }
	  return baseLimit;
  }
  
  /**************************************************************************************************************************************
   *                                                   Universal Product Code (UPC) Calculator
   * ************************************************************************************************************************************/
/*Test plan: 
 * ---------
 * 
 * -Firstly, we input 'number = 1000000' and 'number = -1' to make sure we do not break out of the loop in CheckNumberOfDigits() and it should
 * print 'Invalid input, please enter again: ' until we write a positive integer that contains no more than 6 digits.
 * 
 * -Secondly, as a baseline, I input number = '123456' and I expect it to print'The 7-digit final UPC is: 1234561'.
 * 
 * -Also, to make sure that the 0 padding in the function UPCSeparateDigits() is working properly, we input 'number = 123' and it should return 
 * an array equal to '[0,0,0,1,2,3]' and it should print 'The 7-digit final UPC is: 1230'.
 * 
 * -If I input number = '189', I should get the output 'The 7-digit final UPC is: 189'.
 * 
 * -If I input number = '1', I should get the output 'The 7-digit final UPC is: 19'.
 * 
 * -If I input number = '0', I should get the output 'The 7-digit final UPC is: 0'
 * 
 * */
  public static void AccessUPCCalculator(Scanner input)
  {
	  System.out.println("Universal Product Code (UPC) Calculator");
	  System.out.println("----------------------------------------");
	  System.out.println("Please enter 6-digit code to generate final UPC Code: ");
	  CalculateUPC(input);
  }
  
  public static void CalculateUPC(Scanner input)
  {
	  int number;
	  int numberOfDigits;
	  int digitLimit = 6;
	  int[] codeArray = new int[digitLimit + 1];
	  
	  //get number that meets conditions required for UPC calculation
	  number = CheckNumberOfDigits(input, digitLimit);
	  numberOfDigits = ObtainNumberOfDigits(number);
	  
	  SeperateDigits(number, codeArray, numberOfDigits, digitLimit);
	  codeArray[6] = CalculateUPCFinalDigit(input, codeArray);
	  
	  System.out.print("The 7 digit final UPC is: ");
	  System.out.println(ShowFinalUPCCode(input, number, codeArray[6]) + "\n");
  }
  
  public static int CheckNumberOfDigits(Scanner input, int digitLimit)
  {
	  int number;
	  boolean valid = false;
	  
	  do {
		  //boolean statement to check if number is positive and contains less or equal amount of the digits required
		  number = input.nextInt();
		  if(number < 0 || (int)(number / (Math.pow(10, digitLimit))) != 0)
		  {
			System.out.println("Invalid input, please enter again: ");
		  }
		  else 
		  {
			  valid = true;
		  }
	  }while(!valid);
	  
	  return number;
  }
  
  public static int ObtainNumberOfDigits(int number) 
  {
	 int numberOfDigits = 1;
	 int power10 = 10;
	 
	//Calculate number of digits of the number that the user inputs
	  while(number / power10 != 0)
	  {
		  numberOfDigits++;
		  power10 *= 10;
	  }
	  return numberOfDigits;
  }
  
  public static void SeperateDigits(int number, int[] digitsArray, int numberOfDigits, int digitLimit)
  {
	  for(int i = 0; i < digitLimit; i++)
	  {
		  //Add 0 padding for numbers with fewer than 6 digits
		  if(i + numberOfDigits < digitLimit)
		  {
			  //Add 0s 'numberOfDigits' times into start of array
			  digitsArray[i] = 0;
		  }
		  else 
		  {
			  //Add digits into array
			  digitsArray[i] = (int) ((number / Math.pow(10, digitLimit - i - 1)) % 10);
		  }
	  }
  }
  
  public static int CalculateUPCFinalDigit(Scanner input, int[] codeArray)
  { 
	  int total = CalculateSum(codeArray);
	  int remainder = total % 10;
	  return remainder == 0 ? remainder : 10 - remainder;
  }
  
  public static int CalculateSum(int[] codeArray) {
	//Calculates sum of digits in odd positions sum of digits in even positions
	  int sumOfDigitsOdd = 0;
	  int sumOfDigitsEven = 0;
	  
	  int evenNumber;

	  for(int oddNumber = 0; oddNumber < 6; oddNumber+=2)
	  {
		 evenNumber = oddNumber + 1;
		 sumOfDigitsOdd += codeArray[oddNumber];
		 sumOfDigitsEven += codeArray[evenNumber];
	  }
	  
	  return sumOfDigitsOdd*3 + sumOfDigitsEven;

  }
  
  public static String ShowFinalUPCCode(Scanner input, int number, int finalDigit)
  {
	  //if number is 0 then return as itself or else show final 7-digit UPC code
	  return number == 0 ?  Integer.toString(number) : Integer.toString(number) + Integer.toString(finalDigit);
  }
  
  
  /**************************************************************************************************************************************
   *                                                   Universal Product Code (UPC) Checker
   * ************************************************************************************************************************************/
 /* Test plan:
  * -----------
  * 
  *-Firstly, as a baseline, we input 'userNumber = 1234561' and we expect it to print'The UPC is valid'.
  *
  *-Secondly, to make sure that it also checks for invalid UPC codes, we input 'userNumber = 1234569' and we expect it to print 
  *'an error was detected in the UPC'.
  * 
  * -We also input 'userNumber = 0', 'userNumber = 1230' and 'userNumber = 1231' to make sure it also works for UPC codes with '0' paddings.
  * Therefore, the expected outputs should be 'The UPC is valid' for '0' and '1230', and 'An error was detected in the UPC' respectively.
  * 
  * */

  public static void AccessUPCChecker(Scanner input)
  {
	  System.out.println("Universal Product Code (UPC) Checker");
	  System.out.println("----------------------------------------");
	  System.out.println("Please enter 7-digit UPC to check: ");
	  CalculateActualUPC(input);
  }
  
  public static void CalculateActualUPC(Scanner input)
  {
	  int digitLimit = 7;
	  
	  //Array for digits of user input number
	  int userNumber = CheckNumberOfDigits(input, digitLimit);
	  int numberOfUserDigits = ObtainNumberOfDigits(userNumber);
	  
	  //Array for digits used to calculate UPC
	  int[] UPCArray = new int[digitLimit];
	  
	  //Removes last digit of user input number
	  int calculatedUPC = (int) userNumber / 10;
	  
	  SeperateDigits(calculatedUPC, UPCArray, numberOfUserDigits - 1, digitLimit - 1);
	  CalculateUPCFinalDigit(input, UPCArray);
	  
	  System.out.println(CompareFinalDigits(UPCArray, userNumber, digitLimit));
  }
  
  public static String CompareFinalDigits(int[] UPCArray,  int userNumber, int digitLimit)
  {
	  //Determine if both final digits of user input number and its UPC are equal
	  return UPCArray[digitLimit-1] == userNumber % 10 ? "\nThe UPC is valid\n" : "\nAn error was detected in the UPC\n";
  }

}
