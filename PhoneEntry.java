package PhoneBook;

public class PhoneEntry implements Comparable<PhoneEntry>{

	// protected instance variables for entry name, phone number, and note
	
		protected String name;
		protected String phone;
		
	// constructor
		
		// set the instance variables to the two parameters.
		
		PhoneEntry (String newName, String newPhone) {
			name = newName;
			phone = newPhone;
		}
				
	// accessors
		
		// return the instances variables as one string
		
		public String toString () {
			return name + "\t" + phone;
		}
		
		// return true if the parameter matches the name, false otherwise
		
		public int compareTo (PhoneEntry other){
			return name.compareTo(other.name);
		}
						
	// mutator
		
		// set the phone number to the parameter value
		
		public void changePhone (String newPhone) {
			phone = newPhone;
		}
}