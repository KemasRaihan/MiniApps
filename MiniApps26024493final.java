package miniApps;

import java.util.Scanner;

public class MiniApps26024493final {
	
	/**************************************************************************************************************************************
	   *                                                                Menu
	   * ************************************************************************************************************************************/
	/*Test plan:
	 * ----------
	 * 
	 * -Input 1 should activate the AccessKeepCounting() function and break out the loop in the ChooseGame() function.
	 * 
	 * -Input 2 should activate the AccessNumberConversionTool() function and break out the loop in the ChooseGame() function.
	 * 
	 * -Input 3 should activate the AccessUPCCalculator() function and break out the loop in the ChooseGame() function.
	 * 
	 * -Input 4 should activate the AccessUPCChecker() function and break out the loop in the ChooseGame() function.
	 * 
	 * -Input 7 should print 'Unrecognised option, please try again: ', it should show the menu again go through the loop in 
	 * ChooseGame() and through the scanner input again.
	 * 
	 * -Input 9 will print 'Bye...' and break out of both loops.
	 * 
	 * -Input -5 should print 'Invalid option, please try again: ', go through the loop in ChooseGame() and through the scanner input again.
	 * 
	 * -Input 120 should print 'Invalid option, please try again: ', go through the loop in ChooseGame() and through the scanner input again.*/
	  
