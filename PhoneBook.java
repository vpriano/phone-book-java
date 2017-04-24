package PhoneBook;

/* 
 * File containing 8 custom test cases for PhoneEntry array.
 */

import java.util.*;

public class PhoneBook {

	static String [] names = {"Tom", "Fred", "John", "Jim", "Ann", "Lynn", "Ted", "Tommy", "Tex", "Kim"};
	static String [] numbers = {"1233", "3455", "1211", "3333", "3222", "1231", "4444", "5555", "2222", "9999"};
		/* main method to control tests to be performed.
		 * 
		 */
		public static void main (String [] args){
			char ch;
			boolean end = false;
			System.out.println ("Assignment 7");
			do
			{
				ch = getCommand();
				switch (ch)
				{
					case '1' : 	test1();
								break;
					case '2' :	test2();
								break;
					case '3' :  test3();
								break;
					case '4' :	test4();
								break;
					case '5' :	test5();
								break;
					case '6' :	test6();
								break;
					case '0' :	end = true;
								break;
				}
			} while (!end);
			System.out.println ("Program complete");
		}		
	 
		/* prompt the user to enter a test number and return it as a character
		 * 
		 */
		
		static char getCommand (){
			final Scanner input = new Scanner (System.in);
			char command;
			boolean valid;
			
			do {
				System.out.println ();
				System.out.print ("Enter test number (1..6) (0 to stop): ");
				String answer = input.next();
				command = answer.charAt(0);
				valid = command >= '0' && command <= '6';
				if (!valid)
					System.out.println ("Entry not valid, enter again");
			} while (!valid);
			return command;
		}

		/* test1
		 * 
		 * Test printAll and get on empty list
		 * 
		 */
		
		static void test1() {
			System.out.println ("Test 1: Test print and get of empty list");
			System.out.println ();
			
			ContactList book = new ContactList();
			System.out.println ("Print All");
			book.printAll();
			
			System.out.println ("Get");
			System.out.println (book.get(new PhoneEntry ("","")));
			
		}

		/* test 2
		 * 
		 * Test printAll and get on single item
		 */

		static void test2() {
			System.out.println ("Test 2: Test print and get of list of single entry");
			System.out.println ();
			
			ContactList book = new ContactList();
			book.insert(new PhoneEntry ("Tom", "4444"));
			System.out.println ("Print All");
			book.printAll();
			
			System.out.println ("Get");
			System.out.println (book.get(new PhoneEntry ("Tom", "")));
			System.out.println ("Get");
			System.out.println (book.get(new PhoneEntry ("Tim", "")));
		}

		/* test 3 
		 * 
		 * Test insert of multiple items
		*/

		static void test3(){
			System.out.println ("Test 3: Test insert in alphabetical order");
			System.out.println ();
				
			ContactList book = new ContactList();
			for (int pos = 0; pos < names.length; pos++)
				book.insert(new PhoneEntry (names[pos], ""));
			System.out.println ("Print All");
			book.printAll();
		}

		/* test 4 - 
		 * 
		 * Test insert of duplicates
		*/

		static void test4() {
			System.out.println ("Test 4: Test insert with duplicates");
			System.out.println ();
			
			ContactList book = new ContactList();
			for (int pos = 0; pos < names.length; pos++)
				book.insert(new PhoneEntry (names[pos], ""));
			
			for (int pos = 0; pos < names.length; pos += 2)
				book.insert(new PhoneEntry (names[pos], ""));
			System.out.println ("Print All");
			book.printAll();
		}

		/* test 5
		 * 
		 * Test delete
		 * 
		 */
		
		static void test5() {
			
			System.out.println ("Test 5: Test delete");
			System.out.println ();
			ContactList book = new ContactList();
			for (int pos = 0; pos < names.length; pos++)
				book.insert(new PhoneEntry (names[pos], numbers[pos]));
			for (int pos = 0; pos < names.length; pos += 2)
				book.delete(new PhoneEntry (names[pos], ""));
		
			book.printAll();
		}
		
		/* test 6 
		 * 
		 * Test delete duplicates
 		 */		
	 
		static void test6(){
			System.out.println ("Test 6: Testing delete duplicates");
			System.out.println ();
			
			ContactList book = new ContactList();
			for (int pos = 0; pos < names.length; pos++)
				book.insert(new PhoneEntry (names[pos], numbers[pos]));
			for (int pos = 0; pos < names.length; pos += 2)
				book.delete(new PhoneEntry (names[pos], ""));
			for (int pos = 0; pos < names.length; pos += 2)
				book.delete(new PhoneEntry (names[pos], ""));
		
			book.printAll();
		}
}