	  public static void LaunchMenu(Scanner input)
	  {
		boolean keepUsing = true;
		
		//First loop for menu, to let user use the applications until they quit (chooses 9)
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
	  
	  private static boolean ChooseGame(Scanner input)
	  {
		    boolean valid = false;
		
		    //Second loop for menu, to validate the user input
			do{
				int menuSelect = input.nextInt();
				
				if(menuSelect == 1)
				{
					//Choosing 1 goes to the Keep Counting Game and break out the loop in this function
					AccessKeepCounting(input); 
					valid = true;
				
				}
				else if(menuSelect == 2)
				{
					//Choosing 2 goes to the Number Conversion Tool and break out the loop in this function
					AccessNumberConversionTool(input); 
					valid = true;
				
				}
				else if(menuSelect == 3)
				{
					//Choosing 3 goes to the UPC calculator and break out the loop in this function
					AccessUPCCalculator(input); 
					valid = true;
				
				}
				else if(menuSelect == 4)
				{
					//Choosing 4 goes to the UPC checker and break out the loop in this function
					AccessUPCChecker(input); 
					valid = true;
					
				}
				else if(menuSelect > 4 && menuSelect < 9)
				{
					//Choosing a number between 4 and 9 will make user go through the loop in this function again 
					System.out.println("Unrecognised option, please try again. \n");
					valid = true;
				}
				else if(menuSelect == 9)
				{
					//Choosing 9 will break both loops and quit the program
					System.out.println("Bye..."); 
					valid = true;
					return false;
				
				}
				else
				{
					//Choosing a number less than 0 or bigger than 10 will make user go through the loop in this function again 
					System.out.println("Invalid option, please try again: ");
				
				}
			  }while(!valid);
			return true;
	  }
	   /**************************************************************************************************************************************
	    *                                                           Keep Counting
	    * ************************************************************************************************************************************/
	/*Test plan:
	 * ----------
	 * 
	 * -Activated the AccessKeepCounting() function many times to make sure that a) both the operator and the second operand is randomly generated for 
	 * each question, b) that the first operand is randomly generated in the first question, and c) the first operand of the next
	 * question is the previous correct answer.
	 * 
	 * -Answered one question incorrectly at question 1 and it should break the while loop in PlayKeepCounting() and print 
	 * 'Incorrect, the answer was + correctAnswer'.
	 * 
	 * -Answered one question incorrectly at question 4 and it should break the while loop in PlayKeepCounting() and print 
	 * 'Incorrect, the answer was + correctAnswer'.
	 * 
	 * -Answered one question incorrectly at question 8 and it should break the while loop in PlayKeepCounting() and print 
	 * 'Incorrect, the answer was + correctAnswer'.
	 * 
	 * -Answered all questions correctly in approximately 20 seconds and it should print 'Questions completed in 20 seconds'.
	 * 
	 * -Answered all questions correctly in approximately 45 seconds and it should print 'Questions completed in 45 seconds'.
	 * 
	 * -Answered all questions correctly in approximately 60 seconds and it should print 'Questions completed in 60 seconds'*/
	  
	  private static void AccessKeepCounting(Scanner input)
	  {
	    System.out.println("Keep Counting");
	    System.out.println("---------------");
	    System.out.println("You will be presented with 8 additional questions.");
	    System.out.println("After the first question, the left-hand operand is");
	    System.out.println("the result of the previous addition");
	    System.out.println("Press enter to start...\n");
	    
	    //All variables that need to be initialised
  		int number = 1;
  		final int NO_OF_QUESTIONS = 8;
  		final int MIN_NUMBER = 1, MAX_NUMBER = 9;
  		
	    PlayKeepCounting(input, number, MIN_NUMBER, MAX_NUMBER, NO_OF_QUESTIONS);
	  }
	  
	  private static void PlayKeepCounting(Scanner input, int number, int MIN_NUMBER, int MAX_NUMBER, int NO_OF_QUESTIONS)
	  {
		boolean fail = false;
	  	int userAnswer, firstOperand, secondOperand, correctAnswer;
	  	firstOperand=-1; //firstOperand variable is randomly initialised as -1 and will be declared a different value later on.

	    long startTime = System.currentTimeMillis(); //Stop watch starts
	    
	    //Processes through loop for NO_OF_QUESTIONStimes or if the user answers one question incorrectly
	    while(number <= NO_OF_QUESTIONS && !fail) {
	    	
	    	//Only accessible if we are going through first question
		    if(number == 1){ 
		    	firstOperand = ObtainRandomInteger(MIN_NUMBER, MAX_NUMBER);
		    }
		    
		    secondOperand = ObtainRandomInteger(MIN_NUMBER, MAX_NUMBER);
		    
		    //Obtain the random operator
		    String operator = GetRandomOperator(); 
		    
		    //Prints out the question
		    System.out.println("Question " + number + ": " + firstOperand + " " + operator + " " + secondOperand + " = ");
		    userAnswer = input.nextInt();
		    System.out.println("");
		    
		    //Return add firstOperand and secondOperand together if randomOperator is equal to '+' or else subtract firstOperand by secondOperand
			correctAnswer = (operator == "+") ? firstOperand + secondOperand : firstOperand - secondOperand;
		    
		   //If user answers the question correctly
		   if(userAnswer == correctAnswer) 
		   {
		    number++;
		    firstOperand = correctAnswer;
		  
		   }else 
		   {
			    System.out.println("Incorrect. The answer was " + correctAnswer + ".\n");
			    fail = true;
		   }
		   }
	    ShowKeepCountingResult(fail, startTime);
	  }
	  
	  private static int ObtainRandomInteger(int MIN_NUMBER, int MAX_NUMBER)
	  {
		  return (int)(Math.random() * (MAX_NUMBER - MIN_NUMBER+1) + MIN_NUMBER);
	  }
	  
	  private static String GetRandomOperator() 
	  {
		  //Operator will have 50% chance of being assigned either '+' or '-'
		  return Math.random() < 0.5 ? "+" : "-";
	  }
	  
	  private static void ShowKeepCountingResult(boolean fail, long startTime)
	  {
		//If the user has answered all questions correctly, this if statement will activate
		if(!fail) 
		{
		    long endTime = System.currentTimeMillis(); //Stop watch ends
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
	   *-Input -1 should print 'Invalid input please try again' and goes through while loop again.
	   *
	   *-There is an if statement from both ConvertToBinary() and ConvertToHex() functions, that removes the first digit at the beginning to 
	   *avoid the 0 padding at the beginning, input 0 should not be affected by it and should print 'Binary: 0' and 'Hex: 0'.  
	   *
	   *-Similarly, input 1 should also not be affected by it and print 'Binary: 1' and 'Hex: 1'.
	   *
	   *-Input 2 to make sure the binary is in base 2 and print 'Binary: 10' and 'Hex: 2'.
	   *
	   *-Similarly, input 16 will make sure that the if statement from ConvertToBinary() does not remove the first digit and hexadecimal is in base 16. 
	   *The output should be 'Binary: 10000' and 'Hex: 10'.
	   *
	   *-To make sure that the switch statement from ConvertToHex() is working properly, input decimals which have letters in its hexadecimal 
	   *code. In this case number = 10 should print 'Binary: 1010' and 'Hex: A'.
	   *
	   *-Input other decimals which have letters, other than 'A', in their hexadecimal in this case inputs 11, 12, 13, 14, and 15 should print 
	   *'Hex : B', Hex: C', 'Hex: D', and 'Hex E' respectively.
	   *
	   *-To make sure that the function ConvertToHexadecimal() can print out a hexadecimal consisting of digits and letters, input 31 
	   * and the output should be 'Binary: 1111' 'Hex: 1F'
	   *
	   *-Finally, input 10000 to make sure there is no limit to what positive base-10 integer can be place as an input, so it should 
	   *print 'Binary: 10011100010000' and 'Hex: 2710'.
	   * */
	  
	  private static void AccessNumberConversionTool(Scanner input)
	  {
		  System.out.println("Number Conversion Tool");
		  System.out.println("-----------------------");
		  System.out.println("Please enter a positive base-10 number: ");
		  CheckForValidNumber(input);
	  }
	  
	  private static void CheckForValidNumber(Scanner input)
	  {
		  //Check if number is positive
		  boolean valid = false;
		  do {
			  int number = input.nextInt(); 
			  if(number >= 0)//Number needs to be positive
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

	  private static void ConvertToBinary(int decimal)
	  {
		  String binary = ""; //Initialise binary code as empty first
		  double division = ObtainDivisionLimit(2, decimal); //Boolean value for padding
		  boolean paddingRemoved = false; //Obtains maximum limit for hex base
		  
		  //Loop until number equals 0
		  while(division >= 1){
			  //Boolean statement used to remove unnecessary 0 padding at the beginning
			  if(division > decimal && decimal != 0 && !paddingRemoved)
			  {
				  paddingRemoved = true;
				  division/=2;
				  continue;
			  }
			  //If number - base >= 0
			  if(decimal >= division)
			  {
				  binary+="1";
				  decimal-=division;
			  }
			  else 
			  {
				  binary+="0";
			  }
			  division/=2;
		  }
		System.out.println("Binary: " + binary);
	  }

	  private static void ConvertToHexadecimal(int decimal)
	  {
		  String hex = ""; //Initialise hex code as empty first
		  boolean paddingRemoved = false; //Boolean value for padding
		  double division = ObtainDivisionLimit(16, decimal); //Obtains maximum limit for hex base
		  
		  //Loop until number equals 0
		  while(division >= 1)
		  {	
			  //if statement used to remove the unnecessary 0 padding at the beginning
			  if(division > decimal && decimal != 0 && !paddingRemoved)
			  {
				  paddingRemoved = true;
				  division /= 16;
				  continue;
			  }
			 
			int remainder =  (int)(decimal / division);
			if(remainder >= 0 && remainder <= 9) //If remainder is a single-digit
			{
				hex+=remainder; //Add remainder to hex code
			}
			else //If remainder is between 10 and 15 (inclusive)
			{
				//switch statement to add corresponding letter to remainder
				switch(remainder) 
				{
				case 10: hex+="A";break;
				case 11: hex+="B";break;
				case 12: hex+="C";break;
				case 13: hex+="D";break;
				case 14: hex+="E";break;
				case 15: hex+="F";break;
				}
			}
			decimal-=division*remainder; //number becomes remainder
			division /= 16;
		  }
		System.out.println("Hex: " + hex);
		}
	  
	  
	  private static double ObtainDivisionLimit(int base, int number)
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
	 * -Firstly, input 1000000 to make sure CheckNumberOfDigits() does not accept numbers with more than 6 digits and it should print 
	 * 'Invalid input, please enter again: '.
	 * 
	 * -Secondly, input -1 to make sure CheckNumberOfDigits() does not accept negative numbers and it should print 
	 * 'Invalid input, please enter again: ' .
	 * 
	 * -As a baseline, input 123456 and we expect it to print'The 7-digit final UPC is: 1234561'.
	 * 
	 * -Also, to make sure that the 0 padding in the function UPCSeparateDigits() is working properly, input 123 and it should return an array 
	 * equal to '[0,0,0,1,2,3]' and it should print 'The 7-digit final UPC is: 1230'.
	 * 
	 * -Input 189 should get the output 'The 7-digit final UPC is: 189'.
	 * 
	 * -Input 1 should get the output 'The 7-digit final UPC is: 19'.
	 * 
	 * -Input 0 should get the output 'The 7-digit final UPC is: 0'
	 * 
	 * */
	  private static void AccessUPCCalculator(Scanner input)
	  {
		  System.out.println("Universal Product Code (UPC) Calculator");
		  System.out.println("----------------------------------------");
		  System.out.println("Please enter 6-digit code to generate final UPC Code: ");

		  final int limitedDigits = 6; //Get the limit for the amount of digits required, in this case 6
		  int[] codeArray = new int[limitedDigits + 1]; //Array to obtain digits that will be separated from number value
		  
		  //Get number that meets conditions required for UPC calculation
		  int number = CheckNumberOfDigits(input, limitedDigits);
		  int numberOfDigits = ObtainNumberOfDigits(number);
		  
		  CalculateUPC(input, number, numberOfDigits, limitedDigits, codeArray);
	  }
	  
	  private static int CheckNumberOfDigits(Scanner input, int limitedDigits)
	  {
		  int number;
		  boolean valid = false;
		  do {
			  //Boolean statement to check if number is positive and contains less or equal amount of the digits required
			  number = input.nextInt();
			  if(number < 0 || (int)(number / (Math.pow(10, limitedDigits))) != 0)
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
	  
	  private static int ObtainNumberOfDigits(int number) 
	  {
		  //Returns number of digits in the user number
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
	  
	  private static void CalculateUPC(Scanner input, int number, int numberOfDigits, int limitedDigits, int[] codeArray)
	  {
		  //Separate digits into codeArray
		  SeparateDigits(number, codeArray, numberOfDigits, limitedDigits);
		  
		  //Calculate final UPC digit using codeArray
		  codeArray[limitedDigits] = CalculateUPCFinalDigit(input, codeArray);

		  ShowFinalUPCCode(input, number, codeArray[limitedDigits]);
	  }
	  
	  private static void SeparateDigits(int number, int[] digitsArray, int numberOfDigits, int limitedDigits)
	  {
		  for(int i = 0; i < limitedDigits; i++)
		  {
			  //Add 0 padding for numbers with fewer than 6 digits
			  if(i + numberOfDigits < limitedDigits)
			  {
				  //Add 0s 'numberOfDigits' times into array
				  digitsArray[i] = 0;
			  }
			  else 
			  {
				  //Add remaining digits of the input number into array
				  digitsArray[i] = (int) ((number / Math.pow(10, limitedDigits - i - 1)) % 10);
			  }
		  }
	  }
	  
	  private static int CalculateUPCFinalDigit(Scanner input, int[] codeArray)
	  { 
		  int sumOddPositions = 0, sumEvenPositions = 0;
		  int evenNumber;
		  
		//Calculates sum of digits in odd positions sum of digits in even positions
		  for(int oddNumber = 0; oddNumber < 6; oddNumber+=2)
		  {
			 evenNumber = oddNumber + 1;
			 sumOddPositions += codeArray[oddNumber];
			 sumEvenPositions += codeArray[evenNumber];
		  }
		  
		  int total = sumOddPositions*3 + sumEvenPositions;
		  int remainder = total % 10;
		  
		  return remainder == 0 ? remainder : 10 - remainder;
	  }
	  
	  private static void ShowFinalUPCCode(Scanner input, int number, int finalDigit)
	  {
		  System.out.print("The 7-digit final UPC is: ");
		  
		  //If number is 0 then final UPC code is 0 or else show final 7-digit UPC code
		  String finalUPCCode = (number == 0) ?  Integer.toString(number) : Integer.toString(number) + Integer.toString(finalDigit);
		  System.out.println(finalUPCCode + "\n");
	  }
	  
	  
	  /**************************************************************************************************************************************
	   *                                                   Universal Product Code (UPC) Checker
	   * ************************************************************************************************************************************/
	 /* Test plan:
	  * -----------
	  * 
	  *-Firstly, as a baseline, input 1234561 for userNumber and we expect it to print: 'The UPC is valid'.
	  *
	  *-Secondly, to make sure that it also checks for invalid UPC codes, input 1234569 should print: 'an error was detected in the UPC'.
	  * 
	  *-Input 1230 to make sure it also works for UPC codes with 0 paddings. Therefore, the expected output should be 'The UPC is valid'.
	  * 
	  *-Input 1231 should get the output: 'An error was detected in the UPC'.
	  *
	  *-Input 1896 should get the output 'The UPC is valid'.
	  *
	  *-Input 1895 should get the output 'An error was detected in the UPC'.
	  *
	  *-Input 0 should print 'The UPC is valid'.
	  * 
	  * */

	  private static void AccessUPCChecker(Scanner input)
	  {
		  System.out.println("Universal Product Code (UPC) Checker");
		  System.out.println("----------------------------------------");
		  System.out.println("Please enter 7-digit UPC to check: ");
		  
		  final int limitedDigits = 7;
		  
		  //Array for digits of user input number
		  int userNumber = CheckNumberOfDigits(input, limitedDigits);
		  int numberOfUserDigits = ObtainNumberOfDigits(userNumber);
		  
		  int finalUPCDigit = CalculateActualUPCFinalDigit(input, userNumber, numberOfUserDigits, limitedDigits);
		  CompareFinalDigits(finalUPCDigit, userNumber);
	  }
	  
	  private static int CalculateActualUPCFinalDigit(Scanner input, int userNumber, int numberOfUserDigits, int limitedDigits)
	  {
		  //Array for digits used to calculate UPC
		  int[] UPCArray = new int[limitedDigits];
		  
		  //Removes last digit of user input number
		  int calculatedUPC = (int) userNumber / 10;
		  
		  //Separate calculatedUPC into their lone digits
		  SeparateDigits(calculatedUPC, UPCArray, numberOfUserDigits - 1, limitedDigits - 1);
		  return CalculateUPCFinalDigit(input, UPCArray);
	  }
	  
	  private static void CompareFinalDigits(int finalUPCDigit,  int userNumber)
	  {
		  //Determine if both final digits of user input number and its UPC are equal
		  String result =  (finalUPCDigit == userNumber % 10) ? "The UPC is valid" : "An error was detected in the UPC";
		  System.out.println("\n"+result+"\n");
	  }
}
